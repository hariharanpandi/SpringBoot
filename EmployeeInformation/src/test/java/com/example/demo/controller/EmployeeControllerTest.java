package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import com.example.demo.service.Operations;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;

	@Mock
	Operations operations;

	@Test
	void uploaddata() throws IOException {
		MockMultipartFile file = new MockMultipartFile("C:\\Users\\Admin\\Desktop\\Employee(Test).xlsx", "Test File Content".getBytes());
		String result = employeeController.uploadData(file);
		assertEquals("Upload Succesfully !!!", result);
	}
}
