package com.example.demo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.EmployeeRepository;
import com.example.demo.entity.EntityClass;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {

	@InjectMocks
	MyService myService;

	@Mock
	EmployeeRepository employeeRepository;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testUploadFile() throws IOException {

		File file = new File("E:\\DataBaseWorkSpace\\ExcelToDatabaseTask\\src\\main\\resources\\modifyEmployee.xlsx");
		InputStream inputStream = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile("modifyEmployee.xlsx", file.getName(),
				"application/vnd.ms-excel", inputStream);
		EntityClass employee1 = new EntityClass();
		employee1.setCode("C01");
		employee1.setName("John Smith");
		employee1.setDate("2022-01-01");
		employee1.setGrade("A");
		employee1.setSalary(5000);

		EntityClass employee2 = new EntityClass();
		employee2.setCode("C02");
		employee2.setName("Jane Doe");
		employee2.setDate("2022-01-01");
		employee2.setGrade("B");
		employee2.setSalary(4000);

		when(employeeRepository.saveAll(Mockito.anyIterable())).thenReturn(Arrays.asList(employee1, employee2));
		myService.uploadFile(multipartFile);

		verify(employeeRepository, times(1)).saveAll(Mockito.anyIterable());
	}

}