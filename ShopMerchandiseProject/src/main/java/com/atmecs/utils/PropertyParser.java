package com.atmecs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Sandhiya.Munisamy
 *
 */
public class PropertyParser {
	public Properties loadProperty(String filePath) throws IOException {
		Properties props = new Properties();
		FileInputStream ip = new FileInputStream(filePath);
		props.load(ip);
		return props;
	}
}
