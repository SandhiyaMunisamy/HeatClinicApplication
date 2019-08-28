package com.atmecs.shopping.pages;


import org.openqa.selenium.WebDriver;
import com.atmecs.shopping.constants.ConstantUtils;
import com.atmecs.shopping.helper.CommonUtilities;
import com.atmecs.shopping.helper.PerformUtilityMethods;
import com.atmecs.shopping.helper.Products;
import com.atmecs.shopping.logger.LogReportFile;

public class ProductsFilterPage {
	 static LogReportFile log = new LogReportFile();
	 static CommonUtilities performAssert = new CommonUtilities();
	 
		public static void filteringproducts(WebDriver driver) {
		
		log.info("Started TestScenario 3");
		ConstantUtils.getTitle(driver);
		performAssert.verifyassert(ConstantUtils.text, "loc.expected.homepage", "Home Page Title Verified");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.dismiss");
		Products.navigateTo(driver, "loc.url.navigateto"); //navigate to products page
		ConstantUtils.getUrl(driver);
		performAssert.verifyassert(ConstantUtils.url, "loc.navigate.expected.url", "loc.navigate.expected.message");
		ProductsNavigatePage.dropdown(driver, "loc.dropdown.color", "loc.color.isvisible"); //select color from drop down
		ProductsNavigatePage.dropdown(driver, "loc.dropdown.orderby", "loc.orderby.isvisible");//sort price  
		
		}
		

}
