package com.drool.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.drool.customer")
public class LearningDroolApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningDroolApplication.class, args);
	}

}
