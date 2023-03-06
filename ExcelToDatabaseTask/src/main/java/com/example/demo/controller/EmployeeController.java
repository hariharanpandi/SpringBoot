package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.MyService;

@RestController
public class EmployeeController {

	@Autowired
	MyService service;

	@PostMapping("/upload")
	public String uploadData(@RequestParam("file") MultipartFile file) throws IOException {
		service.uploadFile(file); 
		return "Upload Succesfully !!!";
	}
}