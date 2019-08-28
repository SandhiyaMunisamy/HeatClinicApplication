package com.atmecs.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.shopping.jira.JiraPolicy;
import com.atmecs.shopping.pages.ProductsFilterPage;
import com.atmecs.shopping.pages.ProductsHomePage;
import com.atmecs.shopping.pages.ProductsNavigatePage;
import com.atmecs.shopping.testsuite.TestBase;

	/**
	 * 
	 * @category add items to cart
	 * @author Sandhiya.Munisamy
	 *
	 */

	public class FilterProductPage extends TestBase {
		

		@BeforeMethod
		public void setUp() {

			this.driver = invokeBrowser(); //invokes the browser and application 

		}

		/**
		 * open url http://shop.demoqa.com/ 
		 * Navigate to url http://shop.demoqa.com/shop/
		 * scroll down the page and click on third page
		 * Filter color yellow and validate the page.
		 */
		@JiraPolicy(logTicketReady = true)
		@Test
		public void verifyByFilteringProducts() {
			ProductsFilterPage.filteringproducts(driver);
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();    //quit the browser
		}

}
