package com.atmecs.pages;

import org.openqa.selenium.WebDriver;

import com.atmecs.extentReport.ExtentReportFile;
import com.atmecs.extentReport.GetScreenshot;
import com.atmecs.helper.CommonUtilities;
import com.atmecs.helper.LoginData;
import com.atmecs.helper.PerformUtilityMethods;
import com.atmecs.logger.LogReportFile;


/**
 * @category Login User Account
 * @author Sandhiya.Munisamy
 *
 */
public class UserLogin extends ExtentReportFile   {
	static LogReportFile log = new LogReportFile();
	static CommonUtilities performAssert = new CommonUtilities();
	static ExtentReportFile report = new ExtentReportFile();
	

	public static void loginData(LoginData login, WebDriver driver) {
		log.info("Started TestScenario 1:Login");
		performAssert.verifyassert(driver.getTitle(), "loc.expected.homepage", "Home Page Title Verified");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.dismiss");
		GetScreenshot.capture(driver, "Homepage");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.myaccount");
		performAssert.verifyassert(driver.getCurrentUrl(), "loc.expected.myaccounturl", "My account url is successfully verified");
		PerformUtilityMethods.SendElement(driver, "loc.txt.usernameid", login.Email);
		PerformUtilityMethods.SendElement(driver, "loc.txt.passwordid", login.Password);
		GetScreenshot.capture(driver, "Loginpage");
		PerformUtilityMethods.ClickElement(driver, "loc.btn.login");
		report.reportLog();
		GetScreenshot.capture(driver, "Loginfailed");
		log.info("Login operation is Success");
		

	}

}
