package com.lancefallon.springstarter.films.event;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.films.model.Film;

@Component
public class FilmRetrievedEventHandler implements ApplicationListener<FilmRetrievedEvent> {
	
	private static final Logger logger = LogManager.getLogger(FilmRetrievedEventHandler.class);
	
	@Override
	public void onApplicationEvent(FilmRetrievedEvent event) {

		List<Film> films = (List<Film>) event.getSource();
		logger.info("##retrieved " + films.size() + " films at " + new Date().toString());
	}
}
