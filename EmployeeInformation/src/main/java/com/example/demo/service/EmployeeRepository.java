package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepositoryImplementation<Employee, Integer> {
	Optional<Employee> findByCode(String stringCellValue);
}
