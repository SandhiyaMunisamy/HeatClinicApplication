package com.atmecs.shopping.utils;


import org.testng.annotations.DataProvider;

import com.atmecs.shopping.constants.ProjectPathConstants;



public class TestDataProvider {

	@DataProvider(name = "logindata")
	public Object[][] testData() {
		ExcelFile file = new ExcelFile(ProjectPathConstants.excel);
		int sheetIndex = 0;
		int rowCount = file.totalRowsinSheet(sheetIndex);
		int colCount = file.totalColsinSheet(sheetIndex);

		System.out.println("In testData:: rowCount=" + rowCount);
		System.out.println("In testData:: colCount=" + colCount);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {

			data[rowIndex][colIndex] = file.getData(sheetIndex, rowIndex+1 , colIndex);
			}
		}
		return data;
	}
	public static void main(String[] args) {
		Object[][] data= new TestDataProvider().testData();
		for(Object[] data1: data) {
			String name= (String)data1[0];
			String pass= (String)data1[1];
			System.out.println("name "+name+"---"+pass);
			
		}
		
	}

}
