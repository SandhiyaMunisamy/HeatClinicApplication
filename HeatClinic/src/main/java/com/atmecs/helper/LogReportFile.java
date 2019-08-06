package com.atmecs.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.constants.ProjectPathConstants;

/**
 * 
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
}
