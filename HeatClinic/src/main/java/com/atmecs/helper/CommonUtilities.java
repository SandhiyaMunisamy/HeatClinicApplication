package com.atmecs.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.atmecs.testsuite.TestBase;


public class CommonUtilities extends TestBase {
	WebDriver driver;
	/**
	 * 
	 * @param actual
	 * @param expected
	 */



	public void verifyassert(String actual, String expected) {
		Assert.assertEquals(actual, expected, "passed");
	}

	/**
	 * 
	 * @param driver AddToCart Utilities
	 */
	
	public void registerData(RegistrationData reg, WebDriver driver)
	{
		PerformMethodOperation.ClickElement(driver, "Register_xpath");
		PerformMethodOperation.SendElement(driver, "Email_id", reg.Email);
		PerformMethodOperation.SendElement(driver, "FirstName_id", reg.FirstName);
		PerformMethodOperation.SendElement(driver, "LastName_id", reg.LastName);
		PerformMethodOperation.SendElement(driver, "Password_id", reg.Password);
		PerformMethodOperation.SendElement(driver, "ConfirmPassword_id", reg.ConfirmPassword);
		PerformMethodOperation.ClickElement(driver, "SubmitRegister_xpath");
	}

	public void loginData(RegistrationData reg, WebDriver driver) {
		PerformMethodOperation.ClickElement(driver, "Login_xpath");
		PerformMethodOperation.SendElementName(driver, "Username_name", reg.Email);
		PerformMethodOperation.SendElementName(driver, "Password_name", reg.Password);
		PerformMethodOperation.ClickElement(driver, "SubmitLogin_xpath");
	}



	public void buyOption(WebDriver driver) {
		PerformMethodOperation.ClickElement(driver, "Click_HotSauces");
		PerformMethodOperation.ClickElement(driver, "BuyNow");
	}



	public void inCart(WebDriver driver) {
		boolean cart = driver.findElement(By.xpath(OR.getProperty("Click_Incart"))).isDisplayed();
		Assert.assertTrue(cart);
		PerformMethodOperation.ClickElement(driver, "Click_Incart");
	}



	public void addQuantity(WebDriver driver) {
		WebElement quantity = driver.findElement(By.xpath(OR.getProperty("quantity")));
		quantity.clear();
		quantity.sendKeys("4");
		PerformMethodOperation.ClickElement(driver,"update");
		PerformMethodOperation.ClickElement(driver, "close");
		PerformMethodOperation.ClickElement(driver, "BuyDayOfDead");
	}



	public void CheckOut(WebDriver driver) {
		PerformMethodOperation.ClickElement(driver, "Click_AddedCart");
		PerformMethodOperation.ClickElement(driver, "checkout");
	}



	public void billingInfo(WebDriver driver) {
		PerformMethodOperation.SendElementName(driver, "Checkout_FirstnameId", "Sandhiya");
		PerformMethodOperation.SendElementName(driver, "Checkout_LastnameId", "Munisamy");
		PerformMethodOperation.SendElementName(driver, "Checkout_phonePrimaryId", "7847859048");
		PerformMethodOperation.SendElementName(driver, "Checkout_addressLine1Id", "Vellore");
		PerformMethodOperation.SendElementName(driver,"Checkout_addressLine2Id", "Katpadi");
		PerformMethodOperation.SendElementName(driver, "Checkout_cityId", "Tamilnadu");
		PerformMethodOperation.ClickElement(driver, "Checkout_stateId");
		Select select = new Select(driver.findElement(By.id("state")));
		select.selectByVisibleText("TN");
		PerformMethodOperation.SendElementName(driver, "Checkout_postalId", "632007");
		PerformMethodOperation.ClickElement(driver, "save_Billing");
	}



	public void shippingInfo(WebDriver driver) {
		PerformMethodOperation.ClickElement(driver, "Shipping_id");
		WebElement shippingMethod = driver.findElement(By.id("fulfillmentOptionId2"));
		boolean shippingIsDisplayed = shippingMethod.isDisplayed();
		System.out.println("Is shipping method is displayed: " + shippingIsDisplayed); // Is displayed
		boolean shippingIsEnabled = shippingMethod.isEnabled();
		System.out.println("Is shipping method is Enabled: " + shippingIsEnabled); // Is Enabled
		boolean shippingIsSelected = shippingMethod.isSelected();
		System.out.println("Is shipping method is Selected: " + shippingIsSelected); // Is Selected(Checking the default
																						// radio button selection
																						// status)
		shippingMethod.click();
		PerformMethodOperation.ClickElement(driver, "Select_shipping");
	}

	public void paymentOptions(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");
		/**
		 * payment using credit card
		 */
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement shipping = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Credit Card']")));
//		shipping.click();
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.TAB).build().perform();
//		action.sendKeys("4280 9028 8474 4574").build().perform();
//		action.sendKeys(Keys.TAB).build().perform();
//		action.sendKeys("980").build().perform();
//		action.sendKeys(Keys.TAB).build().perform();
//		action.sendKeys("SANDHIYA MUNISAMY").build().perform();
//		action.sendKeys(Keys.TAB).build().perform();
//		action.sendKeys("03/24").build().perform();
//		PerformMethodOperation.ClickElement(driver, "cancel_submit");



		/**
		 * payment using cash on delivery
		 */
		PerformMethodOperation.ClickElement(driver, "collect_on_delivery");
		PerformMethodOperation.ClickElement(driver, "complete_order");
	}
	/**
	 * 
	 * @param driver RemoveFromCartUtilities
	 */

	public void dropDownMerchandise(WebDriver driver) {
		WebElement ClickMerchandise = driver.findElement(By.xpath(OR.getProperty("Click_merchandise")));
		String quantities = ClickMerchandise.getText();
		System.out.println("Text of Page:" + quantities);
		Actions moveMouseOperation = new Actions(driver);
		moveMouseOperation.moveToElement(ClickMerchandise).perform();
		moveMouseOperation.clickAndHold();
		PerformMethodOperation.ClickElement(driver, "DropDownMen");
		driver.navigate().back();
		ClickMerchandise = driver.findElement(By.xpath(OR.getProperty("Click_merchandise")));
		moveMouseOperation.moveToElement(ClickMerchandise).perform();
	}



	public void buywomenShirt(WebDriver driver) {
		PerformMethodOperation.ClickElement(driver, "DropDownWomen");
		PerformMethodOperation.ClickElement(driver, "buyWomenShirt");
		PerformMethodOperation.ClickElement(driver, "ClickRed");
		PerformMethodOperation.ClickElement(driver, "ClickSmall");
		PerformMethodOperation.ClickElement(driver, "BuySelected");
	}



	public void removeItem(WebDriver driver) {
		PerformMethodOperation.ClickElement(driver, "selectCart");
		PerformMethodOperation.ClickElement(driver, "RemoveSelected");
	}

}