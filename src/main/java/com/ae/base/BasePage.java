package com.ae.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String getTitle() {
		try {
			log.info("Page title is : '" + driver.getTitle() + "'.");
			return driver.getTitle();
		} catch (Exception e) {
			log.info("Error occured while getting the page title. Error occured : " + e.getMessage());
			return "";
		}
	}



}
