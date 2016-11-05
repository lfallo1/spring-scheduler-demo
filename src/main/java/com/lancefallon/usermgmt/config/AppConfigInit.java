package com.lancefallon.usermgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lancefallon.usermgmt.config.domain.AppConfig;

@Configuration
public class AppConfigInit {
	
	@Bean
	public AppConfig generateAppConfig(){
		AppConfig config = new AppConfig();
		config.setSendgridApiKey("Z9uEf1ApQqupYtwwacWzLg");
		config.setEmailHost("127.0.0.1");
		config.setEmailPort(1025);
		return config;
	}
	
}
