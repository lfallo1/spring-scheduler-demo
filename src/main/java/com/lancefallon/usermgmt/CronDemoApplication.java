package com.lancefallon.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring boot - Entry point
 * @author lancefallon
 *
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages="com.lancefallon.usermgmt")
public class CronDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronDemoApplication.class, args);
	}
}
