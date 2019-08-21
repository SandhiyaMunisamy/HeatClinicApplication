package com.atmecs.helper;


import org.testng.Assert;

import com.atmecs.logger.LogReportFile;
import com.atmecs.testsuite.TestBase;



public class CommonUtilities extends TestBase
{
	/**
	 * 
	 * @param actual
	 * @param expected
	 */
LogReportFile log = new LogReportFile();


	public void verifyassert(String actual, String expected ,String message) {
		Assert.assertEquals(actual, OR.getProperty(expected) , "passed");
		log.info("Actual: " +actual);
		log.info("Expected: "+expected);
		log.info(" Message :"+message);
	}
	
}