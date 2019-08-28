package com.atmecs.shopping.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.shopping.constants.ConstantUtils;
import com.atmecs.shopping.constants.PriceValidation;
import com.atmecs.shopping.constants.UtilityMethods;
import com.atmecs.shopping.logger.LogReportFile;
import com.atmecs.shopping.testsuite.TestBase;



public class Products extends TestBase{
	static LogReportFile log = new LogReportFile();
	static CommonUtilities performAssert = new CommonUtilities();
	
	public static void  click(WebDriver driver,final String xpath) {
		PerformUtilityMethods.ClickElement(driver, OR.getProperty(xpath));
	}
    
	public static boolean isdisplayed(WebDriver driver,final String xpath) {
		return driver.findElement(By.xpath(OR.getProperty(xpath))).isDisplayed();
	}
	
	public static void navigateTo(WebDriver driver,String url) {
		driver.navigate().to(OR.getProperty(url));
	}
	public static void javascript(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,600)");
	}
	public static boolean validate(WebDriver driver,String xpath) {
		boolean text = Products.isdisplayed(driver, xpath);
		Assert.assertTrue(text);
		log.info("Product displayed is : " +text);
		
		return text;
	}
	public static Double PriceDetails(WebDriver driver,String xpath) {
		PriceValidation.getPriceData(driver, OR.getProperty(xpath));
		String Price = PriceValidation.text;
		 String TotalPrice=Price.replace("₹"," ");
		Double Total = Double.parseDouble(TotalPrice);
		log.info("Price is: " + Total);
		return Total;
	}
	public static void productTextValidation(WebDriver driver,String productxpath,String expectedtext,String message) {
		UtilityMethods.getTextData(driver, OR.getProperty(productxpath));
		log.info("Product text:"+UtilityMethods.text);
		performAssert.verifyassert(UtilityMethods.text, expectedtext, OR.getProperty(message));
	}
	public static boolean errorPageValidation(WebDriver driver,String xpath) {
		boolean text = Products.isdisplayed(driver, xpath);
		ConstantUtils.getTitle(driver);
		Assert.assertTrue(ConstantUtils.text.contains("404"));
		return text;
	}
	
}
