package com.ex.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ex.model.Employentity;
import com.ex.repository.Employrepository;
import com.ex.service.EmployService;

@Controller
public class Employcontroller
{
	@Autowired
	Employrepository employrepository;
	
	@Autowired
	EmployService employService;
	
	@RequestMapping("upload")
	public String upload()
	{
		employrepository.saveAll(employService.excelUpload());
		
		return "hi";
	}
		
	
}







	/*@Autowired
	Employrepository employrepository;
	
	@PostMapping("/upload")
	public String uploadData(@RequestParam("file") MultipartFile file) throws Exception{
		
		List<Employentity> employeList = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			Employentity employObject = new Employentity();
			employObject.setCode(record.getString("code"));
			employObject.setName(record.getString("name"));
			employObject.setDate(record.getString("date"));
			employObject.setGrade(record.getString("grade"));
			employObject.setSalary(Double.parseDouble(record.getString("salary")));
			employObject.setResult(record.getString("result"));
		});
		employrepository.saveAll(employeList);
		return "upload successfully";
		}*/
	
	
	
	

