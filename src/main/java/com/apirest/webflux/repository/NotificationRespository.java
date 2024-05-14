package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.webflux.document.Notification;
import reactor.core.publisher.Flux;

public interface NotificationRespository extends ReactiveMongoRepository<Notification, String>{
    Flux<Notification> findAllByUserId(String userId);
}
