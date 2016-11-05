package com.lancefallon.usermgmt.common.email.domain;

public class EmailConfig {

	private String to;
	private String subject;
	private String template;

	public EmailConfig() {
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
