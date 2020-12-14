package com.spring.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/actuator/info").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/addCustomer").setViewName("addCustomer");
		registry.addViewController("/addMovie").setViewName("addMovie");
		registry.addViewController("/addTicket").setViewName("addTicket");
		registry.addViewController("/bookingSuccess").setViewName("bookingSuccess");
		registry.addViewController("/listOfCustomers").setViewName("listOfCustomers");
		registry.addViewController("/listOfTickets").setViewName("listOfTickets");
		registry.addViewController("/updateCustomer").setViewName("updateCustomer");
		registry.addViewController("/updateMovie").setViewName("updateMovie");
		registry.addViewController("/updateTicket").setViewName("updateTicket");
	}
}
