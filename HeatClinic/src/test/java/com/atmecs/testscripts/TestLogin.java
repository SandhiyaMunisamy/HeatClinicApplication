package com.atmecs.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.helper.CommonUtilities;
import com.atmecs.helper.ExcelDataProvider;
import com.atmecs.helper.LogReportFile;
import com.atmecs.helper.RegistrationData;
import com.atmecs.testsuite.TestBase;

/**
 * 
 * @author Sandhiya.Munisamy
 *
 */
public class TestLogin extends TestBase {
	WebDriver driver;
	CommonUtilities login = new CommonUtilities();
	LogReportFile log = new LogReportFile();

	@BeforeMethod
	public void setUp() {
		this.driver = invokeBrowser();
		String baseUrl = configProps.getProperty("applicationurl");
		driver.get(baseUrl);
		this.driver = windowOperation();
	}

	/**
	 * 
	 * @param reg
	 */

	@Test(dataProvider = "registrationData", dataProviderClass = ExcelDataProvider.class)
	public void verifyLoginPage(RegistrationData reg) {
		login.loginData(reg, driver);
		login.verifyassert(driver.getCurrentUrl(), "http://10.10.10.232:8080/");
		log.info("User LoggedIn Successfully");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
