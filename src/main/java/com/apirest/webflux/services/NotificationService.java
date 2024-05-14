package com.apirest.webflux.services;

import com.apirest.webflux.document.Notification;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NotificationService {
	
	Flux<Notification> findAll();
	Mono<Notification> findById(String id);
	Mono<Notification> save(Notification notification);

}
