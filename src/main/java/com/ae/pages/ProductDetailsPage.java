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
	private final By lnkViewCart = By.xpath("//a[@href='/view_cart']/u");
	private final By lblWriteReview = By.xpath("//a[@href='#reviews']");

	private final By lblProductName = By.xpath("//div[@class='product-information']/h2");
	private final By lblProductCategory = By.xpath("//div[@class='product-information']/p");
	private final By lblProductPrice = By.xpath("//div[@class='product-information']/span/span");
	private final By lblProductAvailability = By.xpath("//div[@class='product-information']/p[2]");
	private final By lblProductCondition = By.xpath("//div[@class='product-information']/p[3]");
	private final By lblProductBrand = By.xpath("//div[@class='product-information']/p[4]");
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isProductDetailsPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblWriteReview);
			log.info("Product Details page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Product Details page not displayed. Error occured : " + e.getMessage());
			return false;
		}
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
			log.info("Unable to enter '" + quantity + "' text in the quantity text box. Error occured : "
					+ e.getMessage());
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
	
	public String getProductName() {
		try {
			WebElement element = waitForElementToBeClickable(lblProductName);
			log.info("Product Name retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Product Name on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Name on the Product details page.";
		}
	}
	
	public String getProductCategory() {
		try {
			WebElement element = waitForElementToBeClickable(lblProductCategory);
			log.info("Product category retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			log.info("Unable to retrive Product category on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product category on the Product details page.";
		}
	}
	
	public String getProductPrice() {
		try {
			WebElement element = waitForElementToBeClickable(lblProductPrice);
			log.info("Product Price retrived is '" + element.getText().split("\\s")[1] + "'.");
			return element.getText().split("\\s")[1];
		} catch (Exception e) {
			log.info("Unable to retrive Product Price on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Price on the Product details page.";
		}
	}
	
	public String getProductAvailability() {
		try {
			WebElement element = waitForElementToBeClickable(lblProductAvailability);
			log.info("Product Availability retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			log.info("Unable to retrive Product Availability on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Availability on the Product details page.";
		}
	}
	
	public String getProductCondition() {
		try {
			WebElement element = waitForElementToBeClickable(lblProductCondition);
			log.info("Product Condition retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			log.info("Unable to retrive Product Condition on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Condition on the Product details page.";
		}
	}
	
	public String getProductBrand() {
		try {
			WebElement element = waitForElementToBeClickable(lblProductBrand);
			log.info("Product Brand retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			log.info("Unable to retrive Product Brand on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Brand on the Product details page.";
		}
	}
}
