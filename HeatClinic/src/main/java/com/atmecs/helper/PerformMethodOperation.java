package com.atmecs.helper;

import org.openqa.selenium.WebDriver;

import com.atmecs.testsuite.TestBase;
import com.atmecs.utils.UtilityMethods;

public class PerformMethodOperation extends TestBase{

	public static void ClickElement(WebDriver driver, final String xpath) {
		UtilityMethods.ignoreClickInterceptAndClickOnElement(driver,OR.getProperty(xpath));
	}

	public static void SendElement(WebDriver driver, final String id, final String name) {
		UtilityMethods.ignoreClickInterceptAndSendOnElement(driver,OR.getProperty(id), name);
	}

	public static void SendElementName(WebDriver driver, final String name, final String value) {
		UtilityMethods.ignoreNameInterceptAndSendOnElement(driver,OR.getProperty(name), value);
	}

}
