package com.lancefallon.usermgmt.users.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lancefallon.usermgmt.common.email.domain.EmailConfigUsers;
import com.lancefallon.usermgmt.common.email.service.EmailService;
import com.lancefallon.usermgmt.users.service.UserService;

@Component
public class UserScheduler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService<EmailConfigUsers> emailService;
	
	/**
	 * run every day at 13:48:00
	 * @throws InterruptedException 
	 */
//	@Scheduled(cron = "0 48 13 * * *")
	@Scheduled(fixedDelay = 15000, initialDelay=7000)
	public void emailUserReport() throws InterruptedException{
//		EmailConfigUsers config = new EmailConfigUsers();
//		config.setTo("fallon.lance@gmail.com");
//		config.setSubject("Nightly user report");
//		config.setTemplate("velocity/nightlyUserSummary.vm");
//		config.setUsers(userService.findAll());
//		emailService.sendMail(config);
	}
	
	/**
	 * run every five seconds, with an initial 1 second delay
	 */
	@Scheduled(fixedDelay = 60000*60, initialDelay=1000)
	public void addDummyUser() {
//		for(int i = 0; i < 50; i++){
//			String username = "johndoe_" + new Date().getTime();
//			User user = new User(null, username, username + "gmail.com", new Date());
//			Integer newUserId = userService.addUser(user);
//			System.out.println("New user added: userId#" + newUserId);	
//		}
	}
	
}
