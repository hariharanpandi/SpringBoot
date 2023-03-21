package com.nosql.jobhiringportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nosql.jobhiringportal.model.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}
