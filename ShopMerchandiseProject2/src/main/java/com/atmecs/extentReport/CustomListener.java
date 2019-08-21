package com.atmecs.extentReport;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.atmecs.jira.JiraPolicy;
import com.atmecs.jira.JiraServiceProvider;
import com.atmecs.logger.LogReportFile;

public class CustomListener extends ExtentReportFile implements ITestListener {
	LogReportFile log = new LogReportFile();

	public void onTestStart(ITestResult result) {
		log.info("TestCase Started and TestCase details are " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {

		log.info("TestCase Success and TestCase details are " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		
		boolean isTicketReady = jiraPolicy.logTicketReady();
		
		if (isTicketReady) {

			// raise jira ticket:

			log.info("is ticket ready for JIRA: " + isTicketReady);
			
			JiraServiceProvider jiraSp = new JiraServiceProvider("https://sandhiyamunisamy96.atlassian.net",

					"sandhiya.munisamy@atmecs.com", "uAeO3tAgeWK0X4pGMlX7D1F4", "SD");

			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()

					+ "got failed due to some assertion or exception";

			String issueDescription = result.getThrowable().getMessage() + "\n";

			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "Sandhiya");

		}
		log.info("TestCase Failed and TestCase details are " + result.getName());


	}

	public void onTestSkipped(ITestResult result) {

		log.info("TestCase Skipped and TestCase details are " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
