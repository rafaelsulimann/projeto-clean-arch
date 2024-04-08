package com.sulimann.cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CleanArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchApplication.class, args);
	}

}
