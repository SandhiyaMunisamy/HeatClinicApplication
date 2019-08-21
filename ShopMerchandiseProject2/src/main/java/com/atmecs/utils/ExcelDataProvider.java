package com.atmecs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.atmecs.constants.ProjectPathConstants;
import com.atmecs.helper.LoginData;

/**
 * @category Get data from excel sheet
 * @author Sandhiya.Munisamy
 *
 */
public class ExcelDataProvider {
	String path = ProjectPathConstants.config;      //Browser path
	String xlsxPath = ProjectPathConstants.excel;   //Excel path
	public FileInputStream xfis;
	FileInputStream file;
	public XSSFWorkbook wb;
	XSSFSheet LoginUserData;   //login data sheet

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		try {

			xfis = new FileInputStream(xlsxPath);
			wb = new XSSFWorkbook(xfis);
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// data for Registration form
		LoginUserData = wb.getSheetAt(0); //get data from sheet
		int RowNumber = 1;
		int cellNumber = 0;

		// getting values from sheet with row and cell
		String Email = LoginUserData.getRow(RowNumber).getCell(cellNumber).getStringCellValue(); 
		String Password = LoginUserData.getRow(RowNumber).getCell(cellNumber + 1).getStringCellValue();
		

		LoginData data = new LoginData();
		data.setEmail(Email);
		data.setPassword(Password);
		
		
		// data for Login form
		LoginUserData = wb.getSheetAt(0);
		LoginUserData.getRow(RowNumber).getCell(cellNumber).getStringCellValue();
		LoginUserData.getRow(RowNumber).getCell(cellNumber + 1).getStringCellValue();

		Object[][] testdata = new Object[1][1];
		testdata[0][0] = data;

		return testdata;
	}

	/**
	 * Read data from xlsx file using data provider
	 */
	public static void main(String[] args) {

		ExcelDataProvider tdata = new ExcelDataProvider();
		Object[][] GettingData = tdata.getData();
		LoginData login = (LoginData) GettingData[0][0];
	}

}
