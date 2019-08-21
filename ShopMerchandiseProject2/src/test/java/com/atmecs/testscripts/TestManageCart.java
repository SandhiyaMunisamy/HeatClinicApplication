package com.atmecs.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.jira.JiraPolicy;
import com.atmecs.pages.ItemManageCart;
import com.atmecs.testsuite.TestBase;

/**
 * @category manage items
 * @author Sandhiya.Munisamy
 */

public class TestManageCart extends TestBase {
	ItemManageCart managecart = new ItemManageCart();

	@BeforeMethod
	public void setUp() {

		this.driver = invokeBrowser();  //invokes the browser
	}

	/**
	 * Validate Home page 
	 * Search for products and add a product to the cart 
	 * Add new items to cart 
	 * Validate all added products are available in the cart 
	 * Verify the grand total and sub total is correct(product1 &product2)
	 * Remove product2 and check the grand total 
	 */
	@JiraPolicy(logTicketReady = true)
	@Test
	public void verifyAddToCart() {

		managecart.searchItem(driver);

	}

	 @AfterMethod
	public void tearDown() {
		driver.quit();   //quit the browser
	 }

}
