package com.example.demo;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;

import com.example.demo.entity.EmployeeRepository;
import com.example.demo.service.MyService;

class MyServiceTest {
	
	@Mock
	EmployeeRepository employeeRepository;
	
//	@Test
	void testUploadFile() throws IOException {

		MyService myService = new MyService();
		myService.employeeRepository = employeeRepository;

		MockMultipartFile file = new MockMultipartFile("test.xlsx", getClass()
				.getResourceAsStream("E:\\DataBaseWorkSpace\\ExcelToDatabase\\src\\test\\resources\\test.xlsx"));

		when(employeeRepository.saveAll(any())).thenReturn(null);

		myService.uploadFile(file);

		verify(employeeRepository).saveAll(any());
	}

}
