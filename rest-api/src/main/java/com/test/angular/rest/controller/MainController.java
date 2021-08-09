package com.test.angular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.angular.rest.dao.UserModel;
import com.test.angular.rest.dao.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*", maxAge=3600)
public class MainController {

	@Autowired
	UserRepository 		userRepository;		
	
	@Autowired
	PasswordEncoder 	passwordEncoder;		
	
	@PostMapping("/save")
	public Mono<Integer> saveUser(@RequestBody Mono<UserModel> model) {
		return model
				.doOnNext(user -> user.setPassword(passwordEncoder.encode(user.getPassword())))
  				.flatMap(user -> userRepository.save(user).map(UserModel::getId));
	}

	@PostMapping("/update")
	public Mono<Integer> updateUser(@RequestBody Mono<UserModel> model) {
		return model
		.doOnNext(user -> user.setPassword(passwordEncoder.encode(user.getPassword())))
		.flatMap(user -> userRepository.findById(user.getId()).map(u -> {
			user.setOldPassword(u.getPassword());
			return user;
		}))
		.doOnNext(user -> {
			//If password not defined - save old password
			if (user.getPassword() == null || user.getPassword().isEmpty()) {
				user.setPassword(user.getOldPassword());
			}
			else {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			}
		})
		.flatMap(user -> userRepository.save(user).map(UserModel::getId));
	}
	
	@GetMapping("/list")
    public Flux<UserModel> participantsList() {
        return userRepository.findAll();
    }

}
