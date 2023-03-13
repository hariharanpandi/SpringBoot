package com.aaludra.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	@GetMapping(path ="/users")
	public String functionalProgram() {
		return "Aaludra";
	}
	
	@GetMapping(path ="/usersbean")
	public RestEntity functionalProgrambean() {
		return new RestEntity("Aaludra","1988-09-29");
	}
	
	@GetMapping(path ="/users/{name}")
	public RestEntity functionalProgramname(@PathVariable String name) {
		return new RestEntity(name,"1988-09-29");
	}
}
