package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.EmployeeRepository;
import com.example.demo.entity.EntityClass;

@Service
public class MyService {

	@Autowired
	EmployeeRepository employeeRepository;
	
    public MyService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
	}

	public void uploadFile(MultipartFile file) throws IOException {

		List<EntityClass> entityList = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			String result = "success";
			if (result.equalsIgnoreCase(row.getCell(6).getStringCellValue())) {
				EntityClass employee = new EntityClass();
				employee.setCode(row.getCell(1).getStringCellValue());
				employee.setName(row.getCell(2).getStringCellValue());
				employee.setDate(row.getCell(3).getStringCellValue());
				employee.setGrade(row.getCell(4).getStringCellValue());
				employee.setSalary(row.getCell(5).getNumericCellValue());
				entityList.add(employee);
			}
		}
		workbook.close();
		employeeRepository.saveAll(entityList);
	}
}
