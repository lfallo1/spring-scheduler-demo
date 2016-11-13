package com.lancefallon.usermgmt.config.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * helper class to store app properties. this class should be created as a bean,
 * and fill the properties
 * 
 * @author lancefallon
 *
 */
@Component
public class AppProperties {

	@Value("${email.host}")
	private String emailHost;

	@Value("${email.port}")
	private int emailPort;

	public String getEmailHost() {
		return emailHost;
	}

	public int getEmailPort() {
		return emailPort;
	}

}
