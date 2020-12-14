package com.spring.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTicketCustomerWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketCustomerWebAppApplication.class, args);
		System.out.println("Movie Ticket Customer JPA Web App started.");
	}

}
