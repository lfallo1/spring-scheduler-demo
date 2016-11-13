package com.lancefallon.usermgmt.config;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

import com.lancefallon.usermgmt.config.filter.CustomFilter;
import com.lancefallon.usermgmt.config.model.AppProperties;

/**
 * primary initialization class. creates various beans for email, velocity, and
 * filters
 * 
 * @author lancefallon
 *
 */
@Configuration
public class ServletConfiguration implements EmbeddedServletContainerCustomizer {

	@Autowired
	private AppProperties appConfig;

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
		return new CustomFilter();
	}

	/**
	 * configure 404s to be redirected to a request mapper that accepts routes
	 * of 404.html
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
	}
}
