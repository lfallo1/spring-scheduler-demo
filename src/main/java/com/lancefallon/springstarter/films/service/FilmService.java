package com.lancefallon.springstarter.films.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancefallon.springstarter.config.event.CustomApplicationEventPublisher;
import com.lancefallon.springstarter.films.event.FilmAddedEvent;
import com.lancefallon.springstarter.films.model.Film;
import com.lancefallon.springstarter.films.repository.FilmRepository;

@Service
public class FilmService {
	
	private static final Logger logger = LoggerFactory.getLogger(FilmService.class);
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private CustomApplicationEventPublisher eventPublisher;

	public List<Film> findAll(){
		return filmRepository.findAll();
	}
	
	public Film findById(Integer id){
		return filmRepository.findById(id);
	}
	
	public Integer addFilm(Film film){
		Integer result = filmRepository.addFilm(film);
		if(result > 0){
			eventPublisher.publish(new FilmAddedEvent(film));
		}
		return result;
	}
	
	public Map<Integer, String> getFilmsMap(){
		logger.info("##LOGGER=> loading films map");
		return filmRepository.findAll().stream()
				.collect(Collectors.toMap(u->u.getId(), u->u.getTitle()));
	}
}
