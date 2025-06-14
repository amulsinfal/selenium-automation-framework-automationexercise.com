package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class PaymentDonePage extends BasePage{

	private static final Logger log = LogManager.getLogger(PaymentDonePage.class);
	private final By lblConfirmedMessage = By.xpath("//h2[@data-qa='order-placed']/following-sibling::p");
	
	public PaymentDonePage(WebDriver driver) {
		super(driver);
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
