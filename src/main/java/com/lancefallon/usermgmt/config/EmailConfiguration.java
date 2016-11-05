package com.lancefallon.usermgmt.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

import com.lancefallon.usermgmt.config.domain.AppConfig;

@Configuration
public class EmailConfiguration {

	@Autowired
	private AppConfig appConfig;
	
	@Bean
	public VelocityEngine generateVelocityTemplate() throws VelocityException, IOException{
		VelocityEngineFactory factory = new VelocityEngineFactory();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        factory.setVelocityProperties(props);
        return factory.createVelocityEngine();
	}
	
	@Bean
	public JavaMailSenderImpl mailSender(){
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(appConfig.getEmailHost());
		sender.setPort(appConfig.getEmailPort());
		return sender;
	}
	
}
