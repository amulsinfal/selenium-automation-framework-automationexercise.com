package com.ae.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ae.utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	private static final Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	public void setup() {
		driver = PageDriver.intializeDriver(ConfigReader.readProperty("browser"));
		log.info("Navigating to url: '" + ConfigReader.readProperty("url") + "'");
		driver.get(ConfigReader.readProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		log.info("Quitting the browser.");
		driver.quit();
	}
	
}
