package com.atmecs.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.jira.JiraPolicy;
import com.atmecs.pages.ItemAddToCart;
import com.atmecs.testsuite.TestBase;

/**
 * 
 * @category add items to cart
 * @author Sandhiya.Munisamy
 *
 */

public class TestAddToCart extends TestBase {
	ItemAddToCart useraddToCart = new ItemAddToCart();

	@BeforeMethod
	public void setUp() {

		this.driver = invokeBrowser(); //invokes the browser and application 

	}

	/**
	 * Navigate to url http://shop.demoqa.com/ 
	 * Select a product ex: dress (from testdata).
	 * User will navigate to product details page. 
	 * Select color, size and quantity and then add the product to cart (take color, size & quantity). 
	 * Navigate to cart and verify products added into cart 
	 * Verify the total is correct
	 */
	@JiraPolicy(logTicketReady = true)
	@Test
	public void verifyAddToCart() {
		useraddToCart.buyDress(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();    //quit the browser
	}

}
