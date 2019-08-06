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

public class TestRemoveFromCart extends TestBase {
	WebDriver driver;
	CommonUtilities removeFromCart = new CommonUtilities();
	LogReportFile log = new LogReportFile();

	@BeforeMethod
	public void setUp() {
		this.driver = invokeBrowser();
		String baseUrl = configProps.getProperty("applicationurl");
		driver.get(baseUrl);
		this.driver = windowOperation();
	}

	@Test(dataProvider = "registrationData", dataProviderClass = ExcelDataProvider.class)
	public void verifyAddToCart(RegistrationData reg) {
		removeFromCart.loginData(reg, driver);
		removeFromCart.verifyassert(driver.getCurrentUrl(), "http://10.10.10.232:8080/");
		removeFromCart.dropDownMerchandise(driver);
		removeFromCart.buywomenShirt(driver);
		removeFromCart.verifyassert(driver.getTitle(), "Broadleaf Commerce Demo Store - Heat Clinic - Womens");
		removeFromCart.removeItem(driver);
		log.info("Item Removed Successfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}