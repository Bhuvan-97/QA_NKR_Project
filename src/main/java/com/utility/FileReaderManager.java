package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

import org.junit.Assert;


public class FileReaderManager {
	
	public static FileInputStream fileInputStream;
	private static Properties property;
	
	private static void setProperty() throws IOException {
		File file = new File("C:/Users/Bhuvanesh RK/eclipse-workspace/NaukriProject/src/main/resources/NaukriTestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR IN FILE LOADING"); 													// Assert given in junit ?
		} catch (Exception e) {
			Assert.fail("ERROR IN FILE READER");
		}
		
	public static String getDataProperty(String datavalue) {
		setProperty();
		String data = property.getProperty(datavalue);
		return data;
	}	

	public static void main(String[]args)
	System.out.println(getDataProperty("Url"));
	}
	
	
}
