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
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class CartPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(CartPage.class);
	private static final By SUBSCRIPTION_LABEL_LOCATOR = By.xpath("//div[@class='single-widget']/h2");
	private static final By SUBSCRIPTION_EMAIL_TEXTBOX_LOCATOR = By.id("susbscribe_email");
	private static final By SUBSCRIBE_BUTTON_LOCATOR = By.id("subscribe");
	private static final By SUCCESS_MESSAGE_LABEL_LOCATOR = By.xpath("//div[@id='success-subscribe']/div[@class='alert-success alert']");
	private static final By CART_EMPTY_LABEL_LOCATOR = By.xpath("//span[@id='empty_cart']/p/b");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@class='btn btn-default check_out']");
	private static final By REGISTER_LOGIN_LINK_LOCATOR = By.xpath("//div[@class='modal-body']/descendant::a[@href='/login']");
	private static final By CART_BREADCRUMB_LOCATOR = By.xpath("//div[@class='breadcrumbs']/ol/li[2]");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public boolean isCartPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(CART_BREADCRUMB_LOCATOR);
			LOG.info("Cart page is visible.");
			ReportListeners.test.log(Status.PASS, "Cart page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Car Page not visible. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Car Page not visible. Error occured : " + e.getMessage());
			return false;
		}
	}

	public boolean isSubscriptionLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR);
			LOG.info("'Subscription' label is displayed on cart page.");
			ReportListeners.test.log(Status.PASS, "'Subscription' label is displayed on cart page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("'Subscription' label not displayed on cart page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "'Subscription' label not displayed on cart page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSubscriptionText() {
		try {
			WebElement element = waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR);
			LOG.info("Subscription label text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Subscription label text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Subscription label text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Subscription label text. Error occured : " + e.getMessage());
			return "Unable to retrive Subscription label text.";
		}
	}

	public CartPage clickArrowButton() {
		try {
			WebElement element = waitForElementToBeClickable(SUBSCRIBE_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on Subscribe button.");
			ReportListeners.test.log(Status.PASS, "Clicked on Subscribe button.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on Subscribe button.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Subscribe button.");
			return this;
		}
	}

	public CartPage enterSubscriptionEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(SUBSCRIPTION_EMAIL_TEXTBOX_LOCATOR);
			element.sendKeys(email);
			LOG.info("'" + email + "' entered in the subscription email text box.");
			ReportListeners.test.log(Status.PASS, "'" + email + "' entered in the subscription email text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + email + "' text in the subscription email text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + email + "' text in the subscription email text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public boolean isSubscriptionSuccessLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Subscription success label is displayed on cart page.");
			ReportListeners.test.log(Status.PASS, "Subscription success label is displayed on cart page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Subscription success label not displayed on cart page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Subscription success label not displayed on cart page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSubscriptionSuccessText() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Subscription success message text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Subscription success message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Subscription success message text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Subscription success message text. Error occured : " + e.getMessage());
			return "Unable to retrive Subscription success message text.";
		}
	}

	public CartPage scrollToFooter() {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR));
			LOG.info("Scrolling to footer section.");
			ReportListeners.test.log(Status.PASS, "Scrolling to footer section.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to Scroll to footer section. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to Scroll to footer section. Error occured : " + e.getMessage());
			return null;
		}
	}

	public String getProductQuantity(String productName) {
		try {
			String xpathString = "//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_quantity']/button";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			LOG.info("Quantity of '" + productName + "' is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Quantity of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive product quantity text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive product quantity text. Error occured : " + e.getMessage());
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
				LOG.info("Clicked on the 'X' button on the cart for product : '" + productName + "'.");
				LOG.info("'" + productName + "' removed from the cart.");
				ReportListeners.test.log(Status.PASS, "Clicked on the 'X' button on the cart for product : '" + productName + "'.");
				ReportListeners.test.log(Status.PASS, "'" + productName + "' removed from the cart.");
			} else {
				missingProducts.add(productName);
			}
		}
		if (missingProducts.size() > 0) {
			LOG.info("Products missing in the cart : " + missingProducts);
			ReportListeners.test.log(Status.WARNING, "Products missing in the cart : " + missingProducts);
		} else {
			LOG.info("Products removed from the list : " + foundProducts);
			ReportListeners.test.log(Status.PASS, "Products removed from the list : " + foundProducts);
		}
		return this;
	}

	public boolean isCartEmpty() {
		try {
			waitForElementToBeVisible(CART_EMPTY_LABEL_LOCATOR);
			if (driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr")).isEmpty()) {
				LOG.info("Cart is empty.");
				ReportListeners.test.log(Status.PASS, "Cart is empty.");
				return true;
			} else {
				LOG.info("Cart is not empty.");
				ReportListeners.test.log(Status.WARNING, "Cart is not empty.");
				return false;
			}
		} catch (Exception e) {
			LOG.error("Unable to check if cart is empty. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to check if cart is empty. Error occured : " + e.getMessage());
			return false;
		}

	}

	public CartPage clickProceedToCheckout() {
		try {
			WebElement element = waitForElementToBeClickable(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on Proceed To Checkout button.");
			ReportListeners.test.log(Status.PASS, "Clicked on Proceed To Checkout button.");
			return new CartPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Proceed To Checkout button.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Proceed To Checkout button.");
			return null;
		}
	}

	public SignupLoginPage clickRegisterLoginLink() {
		try {
			WebElement element = waitForElementToBeClickable(REGISTER_LOGIN_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Register / Login link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Register / Login link.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Register / Login link.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Register / Login link.");
			return null;
		}
	}

}
