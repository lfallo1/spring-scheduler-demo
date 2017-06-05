package com.lancefallon.springstarter.common.email.model;

import java.util.List;

import com.lancefallon.springstarter.films.model.Film;

/**
 * Email config for user related emails
 * @author lancefallon
 *
 */
public class EmailConfigFilms extends EmailConfig {

	private List<Film> films;

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
