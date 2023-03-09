package com.example.service;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeRepository;
import com.example.demo.service.Operations;

class OperationsTest {

	@InjectMocks
	Operations operations;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@BeforeEach
	void before() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void testUploadFile() throws IOException {
		File file = new File("C:\\Users\\Admin\\Desktop\\EmployeeActivity.xlsx");
		InputStream inputStream = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile("modifyEmployee.xlsx", file.getName(),
				"application/vnd.ms-excel", inputStream);
		Employee employee=new Employee();
		employee.setCode("E001");
		employee.setName("hari");
		employee.setDate("12.12.12");
		employee.setGrade("A");
		employee.setSalary(10000);
		employee.setStatus("Active");
		
		when(employeeRepository.saveAll(Mockito.anyIterable())).thenReturn(Arrays.asList(employee));
		operations.uploadFile(multipartFile); 
		//verify(employeeRepository, times(1)).saveAll(Mockito.anyIterable());
	}

}
