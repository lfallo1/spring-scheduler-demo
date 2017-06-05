package com.lancefallon.springstarter.config.jms;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

	@Value("${messagequeues.text.healthcheck}")
	private String textMsgHealthcheckQueue;

	@Bean
	public Queue textMessageHealthCheckQueue() {
		return new ActiveMQQueue(textMsgHealthcheckQueue);
	}
}
