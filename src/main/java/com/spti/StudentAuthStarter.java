package com.spti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentAuthStarter {
	public static void main(String[] args) {
		SpringApplication.run(StudentAuthStarter.class, args);
	}
}
