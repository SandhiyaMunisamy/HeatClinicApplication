package com.atmecs.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.atmecs.constants.ProjectPathConstants;

/**
 * 
 * @author Sandhiya.Munisamy
 *
 */
public class ExcelDataProvider {
	String path = ProjectPathConstants.config;
	String xlsxPath = ProjectPathConstants.excel;
	WebDriver driver;
	public FileInputStream xfis;
	FileInputStream file;
	public XSSFWorkbook wb;
	XSSFSheet RegisterUserData, LoginUserData;

	@DataProvider(name = "registrationData")
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
		RegisterUserData = wb.getSheetAt(0);
		int RowNumber = 3;
		int cellNumber = 0;

		// getting values from sheet with row and cell
		String Email = RegisterUserData.getRow(RowNumber).getCell(cellNumber).getStringCellValue();
		String FirstName = RegisterUserData.getRow(RowNumber).getCell(cellNumber + 1).getStringCellValue();
		String LastName = RegisterUserData.getRow(RowNumber).getCell(cellNumber + 2).getStringCellValue();
		String Password = RegisterUserData.getRow(RowNumber).getCell(cellNumber + 3).getStringCellValue();
		String ConfirmPassword = RegisterUserData.getRow(RowNumber).getCell(cellNumber + 4).getStringCellValue();

		RegistrationData data = new RegistrationData();
		data.setEmail(Email);
		data.setFirstName(FirstName);
		data.setLastName(LastName);
		data.setPassword(Password);
		data.setConfirmPassword(ConfirmPassword);

		// data for Login form
		LoginUserData = wb.getSheetAt(0);
		LoginUserData.getRow(RowNumber).getCell(0).getStringCellValue();
		LoginUserData.getRow(RowNumber).getCell(1).getStringCellValue();

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
		RegistrationData reg = (RegistrationData) GettingData[0][0];
	}

}
