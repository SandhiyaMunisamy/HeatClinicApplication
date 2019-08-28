package com.atmecs.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.shopping.jira.JiraPolicy;
import com.atmecs.shopping.pages.ProductsHomePage;
import com.atmecs.shopping.testsuite.TestBase;



/**
 * 
 * @category validate home page products
 * @author Sandhiya.Munisamy
 *
 */

public class HomePageProducts extends TestBase {
	
	@BeforeMethod
	public void setUp() {

		this.driver = invokeBrowser(); //invokes the browser and application 

	}

	/**
	 * Navigate to url http://shop.demoqa.com/ 
	 * validate each products available in home page
	 * validate products by image,description,price and rating.
	 */
	@JiraPolicy(logTicketReady = true)
	@Test
	public void verifyHomePageProducts() {
		ProductsHomePage.womenDresses(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();    //quit the browser
	}

}
