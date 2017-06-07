package com.lancefallon.springstarter.films.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.films.model.Film;
import com.lancefallon.springstarter.films.service.FilmService;

@Component
public class FilmScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(FilmScheduler.class);
	
	@Autowired
	private FilmService filmService;
//	
//	@Autowired
//	private EmailService<EmailConfigFilms> emailService;
	
	/**
	 * run every day at 13:48:00
	 * @throws InterruptedException 
	 */
//	@Scheduled(cron = "0 48 13 * * *")
	public void emailFilmReport() throws InterruptedException{
//		EmailConfigFilms config = new EmailConfigFilms();
//		config.setTo("fallon.lance@gmail.com");
//		config.setSubject("Nightly film report");
//		config.setTemplate("velocity/nightlyFilmSummary.vm");
//		config.setFilms(filmService.findAll());
//		emailService.sendMail(config);
	}
	
	/**
	 * run every 60 seconds, with an initial 1 second delay
	 */
	@Scheduled(fixedDelay = 60000, initialDelay=1000)
	public void addDummyFilms() {
		String title = "johndoe_" + new Date().getTime();
		Film film = new Film(null, title, "action", new Date());
		Integer newFilmId = filmService.addFilm(film);
		logger.info("##New film added: filmId#" + newFilmId);	
	}
	
}
