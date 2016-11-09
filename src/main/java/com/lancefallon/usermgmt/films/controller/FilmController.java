package com.lancefallon.usermgmt.films.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lancefallon.usermgmt.config.security.domain.CustomUserPasswordAuthenticationToken;
import com.lancefallon.usermgmt.films.model.Film;
import com.lancefallon.usermgmt.films.service.FilmService;

/**
 * user api endpoint
 * @author lancefallon
 *
 */
@RestController
@RequestMapping("api/films")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Film>> findAllFilms(){
		return new ResponseEntity<>(filmService.findAll(), HttpStatus.OK);
	}
	 
	@RequestMapping(value="/auth/{username}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN') and @authService.isSelf(#auth, #username)")
	public ResponseEntity<List<Film>> findAllFilmsAuth(OAuth2Authentication auth, @PathVariable String username){
		CustomUserPasswordAuthenticationToken token = (CustomUserPasswordAuthenticationToken) auth.getUserAuthentication();
		System.out.println(token.getUserPrivileges().getDefaultDB());
		return new ResponseEntity<>(filmService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{filmId}", method=RequestMethod.GET)
	public ResponseEntity<Film> findAllFilms(@PathVariable Integer filmId){
		return new ResponseEntity<>(filmService.findById(filmId), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public ResponseEntity<Map<Integer, String>> generateUserMap(){
		return new ResponseEntity<>(filmService.getFilmsMap(), HttpStatus.OK);
	}
}
