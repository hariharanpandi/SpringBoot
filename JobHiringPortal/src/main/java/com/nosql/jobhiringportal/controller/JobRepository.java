package com.nosql.jobhiringportal.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nosql.jobhiringportal.model.ListOfJob;

@Repository
public interface JobRepository extends MongoRepository<ListOfJob, String> {

}
