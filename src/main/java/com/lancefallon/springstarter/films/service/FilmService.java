package com.lancefallon.springstarter.films.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancefallon.springstarter.films.event.FilmRetrievedEvent;
import com.lancefallon.springstarter.films.event.FilmRetrievedEventPublisher;
import com.lancefallon.springstarter.films.model.Film;
import com.lancefallon.springstarter.films.repository.FilmRepository;

@Service
public class FilmService {
	
	private static final Logger logger = LogManager.getLogger(FilmService.class);
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmRetrievedEventPublisher filmRetrievedEventPublisher;

	public List<Film> findAll(){
		List<Film> films = filmRepository.findAll();
		filmRetrievedEventPublisher.publish(new FilmRetrievedEvent(films));
		logger.info("##LOGGER=> " + films.toString());
		return films;
	}
	
	public Film findById(Integer id){
		return filmRepository.findById(id);
	}
	
	public Integer addFilm(Film film){
		return filmRepository.addFilm(film);
	}
	
	public Map<Integer, String> getFilmsMap(){
		return filmRepository.findAll().stream()
				.collect(Collectors.toMap(u->u.getId(), u->u.getTitle()));
	}
}
