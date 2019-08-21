package com.atmecs.testscripts;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.atmecs.helper.LoginData;
import com.atmecs.jira.JiraPolicy;
import com.atmecs.pages.UserLogin;
import com.atmecs.testsuite.TestBase;
import com.atmecs.utils.ExcelDataProvider;

	/**
	 * {@link :http://shop.demoqa.com/my-account/}
	 * 
	 * @category User Account Login
	 * @author Sandhiya.Munisamy
	 *
	 */

//@Listeners(com.atmecs.extentReport.CustomListener.class)
public class TestLogin extends TestBase {

	@BeforeMethod
	public void setUp() {
			this.driver = invokeBrowser();   //invokes the browser
		}

		/**
		 * Verify the user is navigated to the Login page. 
		 * Validate each fields which successfully login to the Home page by entering valid registered user data
		 * Check if the user is logged in to the concerned page(Homepage)
		 * 
		 * @param login
		 * 
		 */
	@JiraPolicy(logTicketReady = true)
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void verifyLoginPage(LoginData login) {
			
			UserLogin.loginData(login, driver);

		}
		
		
	    //quits the browser
	@AfterMethod
	public void tearDown() {
			driver.quit();  //quit the browser
		}

}
