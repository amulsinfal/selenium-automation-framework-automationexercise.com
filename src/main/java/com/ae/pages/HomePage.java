package com.ae.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class HomePage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(HomePage.class);
	private static final By SLIDER_CAROUSEL_LOCATOR = By.id("slider-carousel");
	private static final By SIGNUP_LOGIN_LINK_LOCATOR = By.xpath("//a[@href='/login']");
	private static final By LOGGED_IN_AS_LABEL_LOCATOR = By.xpath("//a[contains(text(),'Logged in as')]");
	private static final By DELETE_ACCOUNT_LINK_lOCATOR = By.xpath("//a[@href='/delete_account']");
	private static final By LOGOUT_LINK_lOCATOR = By.xpath("//a[@href='/logout']");
	private static final By CONTACT_US_LINK_LOCATOR = By.xpath("//a[@href='/contact_us']");
	private static final By PRODUCTS_LINK_LOCATOR = By.xpath("//a[@href='/products']");
	private static final By SUBSCRIPTION_LABEL_LOCATOR = By.xpath("//div[@class='single-widget']/h2");
	private static final By SUBSCRIPTION_EMAIL_TEXTBOX_LOCATOR = By.id("susbscribe_email");
	private static final By SUBSCRIBE_BUTTON_LOCATOR = By.id("subscribe");
	private static final By SUCCESS_MESSAGE_LABEL_LOCATOR = By.xpath("//div[@id='success-subscribe']/div[@class='alert-success alert']");
	private static final By CART_LINK_LOCATOR = By.xpath("//a[@href='/view_cart']");
	private static final By CONTINUE_SHOPPING_LOCATOR= By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private static final By TESTCASES_LINK_LOCATOR = By.xpath("//a[@href='/test_cases']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isHomePageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SLIDER_CAROUSEL_LOCATOR);
			LOG.info("Home page is visible.");
			ReportListeners.test.log(Status.PASS, "Home page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("HomePage not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "HomePage not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public SignupLoginPage clickSignupLoginLink() {
		try {
			WebElement element = waitForElementToBeVisible(SIGNUP_LOGIN_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Signup / Login Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Signup / Login Link.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Signup / Login Link." + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Signup / Login Link." + e.getMessage());
			return null;
		}
	}

	public AccountDeletedPage clickDeleteAccountLink() {
		try {
			WebElement element = waitForElementToBeVisible(DELETE_ACCOUNT_LINK_lOCATOR);
			element.click();
			LOG.info("Clicked on Delete Account Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Delete Account Link.");
			LOG.info("Navigating to Account deleted page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Account deleted page.");
			return new AccountDeletedPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Delete Account Link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Delete Account Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public TestCasesPage clickTestCasesLink() {
		try {
			WebElement element = waitForElementToBeClickable(TESTCASES_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Test cases Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Test cases Link.");
			return new TestCasesPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Test cases Link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Test cases Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isLoggedInAsUsernameVisible() {
		try {
			WebElement element = waitForElementToBeVisible(LOGGED_IN_AS_LABEL_LOCATOR);
			LOG.info("'Logged in as username' label is displayed on home page.");
			ReportListeners.test.log(Status.PASS, "'Logged in as username' label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("'Logged in as username' label not displayed on home page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "'Logged in as username' label not displayed on home page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getLoggedInAsUsernameText() {
		try {
			WebElement element = waitForElementToBeVisible(LOGGED_IN_AS_LABEL_LOCATOR);
			LOG.info("'Logged in as username' text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "'Logged in as username' text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive 'Logged in as username'  text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive 'Logged in as username'  text. Error occured : " + e.getMessage());
			return "Unable to retrive 'Logged in as username' text.";
		}
	}

	public SignupLoginPage clickLogoutLink() {
		try {
			WebElement element = waitForElementToBeVisible(LOGOUT_LINK_lOCATOR);
			element.click();
			LOG.info("Clicked on Logout Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Logout Link.");
			LOG.info("Navigating to Signup / Login page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Signup / Login page.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Logout Link.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Logout Link.");
			return null;
		}
	}

	public ContactUsPage clickContactUsLink() {
		try {
			WebElement element = waitForElementToBeVisible(CONTACT_US_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Contact us Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Contact us Link.");
			LOG.info("Navigating to Contact us page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Contact us page.");
			return new ContactUsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Contact us Link.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Contact us Link.");
			return null;
		}
	}

	public ProductsPage clickProductsLink() {
		try {
			WebElement element = waitForElementToBeVisible(PRODUCTS_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Products Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Products Link.");
			return new ProductsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Products Link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Products Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isSubscriptionLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR);
			LOG.info("'Subscription' label is displayed on home page.");
			ReportListeners.test.log(Status.PASS, "'Subscription' label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("'Subscription' label not displayed on home page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "'Subscription' label not displayed on home page. Error occured : " + e.getMessage());
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

	public HomePage clickArrowButton() {
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

	public HomePage enterSubscriptionEmail(String email) {
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
			LOG.info("Subscription success label is displayed on home page.");
			ReportListeners.test.log(Status.PASS, "Subscription success label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Subscription success label not displayed on home page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Subscription success label not displayed on home page. Error occured : " + e.getMessage());
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

	public HomePage scrollToFooter() {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR));
			LOG.info("Scrolling to footer section.");
			ReportListeners.test.log(Status.PASS, "Scrolling to footer section.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to Scroll to footer section. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to Scroll to footer section. Error occured : " + e.getMessage());
			return null;
		}
	}

	public CartPage clickCartLink() {
		try {
			WebElement element = waitForElementToBeVisible(CART_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Cart Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Cart Link.");
			LOG.info("Navigating to Cart page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Cart page.");
			return new CartPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Cart Link." + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Cart Link." + e.getMessage());
			return null;
		}
	}

	public ProductDetailsPage clickViewProduct(String productName) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(
					By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div")));
			LOG.info("Scrolling to products : " + productName);
			ReportListeners.test.log(Status.PASS, "Scrolling to products : " + productName);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
					+ productName
					+ "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a")))
					.perform();
			LOG.info("Hovering over the product : " + productName);
			ReportListeners.test.log(Status.PASS, "Hovering over the product : " + productName);
			driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName
					+ "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a"))
					.click();
			LOG.info("Clicking on the view product link of product : " + productName);
			ReportListeners.test.log(Status.PASS, "Clicking on the view product link of product : " + productName);
			return new ProductDetailsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on the view product link of product : " + productName + ". Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on the view product link of product : " + productName + ". Error occured : " + e.getMessage());
			return null;
		}
	}

	// Add multiple products to cart.
	public HomePage addToCart(String[] productNames) {
		List<String> foundProducts = new ArrayList<String>();
		List<String> productNamesList = Arrays.asList(productNames);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		int counter = 0;
		for (int i = 0; i <= elements.size() - 1; i++) {
			if (productNamesList.contains(elements.get(i).getText())) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
								+ elements.get(i).getText() + "']/parent::div")));
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']")))
						.perform();
				LOG.info("Hovering over Product : '" + elements.get(i).getText() + "'.");
				ReportListeners.test.log(Status.PASS, "Hovering over Product : '" + elements.get(i).getText() + "'.");
				driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/following-sibling::div/div/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']"))
						.click();
				LOG.info("Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				ReportListeners.test.log(Status.PASS, "Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				driver.findElement(CONTINUE_SHOPPING_LOCATOR).click();
				LOG.info("Clicked on continue shopping link.");
				ReportListeners.test.log(Status.PASS, "Clicked on continue shopping link.");
				foundProducts.add(elements.get(i).getText());
				LOG.info("Products added to cart : '" + foundProducts + "'.");
				ReportListeners.test.log(Status.PASS, "Products added to cart : '" + foundProducts + "'.");
				counter++;
				if (counter == productNames.length) {
					break;
				}
			}
		}
		return this;
	}
}
