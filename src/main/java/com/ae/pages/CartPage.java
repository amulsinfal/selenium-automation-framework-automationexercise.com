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

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public boolean isProductPresent(String[] inputProducts) {
		boolean flag = false;
		for (String name : inputProducts) {
			if (!driver
					.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + name + "']"))
					.isEmpty()) {
				log.info("Product found in the cart : " + name);
				flag = true;
			} else {
				flag = false;
				log.info("Product missing in the cart : " + name);
				break;
			}
		}
		return flag;
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

	public CartPage clickSubscribe() {
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

	public String getProductPrice(String productName) {
		try {
			String xpathString = "//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_price']";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			log.info("Price of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText().split(" ")[1].toString();
		} catch (Exception e) {
			log.info("Unable to retrive product price text. Error occured : " + e.getMessage());
			return "Unable to retrive product price text.";
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

	public String getProductTotalAmount(String productName) {
		try {
			String xpathString = "//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_total']/p[@class='cart_total_price']";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			log.info("Total amount of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText().split(" ")[1].toString();
		} catch (Exception e) {
			log.info("Unable to retrive product total amount text. Error occured : " + e.getMessage());
			return "Unable to retrive product total amount text.";
		}
	}

	public CartPage removeProduct(String productName) {
		try {
			String xpathString = "//table[@id='cart_info_table']/tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_delete']/a[@class='cart_quantity_delete']";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			log.info("Deleting the product from cart : '" + productName + "'.");
			element.click();
			return this;
		} catch (Exception e) {
			log.info("Unable to delete product from the cart. Error occured : " + e.getMessage());
			return this;
		}
	}

	public CartPage removeProducts(String[] productNames) {
//		boolean flag = false;
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
//			flag = false;
			log.info("Products missing in the cart : " + missingProducts);
		} else {
//			flag = true;
			log.info("Products deleted from the list : " + foundProducts);
		}
//		return flag;
		return this;
	}

	public boolean isCartEmptyLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblCartEmptyText);
			log.info("'Cart is Empty' label is displayed on cart page.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("'Cart is Empty' label not displayed on cart page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getCartEmptyText() {
		try {
			WebElement element = waitForElementToBeVisible(lblCartEmptyText);
			log.info("Cart is Empty text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Cart is Empty text. Error occured : " + e.getMessage());
			return "Unable to retrive Cart is Empty text.";
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
