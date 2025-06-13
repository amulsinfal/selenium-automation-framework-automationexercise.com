package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class AccountDeletedPage extends BasePage {

	private static final Logger log = LogManager.getLogger(AccountDeletedPage.class);
	private final By lblAccountDeletedHeader = By.xpath("//h2[@data-qa='account-deleted']/b");
	private final By btnContinue = By.xpath("//a[@data-qa='continue-button']");

	public AccountDeletedPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAccountDeletedHeaderVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblAccountDeletedHeader);
			log.info("Account deleted page header is displayed on the Account deleted page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Account deleted page header not displayed on the Account deleted  page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getAccountDeletedHeaderText() {
		try {
			WebElement element = waitForElementToBeVisible(lblAccountDeletedHeader);
			log.info("Account deleted header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Account deleted page header text on the Account deleted page. Error occured : " + e.getMessage());
			return "Unable to retrive Account deleted page header text on the Account deleted page.";
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
