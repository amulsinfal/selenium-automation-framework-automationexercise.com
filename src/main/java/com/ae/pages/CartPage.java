package com.ae.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class CartPage extends BasePage {

	private static final Logger log = LogManager.getLogger(CartPage.class);
	private final By lblSubscription = By.xpath("//div[@class='single-widget']/h2");
	private final By txtSubscriptionEmail = By.id("susbscribe_email");
	private final By btnSubscribe = By.id("subscribe");
	private final By lblSubscribeSuccessMessage = By
			.xpath("//div[@id='success-subscribe']/div[@class='alert-success alert']");
	private final By lblCartEmptyText = By.xpath("//span[@id='empty_cart']/p/b");
	private final By btnProceedToCheckout = By.xpath("//a[@class='btn btn-default check_out']");
	private final By lnkRegisterLogin = By.xpath("//div[@class='modal-body']/descendant::a[@href='/login']");
	private final By lblCartBreadCrumb = By.xpath("//div[@class='breadcrumbs']/ol/li[2]");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public boolean isCartPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblCartBreadCrumb);
			log.info("Cart page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Car Page not visible. Error occured : " + e.getMessage());
			return false;
		}
	}

	public boolean isSubscriptionLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(lblSubscription);
			log.info("'Subscription' label is displayed on cart page.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("'Subscription' label not displayed on cart page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSubscriptionText() {
		try {
			WebElement element = waitForElementToBeVisible(lblSubscription);
			log.info("Subscription label text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Subscription label text. Error occured : " + e.getMessage());
			return "Unable to retrive Subscription label text.";
		}
	}

	public CartPage clickArrowButton() {
		try {
			WebElement element = waitForElementToBeClickable(btnSubscribe);
			element.click();
			log.info("Clicked on Subscribe button.");
			return this;
		} catch (Exception e) {
			log.info("Unable to click on Subscribe button.");
			return this;
		}
	}

	public CartPage enterSubscriptionEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(txtSubscriptionEmail);
			element.sendKeys(email);
			log.info("'" + email + "' entered in the subscription email text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + email + "' text in the subscription email text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public boolean isSubscriptionSuccessLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(lblSubscribeSuccessMessage);
			log.info("Subscription success label is displayed on cart page.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Subscription success label not displayed on cart page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSubscriptionSuccessText() {
		try {
			WebElement element = waitForElementToBeVisible(lblSubscribeSuccessMessage);
			log.info("Subscription success message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Subscription success message text. Error occured : " + e.getMessage());
			return "Unable to retrive Subscription success message text.";
		}
	}

	public CartPage scrollToFooter() {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					waitForElementToBeVisible(lblSubscription));
			log.info("Scrolling to footer section.");
			return this;
		} catch (Exception e) {
			log.info("Unable to Scroll to footer section. Error occured : " + e.getMessage());
			return null;
		}
	}

	public String getProductQuantity(String productName) {
		try {
			String xpathString = "//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_quantity']/button";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			log.info("Quantity of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive product quantity text. Error occured : " + e.getMessage());
			return "Unable to retrive product quantity text.";
		}
	}

	public CartPage clickXButton(String[] productNames) {
		List<String> foundProducts = new ArrayList<String>();
		List<String> missingProducts = new ArrayList<String>();
		for (String productName : productNames) {
			if (!driver
					.findElements(By
							.xpath("//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName + "']"))
					.isEmpty()) {
				foundProducts.add(productName);
				WebElement element = waitForElementToBeVisible(
						By.xpath("//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName
								+ "']/ancestor::td/following-sibling::td[@class='cart_delete']/a[@class='cart_quantity_delete']"));
				element.click();
				log.info("Clicked on the 'X' button on the cart for product : '" + productName + "'.");
				log.info("'" + productName + "' removed from the cart.");
			} else {
				missingProducts.add(productName);
			}
		}
		if (missingProducts.size() > 0) {
			log.info("Products missing in the cart : " + missingProducts);
		} else {
			log.info("Products removed from the list : " + foundProducts);
		}
		return this;
	}

	public boolean isCartEmpty() {
		try {
			waitForElementToBeVisible(lblCartEmptyText);
			if (driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr")).isEmpty()) {
				log.info("Cart is empty.");
				return true;
			} else {
				log.info("Cart is not empty.");
				return false;
			}
		} catch (Exception e) {
			log.info("Unable to check if cart is empty. Error occured : " + e.getMessage());
			return false;
		}

	}

	public CartPage clickProceedToCheckout() {
		try {
			WebElement element = waitForElementToBeClickable(btnProceedToCheckout);
			element.click();
			log.info("Clicked on Proceed To Checkout button.");
			return new CartPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Proceed To Checkout button.");
			return null;
		}
	}

	public SignupLoginPage clickRegisterLoginLink() {
		try {
			WebElement element = waitForElementToBeClickable(lnkRegisterLogin);
			element.click();
			log.info("Clicked on Register / Login link.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Register / Login link.");
			return null;
		}
	}

}
