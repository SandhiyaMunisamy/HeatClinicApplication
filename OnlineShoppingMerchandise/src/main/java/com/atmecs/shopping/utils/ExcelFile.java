package com.atmecs.shopping.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.shopping.constants.ProjectPathConstants;



public class ExcelFile {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelFile(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			try {
				workbook = new XSSFWorkbook(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String getData(int index, int rowNum, int cellNum) {

		sheet = workbook.getSheetAt(index);
		String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

	public int totalRowsinSheet(int sheet) {
		int rowCount = workbook.getSheetAt(sheet).getLastRowNum();
		System.out.println("Total number of Row Count in sheet is: " + rowCount);
		return rowCount-1;
	}

	public int totalColsinSheet(int sheetIndex) {
		int colCount = workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();

		return colCount;
	}

	public static void main(String[] args) {
		ExcelFile read = new ExcelFile(ProjectPathConstants.excel);
		read.totalRowsinSheet(0);
		System.out.println("Total number of Column Count in sheet is :" + read.totalColsinSheet(0));

	}
}
