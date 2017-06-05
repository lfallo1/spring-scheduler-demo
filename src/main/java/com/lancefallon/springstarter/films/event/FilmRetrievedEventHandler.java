package com.lancefallon.springstarter.films.event;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.films.model.Film;

@Component
public class FilmRetrievedEventHandler implements ApplicationListener<FilmRetrievedEvent> {
	@Override
	public void onApplicationEvent(FilmRetrievedEvent event) {

		List<Film> films = (List<Film>) event.getSource();
		System.out.println("##retrieved " + films.size() + " films at " + new Date().toString());
	}
}
