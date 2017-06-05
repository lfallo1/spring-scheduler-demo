package com.lancefallon.springstarter.config.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.films.model.Film;

@Component
public class CustomAppEndpoint extends AbstractEndpoint<Film> {

	public CustomAppEndpoint() {
		super("customAppEndpoint", false);
	}

	@Override
	public Film invoke() {
		Film film = new Film();
		film.setTitle("Random film title");
		return film;
	}

}
