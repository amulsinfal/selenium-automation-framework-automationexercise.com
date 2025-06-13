package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class ProductDetailsPage extends BasePage {
	
	private static final Logger log = LogManager.getLogger(ProductDetailsPage.class);
	private final By productQty = By.id("quantity");
	private final By btnAddToCart = By.xpath("//button[@class='btn btn-default cart']");
	private final By btnContinueShopping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private final By lnkViewCart = By.xpath("//a[@href='/view_cart']/u");
		
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailsPage selectQuantity(String quantity) {
		try {
			WebElement element = waitForElementToBeClickable(productQty);
			element.clear();
			log.info("Quantity text box cleared.");
			element.sendKeys(quantity);
			log.info("'" + quantity + "' entered in the quantity text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + quantity + "' text in the quantity text box. Error occured : " + e.getMessage());
			return this;
		}
	}
	
	public ProductDetailsPage clickAddToCart() {
		try {
			WebElement element = waitForElementToBeClickable(btnAddToCart);
			element.click();
			log.info("Clicked on the Add to Cart button.");
			return this;
		} catch (Exception e) {
			log.info("Unable to click on Add to Cart button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public ProductDetailsPage clickContinueShopping() {
		try {
			WebElement element = waitForElementToBeClickable(btnContinueShopping);
			element.click();
			log.info("Clicked on the Continue Shopping button.");
			return this;
		} catch (Exception e) {
			log.info("Unable to click on Continue Shopping button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public CartPage clickViewCartLink() {
		try {
			WebElement element = waitForElementToBeClickable(lnkViewCart);
			element.click();
			log.info("Clicked on the View Cart button.");
			return new CartPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on View Cart button. Error occured : " + e.getMessage());
			return null;
		}
	}
}
