package com.example.course.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.AaludraCourse;
import com.example.course.repository.AaludraRepository;

@RestController
public class AaludraCourseController {

	@Autowired
	private AaludraRepository repository;

	@GetMapping("/all")
	public List<AaludraCourse> getAllcourses() {
		return repository.findAll();
	}

	@GetMapping("/java")
	public AaludraCourse getjava() {
		return new AaludraCourse(10001, "JAVA", "RANGA");
	}

	@GetMapping("/spring")
	public AaludraCourse getspring() {
		return new AaludraCourse(10001, "SPRING BOOT", "RANGA");
	}

	@GetMapping("/get/{id}")
	public AaludraCourse getsql(@PathVariable long id) {
		Optional<AaludraCourse> course = repository.findById(id);
		if (course.isEmpty()) {
			throw new RuntimeException("Course is not found!" + id);
		}
		return course.get();
	}
	
	@PostMapping("/create")
	public void createCourse(@RequestBody AaludraCourse course) {
		repository.save(course);
	}
	
	@PutMapping("/create/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody AaludraCourse course) {
		repository.save(course);
	}
	
	@DeleteMapping("/delete/{id}")
		public void deleteCourse(@PathVariable long id) {
			repository.deleteById(id);
		}
}
