package com.test.angular.rest.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserModel, Integer> {

	Mono<UserModel> findByLogin(String login);
	
}
