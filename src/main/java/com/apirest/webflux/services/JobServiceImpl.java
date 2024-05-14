package com.apirest.webflux.services;

import com.apirest.webflux.document.Job;
import com.apirest.webflux.document.Notification;
import com.apirest.webflux.document.User;
import com.apirest.webflux.repository.JobRespository;
import com.apirest.webflux.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	JobRespository jobRespository;

	@Override
	public Flux<Job> findAll() {
		return jobRespository.findAll();
	}

	@Override
	public Mono<Job> findById(String id) {
		return jobRespository.findById(id);
	}

	@Override
	public Mono<Job> save(Job job) {return jobRespository.save(job);}

	public Mono<Job> createJob(Job job) {
		return jobRespository.findByUserId(job.getUserId())
				.flatMap(dbJob -> Mono.<Job>error(new Exception("Job already exists for this user")))
				.switchIfEmpty(jobRespository.save(job));
	}

}
