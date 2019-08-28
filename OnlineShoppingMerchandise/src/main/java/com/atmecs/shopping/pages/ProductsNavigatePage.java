package com.atmecs.shopping.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.shopping.constants.ConstantUtils;
import com.atmecs.shopping.helper.CommonUtilities;
import com.atmecs.shopping.helper.PerformUtilityMethods;
import com.atmecs.shopping.helper.Products;
import com.atmecs.shopping.logger.LogReportFile;
import com.atmecs.shopping.testsuite.TestBase;

public class ProductsNavigatePage extends TestBase {
	static LogReportFile log = new LogReportFile();
	static CommonUtilities performAssert = new CommonUtilities();

	public static void navigateSpecifiedPage(WebDriver driver) {
		log.info("Started TestScenario 2");
		ConstantUtils.getTitle(driver);
		performAssert.verifyassert(ConstantUtils.text, "loc.expected.homepage", "Home Page Title Verified");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.dismiss");
		Products.navigateTo(driver, "loc.url.navigateto");//navigate to product page
		ConstantUtils.getUrl(driver);
		performAssert.verifyassert(ConstantUtils.url, "loc.navigate.expected.url", "loc.navigate.expected.message");
		Products.javascript(driver);  //scroll down page
		PerformUtilityMethods.ClickElement(driver, "loc.page.selectpage"); //select the page
		ProductsNavigatePage.dropdown(driver, "loc.dropdown.color", "loc.color.isvisible"); //choose the color by filter
		
		//Products.errorPageValidation(driver, "loc.error.noresultfound");
	}

	public static void dropdown(WebDriver driver, String xpath, String isvisblexpath) {

		PerformUtilityMethods.ClickElement(driver, xpath);
		log.info("Selected dropdown");
		Select dropdownoption = new Select(driver.findElement(By.xpath(OR.getProperty(xpath))));
		dropdownoption.selectByVisibleText(OR.getProperty(isvisblexpath));
          
          
	}
}
