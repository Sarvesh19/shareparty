package com.shareparty.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate; 

@Configuration
public class UserPasswordConfig {
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
	
	 @Bean
	    @Scope("singleton")
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		}

}
