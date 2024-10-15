package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public String[][] readExcel(String fileName) throws IOException {

		// to get into the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");

		// to get into the worksheet
		XSSFSheet ws = wb.getSheet("Sheet1");

		// to get the number of rows excluding the header row
		int rowCount = ws.getLastRowNum();
		System.out.println(rowCount);

		// to get the cell count
		int cellCount = ws.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		
		
		//declare 2D array to save the data from excel
		
		String[][] data = new String[rowCount][cellCount];
		

		// count including the first row
		// int rowCount = ws.getPhysicalNumberOfRows();

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				
				//first value for i is 1, but i want save it in 0; so we are using i-1
				data[i-1][j]= cellValue;
				
				//System.out.println(cellValue);

			}

		}
				
		wb.close();
		
		return data;
		// to get into the row
		// XSSFRow row = ws.getRow(i);

		// to get into the cell
		// XSSFCell cell = row.getCell(0);

		// to get the string cell value
		// String cellValue = cell.getStringCellValue();

		// to close the workbook
		

	}

}
