package com.atmecs.helper;

import org.openqa.selenium.WebDriver;
import com.atmecs.utils.UtilityMethods;

public class PerformMethodOperation {

	public static void ClickElement(WebDriver driver, final String xpath) {
		UtilityMethods.ignoreClickInterceptAndClickOnElement(driver, xpath);
	}

	public static void SendElement(WebDriver driver, final String id, final String name) {
		UtilityMethods.ignoreClickInterceptAndSendOnElement(driver, id, name);
	}

	public static void SendElementName(WebDriver driver, final String name, final String value) {
		UtilityMethods.ignoreNameInterceptAndSendOnElement(driver, name, value);
	}

}
