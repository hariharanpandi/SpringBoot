package com.nosql.jobhiringportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nosql.jobhiringportal.controller.JobRepository;
import com.nosql.jobhiringportal.model.ListOfJob;

@Service
public class JobServices {

	@Autowired
	JobRepository repository;

	public ListOfJob createjob(ListOfJob listOfJob) {
		
	return repository.save(listOfJob);
	}
}
