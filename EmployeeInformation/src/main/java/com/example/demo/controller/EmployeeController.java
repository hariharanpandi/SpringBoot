package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.Operations;

@RestController
public class EmployeeController {

	@Autowired
	Operations operations;

	@PostMapping("/upload")
	public String uploadData(@RequestParam("file") MultipartFile file) throws IOException {
		operations.uploadFile(file);
		return "Upload Succesfully !!!";
	}
}