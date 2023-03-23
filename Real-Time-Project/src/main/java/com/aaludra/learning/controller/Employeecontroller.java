package com.aaludra.learning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aaludra.learning.bean.Employee;

@RestController 
@RequestMapping("employee")
public class Employeecontroller {

	@GetMapping
	public ResponseEntity<Employee> getEmployees(){
		Employee employee=new Employee(1,"hari","E001","Java");
		return new ResponseEntity<Employee> (employee, HttpStatus.OK);
	}
	
	@PostMapping("post")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee){
		return new ResponseEntity<> (employee, HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Employee> updateemployee(@RequestBody Employee employee, @PathVariable int id){
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		return new ResponseEntity<Employee> (HttpStatus.OK);
	}
}
