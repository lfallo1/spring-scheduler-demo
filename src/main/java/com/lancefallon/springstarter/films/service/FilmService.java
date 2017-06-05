package com.lancefallon.springstarter.films.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancefallon.springstarter.films.model.Film;
import com.lancefallon.springstarter.films.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;

	public List<Film> findAll(){
		return filmRepository.findAll();
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
