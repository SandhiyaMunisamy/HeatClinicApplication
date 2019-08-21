package com.atmecs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.extentReport.ExtentReportFile;
import com.atmecs.extentReport.GetScreenshot;
import com.atmecs.helper.CommonUtilities;
import com.atmecs.helper.PerformUtilityMethods;
import com.atmecs.logger.LogReportFile;
import com.atmecs.testsuite.TestBase;

/**
 * @date 13/08/2019
 * @author Sandhiya.Munisamy
 *
 */
public class ItemManageCart extends TestBase {

	LogReportFile log = new LogReportFile();
	CommonUtilities performAssert = new CommonUtilities();
	ItemAddToCart addToCart = new ItemAddToCart();
	ExtentReportFile report = new ExtentReportFile();

	/**
	 * Validate Home page 
	 * Search for products and add a product1 to the cart 
	 * Add new items to cart(product2)
	 * Validate all added products are available in the cart 
	 * Verify the grand total and sub total is correct(product 1 & product 2)
	 * Remove product 2 and check the grand total 
	 * 
	 * @param driver
	 */

	public void searchItem(WebDriver driver) {
		log.info("Started TestScenario 3:Manage added items");
		performAssert.verifyassert(driver.getTitle(), "loc.expected.homepage", "Home Page Title Verified");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.search");
		PerformUtilityMethods.SendElementXpath(driver, "loc.btn.clicksearch", "loc.txt.entersearch");// search for item
		PerformUtilityMethods.SendEnter(driver, "loc.btn.clicksearch", Keys.ENTER);
		PerformUtilityMethods.ClickElement(driver, "loc.btn.selectitem");
		
		/**
		 * Add Product 1 in cart
		 */
		addToCart.updateItem(driver);
		
		/**
		 * Add Product2 in cart
		 */
		
		PerformUtilityMethods.ClickElement(driver, "loc.btn.homepage");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.pinktshirt");
		/**
		 * Selects the color
		 */
		PerformUtilityMethods.ClickElement(driver, "loc.dropdown.color");
		log.info("Clicked on color to select");
		Select color = new Select(driver.findElement(By.xpath(OR.getProperty("loc.dropdown.color"))));
		color.selectByVisibleText(OR.getProperty("loc.txt.mvisblecolortext"));
		// Get all the option from dropdown list and assign into List
		List<WebElement> listColorDropdown = color.getOptions();
		int colorCount = listColorDropdown.size();
		log.info("Total Number of item count in dropdown list = " + colorCount); // displays the color count
		log.info("Color is selected");
 
		/**
		 * Selects the size
		 */
		Select size = new Select(driver.findElement(By.xpath(OR.getProperty("loc.dropdown.size"))));
		size.selectByVisibleText(OR.getProperty("loc.txt.mvisiblesizetext"));
		List<WebElement> listSizeDropdown = size.getOptions();
		int sizeCount = listSizeDropdown.size();
		log.info("Total Number of item count in dropdown list = " + sizeCount); // displays of size count
		log.info("Size is selected");

		
		/**
		 * Update quantity
		 */
		PerformUtilityMethods.ClickElement(driver, "loc.add.updatequantity");
		WebElement quantity = driver.findElement(By.xpath(OR.getProperty("loc.txt.clickqauntity"))); // quantity
		quantity.clear(); // Clear quantity
		quantity.sendKeys(OR.getProperty("loc.txt.mquantitycount"));
		log.info("Quantity updated");

		PerformUtilityMethods.ClickElement(driver, "loc.btn.addtocart");
		log.info("Item successfully added to cart");

		PerformUtilityMethods.ClickElement(driver, "loc.btn.clickcart");// add another item to cart
		
		GetScreenshot.capture(driver, "Screenshot2");
		
		/**
		 * displays the grand total of product1 and product2
		 */
		List<WebElement> cartItems = driver.findElements(By.xpath(OR.getProperty("loc.btn.clickcart")));

		log.info("Total number of item added to cart is: " + cartItems.size());
		for (WebElement cart : cartItems) {

			log.info("Total quantity and GrandTotal:" + cart.getText());// displays the grandtotal

		}
		log.info("Grandtotal is displayed");

		
		/**
		 * Remove item from cart and check the Grand total again
		 */
		
		log.info("Item add to cart is succesfully done");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.clickcart");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.removeitem");
		List<WebElement> removedCartItems = driver.findElements(By.xpath(OR.getProperty("loc.btn.clickcart")));

		log.info("Total number of item added to cart is: " + removedCartItems.size());
		for (WebElement removecart : removedCartItems) {

			log.info("Total quantity and GrandTotal:" + removecart.getText());// displays the grandtotal

		}
		report.reportLog();
		log.info("Removed item and Grandtotal is displayed");
	}
	

}