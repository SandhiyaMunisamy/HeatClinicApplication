package com.atmecs.shopping.constants;

import org.openqa.selenium.WebDriver;

public class ConstantUtils {
	
	public static String text;
	public static String url;
	public static String getTitle(WebDriver driver) {
		text=driver.getTitle();
		return text;	
	}
	
	
	public static String getUrl(WebDriver driver) {
		url=driver.getCurrentUrl();
		return url;	
	}
	
}
