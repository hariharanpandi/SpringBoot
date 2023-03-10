package com.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.ex.model.Employentity;

@Component
public class EmployService 
{

	public List<Employentity> excelUpload() 
	{
		List<Employentity> myList = new LinkedList<>();

		try {

			String path = "C:\\Users\\arunk\\eclipse-workspace\\Employee\\src\\main\\resources\\Employee (1).xlsx";

			File file = new File(path);

			FileInputStream inputStream = new FileInputStream(file);

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			XSSFSheet mysheet = workbook.getSheetAt(0);

			Employentity employObject = new Employentity();
			for (Row row : mysheet)
			{
				int rowIndex = 0;
				if (rowIndex == 0) 
				{
					rowIndex++;
					continue;
				}
				Iterator<Cell> cellIterator = row.iterator();
				int cellIndex = 0;

				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					switch (cellIndex)
					{
							case 0 -> employObject.setCode(cell.getStringCellValue());
							case 1 -> employObject.setName(cell.getStringCellValue());
							case 2 -> employObject.setDate(cell.getStringCellValue());
							case 3 -> employObject.setGrade(cell.getStringCellValue());
							case 4 -> employObject.setSalary(Double.parseDouble(cell.getStringCellValue()));
							case 5 -> employObject.setResult(cell.getStringCellValue());
						default -> 
						{
							System.out.println("default");
						}
					}
				}
				cellIndex++;
			}
			workbook.close();
			inputStream.close();
			myList.add(employObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myList;

	}
}
