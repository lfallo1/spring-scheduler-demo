package com.lancefallon.usermgmt.films.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FilmScheduler {
	
//	@Autowired
//	private FilmService filmService;
//	
//	@Autowired
//	private EmailService<EmailConfigFilms> emailService;
	
	/**
	 * run every day at 13:48:00
	 * @throws InterruptedException 
	 */
//	@Scheduled(cron = "0 48 13 * * *")
	@Scheduled(fixedDelay = 15000, initialDelay=7000)
	public void emailFilmReport() throws InterruptedException{
//		EmailConfigFilms config = new EmailConfigFilms();
//		config.setTo("fallon.lance@gmail.com");
//		config.setSubject("Nightly film report");
//		config.setTemplate("velocity/nightlyFilmSummary.vm");
//		config.setFilms(filmService.findAll());
//		emailService.sendMail(config);
	}
	
	/**
	 * run every five seconds, with an initial 1 second delay
	 */
	@Scheduled(fixedDelay = 60000*60, initialDelay=1000)
	public void addDummyFilms() {
//		for(int i = 0; i < 50; i++){
//			String title = "johndoe_" + new Date().getTime();
//			Film film = new Film(null, title, "action", new Date());
//			Integer newFilmId = filmService.addFilm(film);
//			System.out.println("New film added: filmId#" + newFilmId);	
//		}
	}
	
}
