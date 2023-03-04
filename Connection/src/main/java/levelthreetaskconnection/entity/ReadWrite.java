package levelthreetaskconnection.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWrite {
	public static void main(String[] args) throws IOException {
		LinkedList<String> myList = new LinkedList<>();

		Employee[] employeeArrayenum = Employee.values();

		String path = "C:\\Users\\Admin\\Desktop\\test.xlsx";
		File file = new File(path);

		FileInputStream inputStream = new FileInputStream(file);

		try (Workbook workbook = WorkbookFactory.create(inputStream)) {

			Sheet sheet = workbook.getSheetAt(0);
			boolean myboolean = false;

			for (Row row : sheet) {
				boolean myboolean2 = false;

				if (row.getRowNum() != 0) {
					myboolean = true;

					if (myboolean) {

						for (Employee myEnum : employeeArrayenum) {

							if (myEnum.getGrade().equals(String.valueOf(row.getCell(4)))) {

								if (((myEnum.getMinSalary() <= Double
										.parseDouble(String.valueOf(row.getCell(5).getNumericCellValue()))))

										&& (myEnum.getMaxSalary() >= Double
												.parseDouble(String.valueOf(row.getCell(5).getNumericCellValue()))))

								{
									myboolean2 = true;

								}

							}
						}

					}

					if (myboolean2) {

						myList.add("success");

					} else {

						if ((String.valueOf(row.getCell(4))).equalsIgnoreCase("A")) {
							myList.add(String.valueOf(row.getCell(5).getNumericCellValue())
									+ "       given salary is not in between 10000 to 30000");
						} else if ((String.valueOf(row.getCell(4))).equalsIgnoreCase("B")) {
							myList.add(String.valueOf(row.getCell(5).getNumericCellValue())
									+ "       given salary is not in between 30000 to75000");
						} else if ((String.valueOf(row.getCell(4))).equalsIgnoreCase("C")) {
							myList.add(String.valueOf(row.getCell(5).getNumericCellValue())
									+ "       given salary is not in between 750000 to 500000");
						}
					}
				}
			}

			inputStream.close();

			Row row = sheet.getRow(0);
			Cell cell = row.createCell(6);
			cell.setCellValue("Result");

			int i = 1;
			for (String myString : myList) {
				row = sheet.getRow(i);
				cell = row.createCell(6);
				cell.setCellValue(myString);
				i++;
			}

			FileOutputStream fileOut = new FileOutputStream(new File(path));

			workbook.write(fileOut);
			fileOut.close();

		} finally {

			System.out.print("Validated");
		}
	}

}
