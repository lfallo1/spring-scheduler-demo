package com.lancefallon.springstarter.films.event;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.films.model.Film;

/**
 * handler for film-added events
 * @author lfallon
 *
 */
@Component
public class FilmAddedEventHandler implements ApplicationListener<FilmAddedEvent> {
	
	private static final Logger logger = LoggerFactory.getLogger(FilmAddedEventHandler.class);
	
	@Override
	public void onApplicationEvent(FilmAddedEvent event) {
		Film film = (Film) event.getSource();
		logger.info("##FilmAddedEventHandler => added film " + film.toString() + " at " + new Date().toString());
	}
}
