package com.lancefallon.springstarter.films.event;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(FilmAddedEventHandler.class);
	
	@Override
	public void onApplicationEvent(FilmAddedEvent event) {
		Film film = (Film) event.getSource();
		logger.info("##FilmAddedEventHandler => added film " + film.toString() + " at " + new Date().toString());
	}
}
