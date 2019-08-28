package com.atmecs.shopping.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.shopping.constants.ProjectPathConstants;



/**
 * @category Log test run details and report data
 * @author Sandhiya.Munisamy
 *
 */
public class LogReportFile {
	Logger logger = null;

	public void getlogger() {
		PropertyConfigurator.configure(ProjectPathConstants.log);
	}

	/**
	 * Get logger configuration path
	 */
	public LogReportFile() {
		getlogger();
		logger = Logger.getLogger(LogReportFile.class.getName());
	}

	public void info(String message) {
		logger.info(message);
	}

	public void info(Throwable cause) {
		// TODO Auto-generated method stub
		
	}
}
