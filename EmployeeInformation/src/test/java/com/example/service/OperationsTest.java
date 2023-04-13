package com.example.service;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

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
//		InputStream inputStream = new FileInputStream(file);
//		MultipartFile multipartFile = new MockMultipartFile("modifyEmployee.xlsx", file.getName(),
//				"application/vnd.ms-excel", inputStream);
		Employee employee=new Employee();
		employee.setCode("E001");
		employee.setName("hari");
		employee.setDate("12.12.12");
		employee.setGrade("A");
		employee.setSalary(10000);
		
		employee.setStatus("Active");
		
		when(employeeRepository.saveAll(Mockito.anyIterable())).thenReturn(Arrays.asList(employee));
		MockMultipartFile multipartFile = new MockMultipartFile("E:\\SpringBootGIT\\EmployeeInformation\\src\\main\\resources\\Employee(Test).xlsx", "Test File Content".getBytes());
		operations.uploadFile(multipartFile); 
		//verify(employeeRepository, times(1)).saveAll(Mockito.anyIterable());
	}
	@Test
     void testUploadFileTest() throws IOException {
        // Mock the input file
        InputStream inputStream = getClass().getResourceAsStream("E:\\SpringBootGIT\\EmployeeInformation\\src\\main\\resources\\Employee(Test).xlsx");
       // assertNotNull(inputStream);
        MockMultipartFile file = new MockMultipartFile("file", "Employee(Test).xlsx", "application/vnd.ms-excel", inputStream);

        // Mock the repository method calls
        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(null);
        when(employeeRepository.findById((int) Mockito.anyLong())).thenReturn(Optional.of(new Employee()));

        // Call the service method
        operations.uploadFile(file);

        // Assert the result
        // For example, check if the repository method was called with the correct parameters
        Mockito.verify(employeeRepository, Mockito.times(1)).save(Mockito.any(Employee.class));
    }
	
  
    @Test
    void testUploadFiles() throws IOException {
        // create a mock MultipartFile
        MockMultipartFile file = new MockMultipartFile("file", "test.xlsx", "application/vnd.ms-excel", 
                getClass().getClassLoader().getResourceAsStream("test.xlsx"));

        Operations operations = new Operations();
        operations.setEmployeeRepository(employeeRepository);

        // call the uploadFile method
        operations.uploadFile(file);

        // assert that the result is as expected
        // TODO: add your assertions here
    }
    
    @Test
    public void satartmain() throws IOException {
    	MockMultipartFile file =new MockMultipartFile(null, getClass().getClassLoader().getResourceAsStream(null));
    	
    	Operations operation=new Operations();
    	operations.uploadFile(file);
    	
    	Date
    }
}
