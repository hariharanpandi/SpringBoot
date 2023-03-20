package com.nosql.jobhiringportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nosql.jobhiringportal.model.ListOfJob;
import com.nosql.jobhiringportal.service.JobServices;

@RestController
public class JobPortalController {
	
	@Autowired
	JobServices jobServices;
	
	@PostMapping("/create/user")
	public ListOfJob createjob(@RequestParam ListOfJob listOfJob){
		return jobServices.createjob(listOfJob);
	}

//	@GetMapping("/user")
//	public List<ListOfJob> findAllUser(){
//		return repository.findAll();
//	}
	
}
