package com.atmecs.pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.helper.CommonUtilities;
import com.atmecs.helper.PerformUtilityMethods;
import com.atmecs.logger.LogReportFile;
import com.atmecs.testsuite.TestBase;

/**
 * @date 13/08/2019
 * @author Sandhiya.Munisamy
 *
 */
public class ItemAddToCart extends TestBase {

	LogReportFile log = new LogReportFile();
	CommonUtilities performAssert = new CommonUtilities();

	/**
	 * Navigate to url http://shop.demoqa.com/ 
	 * Select a product ex: dress
	 * User will navigate to product details page. 
	 * Select color, size and quantity and then add the product to cart (take color, size & quantity). 
	 * Navigate to cart and verify products added into cart 
	 * Verify the total is correct
	 *
	 * @param driver
	 */

	public void buyDress(WebDriver driver) {

		log.info("Started TestScenario 2:Add item to cart");
		performAssert.verifyassert(driver.getTitle(), "loc.expected.homepage", "Home Page Title Verified");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.addmauvetshirt");
		performAssert.verifyassert(driver.getCurrentUrl(), "loc.expected.url", "url is verified");
		log.info("User clicked on Item to buy");
		log.info("Testcase 1 passed");
		verifycart(driver);
		
	}

	public void updateItem(WebDriver driver) {
		PerformUtilityMethods.ClickElement(driver, "loc.dropdown.color");
		log.info("Clicked on color to select");

		
		/**
		 * Select the available color from the dropdown
		 */
		Select color = new Select(driver.findElement(By.xpath(OR.getProperty("loc.dropdown.color"))));
		color.selectByVisibleText(OR.getProperty("loc.txt.visblecolortext"));
		// Get all the option from dropdown list and assign into List
		List<WebElement> listColorDropdown = color.getOptions();
		int colorCount = listColorDropdown.size();
		log.info("Total Number of item count in dropdown list = " + colorCount);
		log.info("Color is selected");

		
		/**
		 * Select the available size from dropdown
		 */
		Select size = new Select(driver.findElement(By.xpath(OR.getProperty("loc.dropdown.size"))));
		size.selectByVisibleText(OR.getProperty("loc.txt.visiblesizetext"));
		List<WebElement> listSizeDropdown = size.getOptions();
		int sizeCount = listSizeDropdown.size();
		log.info("Total Number of item count in dropdown list = " + sizeCount);
		log.info("Size is selected");
		
		
		/**
		 * update the quantity 
		 */

		PerformUtilityMethods.ClickElement(driver, "loc.add.updatequantity");
		WebElement quantity = driver.findElement(By.xpath(OR.getProperty("loc.txt.clickqauntity"))); // quantity
		quantity.clear(); // Clear quantity
		quantity.sendKeys(OR.getProperty("loc.txt.quantitycount"));
		log.info("Quantity updated");

		PerformUtilityMethods.ClickElement(driver, "loc.btn.addtocart");
		log.info("Item successfully added to cart");
		log.info("Test case2 passed");

	}

	public void verifycart(WebDriver driver) {
		updateItem(driver);   //method invoked to make the selection
		/**
		 * Verify the items in cart and sub total
		 */
		PerformUtilityMethods.ClickElement(driver, "loc.btn.clickcart");
		List<WebElement> cartItems = driver.findElements(By.xpath(OR.getProperty("loc.btn.clickcart")));

		log.info("Total number of item added to cart is: " + cartItems.size());
		for (WebElement cart : cartItems) {

			log.info("Total quantity and GrandTotal:" + cart.getText());  //Grand total will be displayed

		}
		log.info("Grandtotal is displayed");

		log.info("Item add to cart is succesfully done");
		log.info("Testcase 3 passed");
	}

}
