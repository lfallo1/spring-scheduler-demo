package com.lancefallon.usermgmt.config.domain;

/**
 * helper class to store app properties.
 * this class should be created as a bean, and fill the properties
 * @author lancefallon
 *
 */
public class AppProperties {

	private String sendgridApiKey;
	private String emailHost;
	private int emailPort;

	public String getSendgridApiKey() {
		return sendgridApiKey;
	}

	public void setSendgridApiKey(String sendgridApiKey) {
		this.sendgridApiKey = sendgridApiKey;
	}

	public String getEmailHost() {
		return emailHost;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public int getEmailPort() {
		return emailPort;
	}

	public void setEmailPort(int emailPort) {
		this.emailPort = emailPort;
	}

}
