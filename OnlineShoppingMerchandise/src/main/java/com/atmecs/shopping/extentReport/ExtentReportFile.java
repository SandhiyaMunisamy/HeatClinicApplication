package com.atmecs.shopping.extentReport;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportFile {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	public static WebDriver driver;

	public void reportLog() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("User Name", "Sandhiya");
		htmlReporter.config().setDocumentTitle("Shop Demoqa Application");
		htmlReporter.config().setReportName("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		test = extent.createTest("passTest");
		test.log(Status.INFO, "Shop demoqa website");
		extent.flush();
	}

	public void failed() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\Sandhiya.Munisamy\\Desktop\\Assessment"
					+ "/ShopMerchandiseProject/screenshot/" + "/testFailure.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
