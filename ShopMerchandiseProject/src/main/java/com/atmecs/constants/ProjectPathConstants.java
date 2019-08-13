package com.atmecs.constants;

import java.io.File;
/**
 * @category Path Constants
 * @author Sandhiya.Munisamy
 *
 */

public class ProjectPathConstants {
	public static String currentdir = System.getProperty("user.dir") + File.separator;
	public static String resources = currentdir + File.separator + "resources" + File.separator;

//testdata file path
	public static String testData = resources + File.separator + "testdata" + File.separator;

//configuration properties
	public static String config = resources + "Config.properties";

//xlsx file path
	public static String excel = testData + File.separator + "DataRegisterLogin.xlsx";
	
//locators
	public static String locators = resources + File.separator + "locators" + File.separator;
	
//ObjectRepository
	public static String objectrepository = locators + "ObjectRepository.properties";

//log4j properties 
	public static String log = resources + "log4j.properties";
}