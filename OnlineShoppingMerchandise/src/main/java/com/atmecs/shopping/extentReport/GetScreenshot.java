package com.atmecs.shopping.extentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.atmecs.shopping.logger.LogReportFile;



public class GetScreenshot {
	LogReportFile log = new LogReportFile();

	public static String capture(WebDriver driver,String screenshotName)  {
		String dateName = new SimpleDateFormat("yyyyMMddhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/ErrorScreenshot/"+ screenshotName + dateName +".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination;
		
	}
}
