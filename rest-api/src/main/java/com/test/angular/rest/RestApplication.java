package com.test.angular.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Main rest resource 
 * 
 * @author legioner
 *
 */
@EnableWebFlux
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ReactiveSecurityAutoConfiguration.class})
public class RestApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
