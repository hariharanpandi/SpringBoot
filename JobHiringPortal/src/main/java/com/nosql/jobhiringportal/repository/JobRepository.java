package com.nosql.jobhiringportal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nosql.jobhiringportal.model.ListOfJob;

public interface JobRepository extends MongoRepository<ListOfJob, String> {

	List<ListOfJob> findByName(String name);

	List<ListOfJob> findByDepartmentDepartmentname(String departmentname);

	List<ListOfJob> findByNameAndProfile(String name, String profile);

	List<ListOfJob> findByProfileOrName(String profile, String name);
	
	List<ListOfJob> findBySkill(String skill);
	
	List<ListOfJob> findByDescriptionIsLike (String description);
	
	List<ListOfJob> findByDepartmentId (String id);
}
