package com.atmecs.shopping.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.shopping.constants.ConstantUtils;
import com.atmecs.shopping.helper.CommonUtilities;
import com.atmecs.shopping.helper.PerformUtilityMethods;
import com.atmecs.shopping.helper.Products;
import com.atmecs.shopping.logger.LogReportFile;
import com.atmecs.shopping.testsuite.TestBase;

public class ProductsHomePage extends TestBase {
	static LogReportFile log = new LogReportFile();
	static CommonUtilities performAssert = new CommonUtilities();

	public static void womenDresses(WebDriver driver) {

		log.info("Started TestScenario 1");
		ConstantUtils.getTitle(driver);
		performAssert.verifyassert(ConstantUtils.text, "loc.expected.homepage", "Home Page Title Verified");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.dismiss");
		Products.javascript(driver);         //scroll page
		homepagedress(driver, "loc.img.firstdress", "loc.dress.firstdress", "loc.expected.txt.firstdress",
				"loc.message.firstdress", "loc.txt.firstdress", "loc.rating.firstdress"); //validate the first product in home page
		homepagedress(driver, "loc.img.seconddress", "loc.dress.seconddress", "loc.expected.txt.seconddress",
				"loc.message.seconddress", "loc.txt.seconddress", "loc.rating.seconddress");//validate the second product in home page
		homepagedress(driver, "loc.img.thirddress", "loc.dress.thirddress", "loc.expected.txt.thirddress",
				"loc.message.thirddress", "loc.txt.thirddress", "loc.rating.thirddress");//validate the third product in home page
		homepagedress(driver, "loc.img.fourthdress", "loc.dress.fourthdress", "loc.expected.txt.fourthdress",
				"loc.message.fourthdress", "loc.txt.fourthdress", "loc.rating.fourthdress");//validate the fourth product in home page
		homepagedress(driver, "loc.img.fifthdress", "loc.dress.fifthdress", "loc.expected.txt.fifthdress",
				"loc.message.fifthdress", "loc.txt.fifthdress", "loc.rating.fifthdress");//validate the fifth product in home page
		homepagedress(driver, "loc.img.sixthdress", "loc.dress.sixthdress", "loc.expected.txt.sixthdress",
				"loc.message.sixthdress", "loc.txt.sixthdress", "loc.rating.sixthdress"); //validate the sixth product in home page
		ConstantUtils.getUrl(driver);
		performAssert.verifyassert(ConstantUtils.url, "loc.expected.url", "loc.message.url");
	}

	public static void homepagedress(WebDriver driver, String imagexpath, String description, String expectedDes,
			String messageDes, String price, String rating) {
		Products.validate(driver, imagexpath);
		Products.productTextValidation(driver, description, expectedDes, messageDes);
		Products.PriceDetails(driver, price);
		Products.validate(driver, rating);
	}
}
