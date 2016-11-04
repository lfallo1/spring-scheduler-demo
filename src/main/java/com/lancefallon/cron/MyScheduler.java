package com.lancefallon.cron;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {
	
	private int count;
		
	public MyScheduler(){
		count = 0;
	}
	
	/**
	 * run every day at 13:48:00
	 * @throws InterruptedException 
	 */
//	@Scheduled(cron = "0 48 13 * * *")
	public void doSomething() throws InterruptedException{
		System.out.println("doSomething is " + ++count + ": running cron at " + new Date().toString());
	}
	
	/**
	 * run every five seconds, with an initial 1 second delay
	 */
	@Scheduled(fixedDelay = 5000, initialDelay=1000)
	public void doSomethingElse() {
		System.out.println("doSomethingElse is " + ++count + ": running cron at " + new Date().toString());
	}
	
}
