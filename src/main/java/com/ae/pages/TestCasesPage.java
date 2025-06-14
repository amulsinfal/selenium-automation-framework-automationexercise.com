package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class TestCasesPage extends BasePage {

	private static final Logger log = LogManager.getLogger(TestCasesPage.class);
	private final By lblTestCases = By.xpath("//h2[@class='title text-center']/b");

	public TestCasesPage(WebDriver driver) {
		super(driver);
	}

	public boolean isOnTestCasesPage() {
		try {
			WebElement element = waitForElementToBeVisible(lblTestCases);
			log.info("Test cases is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Test cases not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

}
