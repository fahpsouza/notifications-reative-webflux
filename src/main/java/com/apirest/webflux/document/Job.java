package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job")
public class Job {

	public Job(String id, String jobName, Long intervalTime, Boolean isActivatedJob, String jobNameDescription, String userId) {
		super();
		this.id = id;
		this.jobName = jobName;
		this.jobNameDescription = jobNameDescription;
		this.intervalTime = intervalTime;
		this.isActivatedJob = isActivatedJob;
		this.userId = userId;
	}

	@Id
	private String id;

	@Indexed
	private String jobName;
	private String jobNameDescription;
	private Long intervalTime = 0L;
	private Boolean isActivatedJob = true;
	private String userId;


    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Long getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Long intervalTime) {
		this.intervalTime = intervalTime;
	}

	public Boolean getActivatedJob() {
		return isActivatedJob;
	}

	public void setActivatedJob(Boolean activatedJob) {
		isActivatedJob = activatedJob;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user) {
		this.userId = userId;
	}

	public String getJobNameDescription() {
		return jobNameDescription;
	}

	public void setJobNameDescription(String jobNameDescription) {
		this.jobNameDescription = jobNameDescription;
	}

}
