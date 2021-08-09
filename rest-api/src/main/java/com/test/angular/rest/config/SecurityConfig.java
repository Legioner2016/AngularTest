package com.test.angular.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
	    return http
	    		.httpBasic()
	            .and()
	            .authorizeExchange()
	            .pathMatchers(HttpMethod.OPTIONS).permitAll()
	    		.and()
	    		.authorizeExchange()
	    		.anyExchange().authenticated()
	    		.and().csrf().disable().build();
	}
	
}
