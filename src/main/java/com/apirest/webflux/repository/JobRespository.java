package com.apirest.webflux.repository;

import com.apirest.webflux.document.Job;
import com.apirest.webflux.document.Notification;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface JobRespository extends ReactiveMongoRepository<Job, String>{
    Mono<Job> findByUserId(String userId);
}
