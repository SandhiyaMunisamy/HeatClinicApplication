package com.atmecs.helper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.atmecs.constants.UtilityMethods;
import com.atmecs.testsuite.TestBase;

/**
 *
 * @author Sandhiya.Munisamy
 *
 */

public class PerformUtilityMethods extends TestBase{
	/**
	 * ClickElement with xpath
	 * 
	 * @param driver
	 * @param xpath
	 */
	public static void ClickElement(WebDriver driver, final String xpath) {
		UtilityMethods.ignoreClickInterceptAndClickOnElement(driver, OR.getProperty(xpath));
	

	}

	/**
	 * SendElement with id and name
	 * 
	 * @param driver
	 * @param id
	 * @param name
	 */

	public static void SendElement(WebDriver driver, final String id, final String name) {
		UtilityMethods.ignoreClickInterceptAndSendOnElement(driver, OR.getProperty(id),name );


	}
	/**
	 * SendElement with name and value
	 * 
	 * @param driver
	 * @param name
	 * @param value
	 */


	public static void SendElementName(WebDriver driver, final String name, final String value) {
		UtilityMethods.ignoreNameInterceptAndSendOnElement(driver, OR.getProperty(name),value );



	}
	
	/**
	 * SendElement with xpath and value
	 * @param driver
	 * @param xpath
	 * @param value
	 */
	public static void SendElementXpath(WebDriver driver,final String xpath,final String value ) {
		UtilityMethods.ignorexpathInterceptAndSendOnElement(driver, OR.getProperty(xpath),OR.getProperty(value) );
	}

	/**
	 * SendElement with xpath and enter
	 * @param driver
	 * @param xpath
	 * @param enter
	 */
	public static void SendEnter(WebDriver driver,final String xpath,final Keys enter ) {
		UtilityMethods.ignoreKeysInterceptAndSendOnElement(driver, OR.getProperty(xpath), enter);
	}

}
