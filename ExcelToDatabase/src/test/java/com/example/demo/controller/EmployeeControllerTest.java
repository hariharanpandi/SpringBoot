package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;

import com.example.demo.service.MyService;


class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController controller;
	
	@Mock
	MyService service;

	@Test
	void testUploadData() throws IOException {
		MockMultipartFile mockFile = new MockMultipartFile("E:\\DataBaseWorkSpace\\ExcelToDatabase\\src\\test\\resources\\test.xlsx", "Test file content".getBytes());
		String result = controller.uploadData(mockFile);
		assertEquals("Upload Succesfully !!!", result);
	}
}
