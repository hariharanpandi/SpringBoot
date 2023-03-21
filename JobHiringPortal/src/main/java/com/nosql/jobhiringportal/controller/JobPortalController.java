package com.nosql.jobhiringportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nosql.jobhiringportal.model.ListOfJob;
import com.nosql.jobhiringportal.service.JobServices;

@RestController
public class JobPortalController {

	@Autowired
	JobServices jobServices;

	@PostMapping("/create/user")
	public ListOfJob createjob(@RequestBody ListOfJob listOfJob) {
		return jobServices.createjob(listOfJob);
	}

	@GetMapping("/user")
	public List<ListOfJob> findAllUser() {
		return jobServices.findAll();
	}

	@GetMapping("/findby/user/{id}")
	public ListOfJob findbyId(@PathVariable String id) {
		return jobServices.findbyid(id);
	}

	@GetMapping("/getname/{name}")
	public List<ListOfJob> getname(@PathVariable String name) {
		return jobServices.getbyname(name);
	}

	@PutMapping("/update")
	public ListOfJob update(@RequestBody ListOfJob listOfJob) {
		return jobServices.update(listOfJob);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		return jobServices.delete(id);
	}

	@GetMapping("/getbydept/{departmentname}")
	public List<ListOfJob> getbydept(@PathVariable String departmentname) {
		return jobServices.getbydept(departmentname);
	}

	@GetMapping("/nameprofile")
	public List<ListOfJob> nameandprofile(@RequestParam String name, String profile) {
		return jobServices.nameAndProfile(name, profile);
	}

	@GetMapping("/profiles")
	public List<ListOfJob> profilesByname(@RequestParam String name, String profile) {
		return jobServices.profilesname(name, profile);
	}

	@GetMapping("/pageable")
	public List<ListOfJob> pagnition(@RequestParam int pageno, int pagesize) {
		return jobServices.pageable(pageno, pagesize);
	}
	
	@GetMapping("/sorting")
	public List<ListOfJob> sorting(){
		return jobServices.sorting();
	}
	
	@GetMapping("/array")
	public List<ListOfJob> skillarray(@RequestParam String skill){
		return jobServices.skillarray(skill);
	}
	
	@GetMapping("/like")
	public List<ListOfJob> likequery(@RequestParam String description){
		return jobServices.likequery(description);
	}
	
	@GetMapping("/getbydeptname/{departmentId}")
	public List<ListOfJob> getbydeptname(@PathVariable String departmentId) {
		return jobServices.getbydeptId(departmentId);
	}	
}
