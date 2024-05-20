package com.apirest.webflux.controller;

import com.apirest.webflux.document.Job;
import com.apirest.webflux.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping(value= "/job")
	public Flux<Job> getNotification(){
		return jobService.findAll();
	}
	
	
	@GetMapping(value= "/job/{id}")
	public Mono<Job> getNotificationId(@PathVariable String id){
		return jobService.findById(id);
	}


	@PostMapping("/job")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Job> createJob(@RequestBody Job job) {
		return jobService.createJob(job);
	}

}
