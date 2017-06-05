package com.lancefallon.springstarter.films.event;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * a second handler / listener for FilmAddedEvent events just to show that their can be many handlers/listeners that register for events
 * @author lfallon
 *
 */
@Component
public class FilmAddedEventHandlerAlternate implements ApplicationListener<FilmAddedEvent> {
	
	private static final Logger logger = LogManager.getLogger(FilmAddedEventHandler.class);
	
	@Override
	public void onApplicationEvent(FilmAddedEvent event) {
		logger.info("##FilmAddedEventHandlerAlternate Hello from FilmEventHandlerAlternate::onApplicationEvent");
	}
}
