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

public class TestAddToCart extends TestBase {
	WebDriver driver;
	CommonUtilities addToCart = new CommonUtilities();
	TestLogin login = new TestLogin();
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

		addToCart.loginData(reg, driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 9500)");
		addToCart.buyOption(driver);
		addToCart.verifyassert(driver.getTitle(), "Broadleaf Commerce Demo Store - Heat Clinic - Hot Sauces");
		addToCart.inCart(driver);
		addToCart.addQuantity(driver);
		addToCart.CheckOut(driver);
		addToCart.billingInfo(driver);
		addToCart.shippingInfo(driver);
		addToCart.paymentOptions(driver);
		log.info("Added to Cart Successfully");


	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}