package com.apirest.webflux.controller;

import com.apirest.webflux.document.User;
import com.apirest.webflux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(value= "/user")
	public Flux<User> getUsers(){return userService.findAll();}
	
	
	@GetMapping(value= "/user/{id}")
	public Mono<User> getUserId(@PathVariable String id){
		return userService.findById(id);
	}


	@PostMapping(value= "/user")
	public Mono<User> save(@RequestBody User user){
		return userService.save(user);
	}

//	@PostMapping("/user/unsubscribe")
//	public Mono<User> unsubscribe(@RequestBody String id) {
//		return userRespository.findById(id)
//				.map(user -> {
//					user.setAcceptReceivingNotifications(false);
//					return userRespository.save(user);)
//
//				});
//	}

}
