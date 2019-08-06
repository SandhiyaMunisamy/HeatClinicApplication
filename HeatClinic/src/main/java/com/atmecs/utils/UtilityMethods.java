package com.atmecs.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class UtilityMethods {

	public static void ignoreClickInterceptAndClickOnElement(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement xpathElement = driver.findElement(By.xpath(xpath));
				xpathElement.click();
				return true;
			}
		});
	}

	public static void ignoreClickInterceptAndSendOnElement(WebDriver driver, final String id, final String name) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement idElement = driver.findElement(By.id(id));
				idElement.sendKeys(name);
				return true;
			}
		});
	}

	public static void ignoreNameInterceptAndSendOnElement(WebDriver driver, final String name, final String value) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement nameElement = driver.findElement(By.name(name));
				nameElement.sendKeys(value);
				return true;
			}
		});

	}

}
