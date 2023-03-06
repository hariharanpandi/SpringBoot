package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.EmployeeRepository;
import com.example.demo.entity.EntityClass;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MyServiceTest {
	
	MyService myService;
	EmployeeRepository employeeRepository;

	@BeforeEach
	 void setUp() {
		employeeRepository = mock(EmployeeRepository.class);
		myService = new MyService(employeeRepository);
	}
	
	@Test
	 void testUploadFile() throws IOException {
		MockMultipartFile file = new MockMultipartFile("modifyEmployee.xlsx", getClass().getResourceAsStream("/modifyEmployee.xlsx"));
		myService.uploadFile(file);

		List<EntityClass> expectedEntityList = new ArrayList<>();
		EntityClass expectedEmployee = new EntityClass();
		expectedEmployee.setCode("E001");
		expectedEmployee.setName("hari");
		expectedEmployee.setDate("01-01-2023");
		expectedEmployee.setGrade("A");
		expectedEmployee.setSalary(5000.0);
		expectedEntityList.add(expectedEmployee);

		List<EntityClass> actualEntityList = employeeRepository.findAll();

assertEquals(expectedEntityList, actualEntityList);
	}
}