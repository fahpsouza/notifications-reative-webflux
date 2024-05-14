package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.webflux.document.Notification;

public interface NotificationRespository extends ReactiveMongoRepository<Notification, String>{

}
