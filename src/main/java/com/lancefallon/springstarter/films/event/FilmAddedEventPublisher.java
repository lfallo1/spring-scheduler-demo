package com.lancefallon.springstarter.films.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.config.event.CustomApplicationEventPublisher;

/**
 * publisher that handles publishing of film-added events
 * 
 * @author lfallon
 *
 */
@Component
public class FilmAddedEventPublisher extends CustomApplicationEventPublisher {

	private static final Logger logger = LogManager.getLogger(FilmAddedEventPublisher.class);

	@Override
	public void publish(ApplicationEvent event) {
		logger.debug("##FilmAddedEventPublisher::publish => publishing event ");
		super.publish(event);
	}
}