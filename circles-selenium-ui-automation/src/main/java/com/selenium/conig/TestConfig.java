package com.selenium.conig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

	private static String environment;
	public static Properties testData;
	public static Properties config;

	public Properties getProperties() {
		try {

			config = new Properties();
			testData = new Properties();

			config.load(new FileInputStream("src/test/resources/Config/" + "configuration.properties"));

			if (System.getProperty("environment") != null) {
				environment = System.getProperty("environment").toString();
			} else {
				environment = config.getProperty("environment");
			}

			testData.load(new FileInputStream("src/test/resources/TestData/" + environment + ".properties"));

		} catch (FileNotFoundException e) {
			System.out.println("Error File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error IO exception");
			e.printStackTrace();
		}
		return testData;
	}

}
