package com.lancefallon.usermgmt.films.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lancefallon.usermgmt.films.model.Film;

@Service
public class FilmService {
	
	private List<Film> films = new ArrayList<>();
	
	{
		Calendar c1 = Calendar.getInstance();
		c1.set(1970, 1, 1);
		films.add(new Film(1, "Jaws", "Horror", c1.getTime()));
		
		Calendar c2 = Calendar.getInstance();
		c2.set(1973, 5, 16);
		films.add(new Film(2, "Star Wars", "Sci-fi", c2.getTime()));
	}

	public List<Film> findAll(){
		return films;
	}
	
	public Film findById(Integer id){
		Optional<Film> film = films.stream().filter(f->f.getId().equals(id)).findFirst();
		return film.isPresent() ? film.get() : null;
	}
	
	public Map<Integer, String> getFilmsMap(){
		return films.stream()
				.collect(Collectors.toMap(u->u.getId(), u->u.getTitle()));
	}
}
