package com.test.angular.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.test.angular.rest.dao.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserDetailService implements ReactiveUserDetailsService {

	@Autowired
	UserRepository	userRepository;
	
	@Override
	public Mono<UserDetails> findByUsername(String username) {
		return userRepository.findByLogin(username).map(u -> 
			User.withUsername(u.getLogin()).password(u.getPassword()).roles("USER").build());
	}

	
	
}
