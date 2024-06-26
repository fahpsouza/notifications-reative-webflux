package com.apirest.webflux.repository;

import com.apirest.webflux.document.Job;
import com.apirest.webflux.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRespository extends ReactiveMongoRepository<User, String> {
    Mono<User> findById(String userId);
}
