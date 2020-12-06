package Interactions.Project;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CSV1 {

	public static List<String> list = new ArrayList<String>();
	public static String FilePath = "D:\\\\Kanika_Docs\\\\Selenium\\\\New folder\\\\New folder\\\\Project\\\\Resources\\\\InputFile.xls";

	public static void main(String[] args) throws IOException {
		excelDrive();
		System.out.println(getColumnName());
	}

	public static void excelDrive() throws IOException {
		FileInputStream fis = new FileInputStream(FilePath);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		// Navigate to working sheet
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet 1")) {

				HSSFSheet sheet = workbook.getSheetAt(i);

				// Identify the column name by scanning first row
				Iterator<Row> rows = sheet.iterator();
				Row columnName = rows.next();
				Iterator<Cell> cell = columnName.cellIterator();
				for (int j = 0; j < 5; j++) {

					Cell value = cell.next();
					System.out.println(value.getStringCellValue());
				}
				while (rows.hasNext()) {
					Row fields = rows.next();
					Iterator<Cell> field = fields.cellIterator();
					for (int k = 0; k < 5; k++) {

						Cell value1 = field.next();
						if (value1.getStringCellValue().equals("")) {
							System.out.println("0");
						} else {
							System.out.println(value1.getStringCellValue());
						}

					}
				}
			}
		}
			
		}

	public static List<String> getColumnName() throws IOException{
		List<String> columnName = new ArrayList<String>(); 
		FileInputStream fis = new FileInputStream(FilePath);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		// Navigate to working sheet
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet 1")) {

				HSSFSheet sheet = workbook.getSheetAt(i);

				// Identify the column name by scanning first row
				Iterator<Row> rows = sheet.iterator();
				Row columnName1 = rows.next();
				Iterator<Cell> cell = columnName1.cellIterator();
				for (int j = 0; j < 5; j++) {

					Cell value = cell.next();
					String val = value.getStringCellValue().replace("main/","");
					columnName.add(val);
		
	
	}
			}
			
}
		return columnName;
	}
	

public static List<String> getCellValue() throws IOException{
	FileInputStream fis = new FileInputStream(FilePath);
	@SuppressWarnings("resource")
	HSSFWorkbook workbook = new HSSFWorkbook(fis);
	// Navigate to working sheet
	int sheets = workbook.getNumberOfSheets();
	for (int i = 0; i < sheets; i++) {
		if (workbook.getSheetName(i).equalsIgnoreCase("Sheet 1")) {

			HSSFSheet sheet = workbook.getSheetAt(i);

			// Identify the column name by scanning first row
			Iterator<Row> rows = sheet.iterator();
			Row columnName = rows.next();
			Iterator<Cell> cell = columnName.cellIterator();
			/*
			 * for (int j = 0; j < 5; j++) {
			 * 
			 * Cell value = cell.next(); // list.add(value.getStringCellValue());
			 * 
			 * }
			 */
			
			while (rows.hasNext()) {
				Row fields = rows.next();
				Iterator<Cell> field = fields.cellIterator();
				for (int k = 0; k < 5; k++) {

					Cell value1 = field.next();
					if (value1.getStringCellValue().equals("")) {
						list.add("0");
					} else {
						list.add(value1.getStringCellValue());
					}

				}
			}
		}
		
	}
	return list;
		

}
}
