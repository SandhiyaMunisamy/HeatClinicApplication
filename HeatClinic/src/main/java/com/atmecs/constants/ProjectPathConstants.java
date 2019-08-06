package com.atmecs.constants;

import java.io.File;

public class ProjectPathConstants {
	public static String currentdir = System.getProperty("user.dir") + File.separator;
	public static String resources = currentdir + File.separator + "resources" + File.separator;

//locators folder
	public static String testData = resources + File.separator + "testdata" + File.separator;

//configuration properties
	public static String config = resources + "Config.properties";

//xlsx path
	public static String excel = testData + File.separator + "DataRegister.xlsx";

//ObjectRepository
	public static String objectrepository = resources + "ObjectRepository.properties";

//log4j properties 
	public static String log = resources + "log4j.properties";
}