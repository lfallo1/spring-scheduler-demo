package com.lancefallon.springstarter.config.jms.Listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.config.jms.JmsConfig;

@Component
public class HealthCheckListener {
	
	private static final Logger logger = LogManager.getLogger(HealthCheckListener.class);
	
    @JmsListener(destination = JmsConfig.textMsgHealthcheckQueue)
    public void onMessage(String msg){
    	logger.info("#### " + msg + " ###" );
    }
}
