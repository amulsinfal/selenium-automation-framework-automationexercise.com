package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class AccountCreatedPage extends BasePage {

	private static final Logger log = LogManager.getLogger(AccountCreatedPage.class);
	private final By lblAccountCreatedHeader = By.xpath("//h2[@data-qa='account-created']/b");
	private final By btnContinue = By.xpath("//a[@data-qa='continue-button']");

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAccountCreatedLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblAccountCreatedHeader);
			log.info("Account created page header is displayed on the Account created page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Account created page header not displayed on the Account created  page. Error occured : "	+ e.getMessage());
			return false;
		}
	}

	public String getAccountCreatedLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(lblAccountCreatedHeader);
			log.info("Account created header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Account created page header text on the Account created page. Error occured : " + e.getMessage());
			return "Unable to retrive Account created page header text on the Account created page.";
		}
	}

	public HomePage clickContinue() {
		try {
			WebElement element = waitForElementToBeClickable(btnContinue);
			element.click();
			log.info("Clicked on the Continue button.");
			log.info("Navigating to Home page.");
			return new HomePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Continue button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
}