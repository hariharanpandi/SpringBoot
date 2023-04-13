package com.example.demo.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class EmployeeTest {

    private Employee employee = new Employee();

    @BeforeEach
    void setUp() {
        employee = new Employee(1, "123", "John Doe", "2022-01-01", "A", 1000);
    }

    @Test
    void testEmployee() {
    	   
    	employee.setCode("123");
    	employee.setName("Jane Doe");
    	employee.setDate("2023-01-01");
    	employee.setGrade("B");
    	employee.setSalary(2000.0);
        employee.setStatus("ACTIVE");
        assertEquals("123", employee.getCode());
        assertEquals("Jane Doe", employee.getName());
        assertEquals("2023-01-01", employee.getDate());
        assertEquals("B", employee.getGrade());
        assertEquals(2000.0, employee.getSalary(),0.01);
        assertEquals("ACTIVE", employee.getStatus());
   
    }
    
    @Test
    void testConstructor() {
       Employee employee = new Employee(12,"E001", "hari", "12.12.12", "A", 1000);
       assertEquals(12,employee.getId());
       assertEquals("E001", employee.getCode());
       assertEquals("hari", employee.getName());
       assertEquals("12.12.12", employee.getDate());
       assertEquals("A", employee.getGrade());
       assertEquals(1000, employee.getSalary(),0.01);
   }
}
