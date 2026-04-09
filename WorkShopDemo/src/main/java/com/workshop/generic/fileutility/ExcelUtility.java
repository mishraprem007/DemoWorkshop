package com.workshop.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
		wb.close();
		return data;
	}

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testdata/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}

	public void setOrderNumber(String sheetName, int rowNum, int colNum, String orderNumber) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);
		if (row == null)
			row = sheet.createRow(rowNum);

		Cell cell = row.getCell(colNum);
		if (cell == null)
			cell = row.createCell(colNum);

		cell.setCellValue(orderNumber);

		FileOutputStream fos = new FileOutputStream("./testdata/testscriptdata.xlsx");
		wb.write(fos);

		wb.close();
	}

}