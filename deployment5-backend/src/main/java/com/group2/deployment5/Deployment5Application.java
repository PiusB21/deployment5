package com.group2.deployment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Deployment5Application {

	public static void main(String[] args) {
		SpringApplication.run(Deployment5Application.class, args);
	}

}
