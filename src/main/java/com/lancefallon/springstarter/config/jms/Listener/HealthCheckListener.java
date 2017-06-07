package com.lancefallon.springstarter.config.jms.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckListener {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthCheckListener.class);
	
    @JmsListener(destination = "${messagequeues.text.healthcheck}")
    public void onMessage(String msg){
    	logger.info("#### " + msg + " ###" );
    }
}
