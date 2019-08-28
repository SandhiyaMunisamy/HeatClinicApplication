package com.atmecs.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.shopping.jira.JiraPolicy;
import com.atmecs.shopping.pages.ProductsHomePage;
import com.atmecs.shopping.pages.ProductsNavigatePage;
import com.atmecs.shopping.testsuite.TestBase;


	/**
	 * 
	 * @category add items to cart
	 * @author Sandhiya.Munisamy
	 *
	 */

	public class NavigatePageProducts extends TestBase {
	

		@BeforeMethod
		public void setUp() {

			this.driver = invokeBrowser(); //invokes the browser and application 

		}

		/**
		 * open url http://shop.demoqa.com/ 
		 * Navigate to url http://shop.demoqa.com/shop/
		 * Filter products by color and price.
		 * validate the filtering page.
		 */
		@JiraPolicy(logTicketReady = true)
		@Test
		public void verifyNavigatePage() {
			ProductsNavigatePage.navigateSpecifiedPage(driver);
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();    //quit the browser
		}



}
