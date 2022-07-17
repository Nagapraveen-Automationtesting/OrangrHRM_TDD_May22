package com.orangeHRM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLutils {
	String filePath = System.getProperty("user.dir")+"\\TestData\\Sample.xlsx";
	@Test
	public void samle() throws IOException {
		readValueFromExcel(filePath, "Sheet1", 2, 1);
		readColumnValuesFromExcel(filePath, "Sheet1", 1);
	}
	
	public static String readValueFromExcel(String filePath, String sheetName, int rowNum, int colNum)  {
		String val = null;
		try {
		File file = new File(filePath);
		FileInputStream fi = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fi); //---> .xlsx
//		Workbook book = new HSSFWorkbook(); //---> .xls
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		val = cell.getStringCellValue();
		System.out.println(val);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
	
	public static List<String> readColumnValuesFromExcel(String filePath, String sheetName, int colNum) throws IOException {
		List<String > list = new ArrayList<>();
		File file = new File(filePath);
		FileInputStream fi = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fi); //---> .xlsx
//		Workbook book = new HSSFWorkbook(); //---> .xls
		Sheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		
		for(int i=0;i<=rowCount;i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(colNum);
			list.add(cell.getStringCellValue());
		}
		System.out.println(list);
		return list;
	}

}
