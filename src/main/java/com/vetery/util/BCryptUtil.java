package com.vetery.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptUtil {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Bean
	public BCryptPasswordEncoder getEncoder () {
		return encoder;
	}
}
