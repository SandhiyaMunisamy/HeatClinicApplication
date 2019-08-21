package com.atmecs.testsuite;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.atmecs.constants.ProjectPathConstants;
import com.atmecs.logger.LogReportFile;
import com.atmecs.utils.PropertiesUtil;

/**
 * @category set driver and invoke browser
 * @author Sandhiya.Munisamy
 *
 */
public class TestBase {
	public WebDriver driver;
	public static Properties configProps = PropertiesUtil.loadProperty(ProjectPathConstants.config);
	public static Properties OR = PropertiesUtil.loadProperty(ProjectPathConstants.objectrepository);
	LogReportFile log = new LogReportFile();

	/**
	 * invokes the Browser
	 * @return driver 
	 */

	public WebDriver invokeBrowser() {
		String browser = configProps.getProperty("browserName");
		log.info("Running browser: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			this.driver = setChromeDriver();
			log.info("Running " + driver);
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			log.info("firefox case");
			this.driver = setFirefoxDriver();
			log.info("Running " + driver);
		}

		else if (browser.equalsIgnoreCase("IE")) {
			this.driver = setInterExplorerDriver();
			log.info("Running " + driver);
		}
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String baseUrl = configProps.getProperty("applicationurl");
		driver.get(baseUrl);

		return driver;

	}

	/**
	 * setting browser path
	 */

	private WebDriver setChromeDriver() {

		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver.exe");
		return new ChromeDriver();
	}

	private WebDriver setFirefoxDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver.exe");
		return new FirefoxDriver();
	}

	public WebDriver setInterExplorerDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.ie.driver", currentdir + "IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

}
