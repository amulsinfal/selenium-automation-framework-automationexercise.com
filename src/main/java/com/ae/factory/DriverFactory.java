package com.ae.factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ae.utilities.ConfigReader;

public class DriverFactory {

	private static WebDriver driver;
	private static final Logger LOG = LogManager.getLogger(DriverFactory.class);

	public static WebDriver intializeDriver(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			LOG.info("Chrome browser launched.");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--private");
			driver = new FirefoxDriver(firefoxOptions);
			LOG.info("Firefox browser launched.");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("-inprivate"); 
			driver = new EdgeDriver(edgeOptions);
			LOG.info("Edge browser launched.");
		} else {
			LOG.error("Invalid browser name provided: " + browserName+ ". Launching the test in chrome browser.");
			driver = new ChromeDriver();
			LOG.info("Chrome browser launched.");
		}
		driver.manage().window().maximize();
		LOG.info("Browser maximised.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.readProperty("implicitWaitTimeout"))));
		LOG.info("Implicit wait set to " + ConfigReader.readProperty("implicitWaitTimeout") + " seconds.");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.readProperty("pageLoadTimeout"))));
		LOG.info("Page load timeout set to " + ConfigReader.readProperty("pageLoadTimeout") + " seconds.");		
		driver.manage().deleteAllCookies();
		LOG.info("All browser cookies deleted.");
		LOG.info("WebDriver initialization complete.");
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
