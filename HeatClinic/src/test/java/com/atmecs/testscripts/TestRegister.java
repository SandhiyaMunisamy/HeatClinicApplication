package com.atmecs.testscripts;

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
public class TestRegister extends TestBase {

	WebDriver driver;
	CommonUtilities register = new CommonUtilities();
	LogReportFile log = new LogReportFile();

	/**
	 * getting browser,url and window operations from properties file
	 */
	@BeforeMethod
	public void setUp() {
		this.driver = invokeBrowser();
		String baseUrl = configProps.getProperty("applicationurl");
		driver.get(baseUrl);
		this.driver = windowOperation();

	}

	/**
	 * 
	 * @param reg Register the data using data provider from the excel
	 */
	@Test(dataProvider = "registrationData", dataProviderClass = ExcelDataProvider.class)
	public void verifyRegistrationPage(RegistrationData reg) {
        log.info("Login is processed");
		register.registerData(reg, driver);
		log.info("Registered Succesfully" + driver.getTitle());
		register.verifyassert(driver.getCurrentUrl(), "https://10.10.10.232:8443/register");

	}

	/**
	 * quit the browser
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
