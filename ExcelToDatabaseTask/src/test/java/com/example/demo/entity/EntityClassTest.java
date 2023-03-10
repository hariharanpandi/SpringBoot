package com.example.demo.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class EntityClassTest {

	private EntityClass entity = new EntityClass();

	@Test
	 void testGetCode() {
		String code = "abc123";
		entity.setCode(code);
		assertEquals(code, entity.getCode());
	}

	@Test
	 void testGetName() {
		String name = "John";
		entity.setName(name);
		assertEquals(name, entity.getName());
	}

	@Test
	 void testGetDate() {
		String date = "2022-01-01";
		entity.setDate(date); 
		assertEquals(date, entity.getDate());
	}

	@Test
	 void testGetGrade() {
		String grade = "A";
		entity.setGrade(grade);
		assertEquals(grade, entity.getGrade());
	}

	@Test
	 void testGetSalary() {
		double salary = 5000.00;
		entity.setSalary(salary);
		assertEquals(salary, entity.getSalary(), 0.01);
	}
	
	 @Test
	     void testConstructor() {
	        EntityClass employee = new EntityClass("code1", "name1", "date1", "grade1", 1000.0);

	        assertEquals("code1", employee.getCode());
	        assertEquals("name1", employee.getName());
	        assertEquals("date1", employee.getDate());
	        assertEquals("grade1", employee.getGrade());
	        assertEquals(1000.0, employee.getSalary(), 0.01); // use a delta value to allow for floating-point imprecision
	    }
}
