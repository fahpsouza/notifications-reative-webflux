package com.apirest.webflux.services;

import com.apirest.webflux.document.User;
import com.apirest.webflux.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRespository userRespository;

	@Override
	public Flux<User> findAll() {return userRespository.findAll();}

	@Override
	public Mono<User> findById(String id) {
		return userRespository.findById(id);
	}

	@Override
	public Mono<User> save(User user) {
		return userRespository.save(user);
	}

	@Override
	public void unsubscribe(String id) {
		 userRespository.findById(id)
				.map(user -> {
					user.setAcceptReceivingNotifications(false);
					return userRespository.save(user);
				});
	}


}
