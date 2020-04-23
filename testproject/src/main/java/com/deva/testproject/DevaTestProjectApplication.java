package com.deva.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DevaTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevaTestProjectApplication.class, args);
	}

}
