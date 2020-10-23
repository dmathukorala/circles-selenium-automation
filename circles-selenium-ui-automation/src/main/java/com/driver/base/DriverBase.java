package com.driver.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.selenium.conig.TestConfig;

public class DriverBase extends TestConfig {

	protected static WebDriver driver;
	protected static String url;

	@BeforeSuite
	public void setupTest() {

		getProperties();

		if (config.getProperty("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		url = testData.getProperty("url");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

}
