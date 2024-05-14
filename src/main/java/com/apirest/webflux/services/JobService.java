package com.apirest.webflux.services;

import com.apirest.webflux.document.Job;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JobService {

    Flux<Job> findAll();
    Mono<Job> findById(String id);
    Mono<Job> save(Job job);
    Mono<Job> createJob(Job job);
}
