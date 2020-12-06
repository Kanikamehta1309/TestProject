package Interactions.Project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVOutput {

	public static void main(String[] args) throws IOException {
		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet("Output");

		// Create row object
		XSSFRow row;
		List<String> value = new ArrayList<String>();
		List<String> keyList = CSV1.getColumnName();
		int clmId =0;
		row = spreadsheet.createRow(0);
		for (int i = 0; i < keyList.size(); i++) {
			// This data needs to be written (Object[])
			Map<String, List<String>> weatherData = new TreeMap<String, List<String>>();
			weatherData.put("Expected " + keyList.get(i), CSV2.getAPIValue());
			weatherData.put("Actual " + keyList.get(i), CSV1.getCellValue());
			Set<String> keyid = weatherData.keySet();
			
			
			for(String key : keyid) {
			Cell clmNm = row.createCell(clmId++);
			clmNm.setCellValue(key);
			
			}
			int rowid =1;
			for(String key : keyid) {
				row = spreadsheet.createRow(rowid++);
				value =weatherData.get(key);
						
			int cellid = 0;
			
			 for (String str : value){ Cell cell = row.createCell(cellid++);
			  cell.setCellValue(str); }
			}
			
			/*
			 * int rowid = 1;
			 * 
			 * row = spreadsheet.createRow(1); int clmId =1; for (String key : keyid) {
			 * 
			 * Cell clm1 = row.createCell(clmId++); // System.out.println(key);
			 * clm1.setCellValue(key.toString()); // List<String> value =
			 * weatherData.get(key);
			 * 
			 * 
			 * int cellid = 1;
			 * 
			 * for (String str : value){ Cell cell = row.createCell(cellid++);
			 * cell.setCellValue(str); }
			 * 
			 * }
			 */
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(
					new File("D:\\Kanika_Docs\\Selenium\\New folder\\New folder\\Project\\target\\output.xlsx"));

			workbook.write(out);
			out.close();
			// System.out.println("Writesheet.xlsx written successfully");
		}
	}
}
