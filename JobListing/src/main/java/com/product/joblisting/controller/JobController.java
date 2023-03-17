package com.product.joblisting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.joblisting.model.JobPortal;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class JobController {

	@Autowired
	JobRepository repository;
	
	@ApiIgnore
    @GetMapping("/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/users")
	public List<JobPortal> findAllUser() {
		return repository.findAll();
	}
	
	@PostMapping("/adduser")
	public JobPortal createUser(@RequestBody JobPortal jobPortal) {
		return repository.save(jobPortal);
	}
}
