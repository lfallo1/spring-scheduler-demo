package com.lancefallon.usermgmt.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

import com.lancefallon.usermgmt.config.db.domain.DbType;
import com.lancefallon.usermgmt.config.db.service.DbRoutingDataSourceUtil;
import com.lancefallon.usermgmt.config.domain.AppProperties;
import com.lancefallon.usermgmt.config.filter.DbFilter;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * primary initialization class. creates various beans for email, velocity, and
 * filters
 * 
 * @author lancefallon
 *
 */
@Configuration
public class ServletConfiguration {

	@Autowired
	private AppProperties appConfig;

	public DataSource getDefaultDataSource() {

		/**
		 * primary datasource
		 */
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(appConfig.getDbDriver());
			dataSource.setJdbcUrl(appConfig.getDbDefaultUrl());
			dataSource.setUser(appConfig.getDbUsername());
			dataSource.setPassword(appConfig.getDbPassword());
			dataSource.setMaxPoolSize(1000);
			dataSource.setMinPoolSize(10);
			dataSource.setMaxStatements(5);
			dataSource.setStatementCacheNumDeferredCloseThreads(1);
			dataSource.setNumHelperThreads(20);
		} catch (Exception e) {
			String message = "An error has occurred.Please contact System Administrator";
			System.out.println(message + ": " + e.getMessage());
		}
		return dataSource;
	}

	/**
	 * backup datasource
	 * 
	 * @return
	 */
	public DataSource getBackupDataSource() {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(appConfig.getDbDriver());
			dataSource.setJdbcUrl(appConfig.getDbBackupUrl());
			dataSource.setUser(appConfig.getDbUsername());
			dataSource.setPassword(appConfig.getDbPassword());
			dataSource.setMaxPoolSize(1000);
			dataSource.setMinPoolSize(10);
			dataSource.setMaxStatements(5);
			dataSource.setStatementCacheNumDeferredCloseThreads(1);
			dataSource.setNumHelperThreads(20);
		} catch (Exception e) {
			String message = "An error has occurred.Please contact System Administrator";
			System.out.println(message + ": " + e.getMessage());
		}
		return dataSource;
	}

	/**
	 * configure the abstract datasource util to allow multiple possible dbs to
	 * be used. the datasource to be used determined during execution of
	 * application
	 * 
	 * @return
	 */
	@Bean
	@Qualifier("primary")
	public DataSource getDbRoutingDataSourceUtil() {
		DbRoutingDataSourceUtil DbRoutingDataSourceUtil = new DbRoutingDataSourceUtil();

		HashMap<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DbType.DB_DEFAULT, getDefaultDataSource());
		targetDataSources.put(DbType.DB_BACKUP, getBackupDataSource());
		DbRoutingDataSourceUtil.setTargetDataSources(targetDataSources);
		return DbRoutingDataSourceUtil;
	}

	/**
	 * configure velocity templating engine for emails
	 * 
	 * @return
	 * @throws VelocityException
	 * @throws IOException
	 */
	@Bean
	public VelocityEngine generateVelocityTemplate() throws VelocityException, IOException {
		VelocityEngineFactory factory = new VelocityEngineFactory();
		Properties props = new Properties();
		props.put("resource.loader", "class");
		props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		factory.setVelocityProperties(props);
		return factory.createVelocityEngine();
	}

	/**
	 * configure the email server
	 * 
	 * @return
	 */
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(appConfig.getEmailHost());
		sender.setPort(appConfig.getEmailPort());
		return sender;
	}

	/**
	 * add filter to set the db context on requests
	 * 
	 * @return
	 */
	@Bean
	public Filter dbFilter() {
		return new DbFilter();
	}

	/**
	 * configure primary flyway datasource
	 * 
	 * @return
	 */
	@Bean
	@FlywayDataSource
	@Primary
	public DataSource flywayDataSource() {
		return getDefaultDataSource();
	}

	/**
	 * manually migrate any non-primary datasources
	 */
	@PostConstruct
	public void migrateFlyway() {
		Flyway flyway = new Flyway();

		//syndication_backup database
		flyway.setLocations(appConfig.getFlywayLocations());
		flyway.setTarget(MigrationVersion.LATEST);
		flyway.setDataSource(getBackupDataSource());
		flyway.migrate();	
	}
}
