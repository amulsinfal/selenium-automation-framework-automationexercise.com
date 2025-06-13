package com.ae.base;

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

public class PageDriver {

	private static WebDriver driver;
	private static final Logger log = LogManager.getLogger(PageDriver.class);

	public static WebDriver intializeDriver(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			log.info("Chrome browser launched.");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--private");
            driver = new FirefoxDriver(firefoxOptions);
			log.info("Firefox browser launched.");
		} else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("-inprivate"); 
            driver = new EdgeDriver(edgeOptions);
			log.info("Edge browser launched.");
		} else {
			log.error("Invalid browser name provided: " + browserName+ ". Launching the test in chrome browser.");
			driver = new ChromeDriver();
			log.info("Chrome browser launched.");
		}
		driver.manage().window().maximize();
		log.info("Browser maximised.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.readProperty("implicitWaitTimeout"))));
		log.info("Implicit wait set to " + ConfigReader.readProperty("implicitWaitTimeout") + " seconds.");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.readProperty("pageLoadTimeout"))));
		log.info("Page load timeout set to " + ConfigReader.readProperty("pageLoadTimeout") + " seconds.");		
		driver.manage().deleteAllCookies();
		log.info("All browser cookies deleted.");
		log.info("WebDriver initialization complete.");
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
