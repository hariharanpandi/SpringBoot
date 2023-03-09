package com.example.demo.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;

@Service
public class Operations {

	@Autowired
	EmployeeRepository repository;

	public  void uploadFile(MultipartFile file) throws IOException {

		List<Employee> entityList = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		final String create = "CREATE";
		final String update = "UPDATE";
		final String delete = "DELETE";
		List<String> result=new ArrayList<>();
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = worksheet.getRow(i);
			if ((create.equalsIgnoreCase(row.getCell(6).getStringCellValue()))) {
				this.createdata(row, entityList,result);

			} else if (update.equalsIgnoreCase(row.getCell(6).getStringCellValue())
					|| delete.equalsIgnoreCase(row.getCell(6).getStringCellValue())) {
				this.updatedata(row, entityList, update, delete,result);
			}
		}
		this.finalResult(result, worksheet, workbook);
		workbook.close();
	}

	private void createdata(XSSFRow row, List<Employee> entityList, List<String> result) {
		Optional<Employee> employeeOptional = repository
				.findByCode(String.valueOf(row.getCell(1).getStringCellValue()));
		if (employeeOptional.isEmpty()) {
			Employee employee = new Employee();
			employee.setCode(row.getCell(1).getStringCellValue());
			employee.setName(row.getCell(2).getStringCellValue());
			employee.setDate(row.getCell(3).getStringCellValue());
			employee.setGrade(row.getCell(4).getStringCellValue());
			employee.setSalary(row.getCell(5).getNumericCellValue());
			employee.setStatus("ACTIVE");
			entityList.add(employee);
			repository.saveAll(entityList);
			result.add("Success");
		}
		else {
			result.add("Employee already exists");
		}
	}

	public void updatedata(XSSFRow row, List<Employee> entityList, String update, String delete,List<String> result) {
		Optional<Employee> employeeOptional = repository
				.findByCode(String.valueOf(row.getCell(1).getStringCellValue()));
		if (employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			employee.setCode(row.getCell(1).getStringCellValue());
			employee.setName(row.getCell(2).getStringCellValue());
			employee.setDate(row.getCell(3).getStringCellValue());
			employee.setGrade(row.getCell(4).getStringCellValue());
			employee.setSalary(row.getCell(5).getNumericCellValue());
			if (update.equalsIgnoreCase(row.getCell(6).getStringCellValue())) {
				employee.setStatus("ACTIVE");
			} else if (delete.equalsIgnoreCase(row.getCell(6).getStringCellValue())) {
				employee.setStatus("INACTIVE");
			}
			entityList.add(employee);
			repository.saveAll(entityList);
			result.add("Success");
		}
		else {
			result.add("Employee code not found");
		}
	}
	public void finalResult(List<String> result,XSSFSheet worksheet, XSSFWorkbook workbook) throws IOException {
		Row row = worksheet.getRow(0);
		Cell cell = row.createCell(7);
		cell.setCellValue("Result");

		int i = 1;
		for (String myString : result) {
			row = worksheet.getRow(i);
			cell = row.createCell(7);
			cell.setCellValue(myString);
			i++;
		}

		 OutputStream outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Employee(Test).xlsx");
		 workbook.write(outputStream);
		    outputStream.close();
	}
}