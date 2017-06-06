package com.lancefallon.springstarter.config.actuator.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.config.jms.JmsTextMessageServiceImpl;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Autowired
	private JmsTextMessageServiceImpl jmsTextMessageServiceImpl;

	@Override
	public Health health() {
//		if (new Random().nextBoolean()) {
//			String msg = String.format("%s : %s", "ERR-001", "Dummy failure");
//			jmsTextMessageServiceImpl.sendTextMessage(msg);
//			return Health.down().withDetail("ERR-001", "Dummy failure").build();
//		}
		jmsTextMessageServiceImpl.sendTextMessage("##JmsTextMessageServiceImpl::sendTextMessage => sending health update");
		return Health.up().build();
	}

}