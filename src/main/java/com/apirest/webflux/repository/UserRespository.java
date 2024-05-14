package com.apirest.webflux.repository;

import com.apirest.webflux.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRespository extends ReactiveMongoRepository<User, String> {


}
