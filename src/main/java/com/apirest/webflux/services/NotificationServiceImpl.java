package com.apirest.webflux.services;

import com.apirest.webflux.document.Notification;
import com.apirest.webflux.repository.NotificationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationRespository notificationRespository;

	@Override
	public Flux<Notification> findAll() {
		return notificationRespository.findAll();
	}

	@Override
	public Mono<Notification> findById(String id) {
		return notificationRespository.findById(id);
	}

	@Override
	public Mono<Notification> save(Notification notification) {
		return notificationRespository.save(notification);
	}

	@Override
	public Mono<Void> delete(Notification notification) {
		return notificationRespository.deleteById(notification.getId());
	}

	@Override
	public Flux<Notification> findAllByUserId(String userId) {
		return notificationRespository.findAllByUserId(userId);
	}

}
