package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class PaymentDonePage extends BasePage{

	private static final Logger log = LogManager.getLogger(PaymentDonePage.class);
	private final By lblOrderPlaced = By.xpath("//h2[@data-qa='order-placed']/b");
	private final By btnDownloadInvoice = By.xpath("//a[@href='/download_invoice/900']");
	private final By btnContinue = By.xpath("//a[@data-qa='continue-button']");
	private final By lblConfirmedMessage = By.xpath("//h2[@data-qa='order-placed']/following-sibling::p");
	
	public PaymentDonePage(WebDriver driver) {
		super(driver);
	}
	

	public boolean isOrderPlacedHeaderVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblOrderPlaced);
			log.info("Order Placed header is displayed on the Payment done page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Order Placed header not displayed on the Payment done page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getOrderPlacedHeaderText() {
		try {
			WebElement element = waitForElementToBeVisible(lblOrderPlaced);
			log.info("Order Placed header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Order Placed header text on the Payment done page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Order Placed header text on the Payment done page.";
		}
	}

	public HomePage clickDownloadInvoice() {
		try {
			WebElement element = waitForElementToBeClickable(btnDownloadInvoice);
			element.click();
			log.info("Clicked on the Download Invoice button.");
			return new HomePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Download Invoice button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public HomePage clickContinue() {
		try {
			WebElement element = waitForElementToBeClickable(btnContinue);
			element.click();
			log.info("Clicked on the Continue button.");
			return new HomePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Continue button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public boolean isConfirmedMessageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblConfirmedMessage);
			log.info("Order confirmed message is displayed on the Payment done page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Order confirmed message not displayed on the Payment done page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getConfirmedMessageText() {
		try {
			WebElement element = waitForElementToBeVisible(lblConfirmedMessage);
			log.info("Order confirmed message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Order confirmed message text on the Payment done page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Order confirmed message text on the Payment done page.";
		}
	}
	
}
