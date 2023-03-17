package com.product.joblisting.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.joblisting.model.JobPortal;

public interface JobRepository extends MongoRepository<JobPortal, Integer> {

}
