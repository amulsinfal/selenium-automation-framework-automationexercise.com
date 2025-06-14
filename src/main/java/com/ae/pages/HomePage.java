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

public class HomePage extends BasePage {

	private static final Logger log = LogManager.getLogger(HomePage.class);
	private final By homePageSlider = By.id("slider-carousel");
	private final By lnkSignupLogin = By.xpath("//a[@href='/login']");
	private final By lblLoggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
	private final By lnkDeleteAccount = By.xpath("//a[@href='/delete_account']");
	private final By lnkLogout = By.xpath("//a[@href='/logout']");
	private final By lnkContactUs = By.xpath("//a[@href='/contact_us']");
	private final By lnkProducts = By.xpath("//a[@href='/products']");
	private final By lblSubscription = By.xpath("//div[@class='single-widget']/h2");
	private final By txtSubscriptionEmail = By.id("susbscribe_email");
	private final By btnSubscribe = By.id("subscribe");
	private final By lblSubscribeSuccessMessage = By
			.xpath("//div[@id='success-subscribe']/div[@class='alert-success alert']");
	private final By lnkCart = By.xpath("//a[@href='/view_cart']");
	private final By btnContinueShopping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private final By lnkTestCases = By.xpath("//a[@href='/test_cases']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isHomePageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(homePageSlider);
			log.info("Home page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("HomePage not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public SignupLoginPage clickSignupLoginLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkSignupLogin);
			element.click();
			log.info("Clicked on Signup / Login Link.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Signup / Login Link." + e.getMessage());
			return null;
		}
	}

	public AccountDeletedPage clickDeleteAccountLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkDeleteAccount);
			element.click();
			log.info("Clicked on Delete Account Link.");
			log.info("Navigating to Account deleted page.");
			return new AccountDeletedPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Delete Account Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public TestCasesPage clickTestCasesLink() {
		try {
			WebElement element = waitForElementToBeClickable(lnkTestCases);
			element.click();
			log.info("Clicked on Test cases Link.");
			return new TestCasesPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Test cases Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isLoggedInAsUsernameVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblLoggedInAs);
			log.info("'Logged in as username' label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("'Logged in as username' label not displayed on home page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getLoggedInAsUsernameText() {
		try {
			WebElement element = waitForElementToBeVisible(lblLoggedInAs);
			log.info("'Logged in as username' text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive 'Logged in as username'  text. Error occured : " + e.getMessage());
			return "Unable to retrive 'Logged in as username' text.";
		}
	}

	public SignupLoginPage clickLogoutLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkLogout);
			element.click();
			log.info("Clicked on Logout Link.");
			log.info("Navigating to Signup / Login page.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Logout Link.");
			return null;
		}
	}

	public ContactUsPage clickContactUsLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkContactUs);
			element.click();
			log.info("Clicked on Contact us Link.");
			log.info("Navigating to Contact us page.");
			return new ContactUsPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Contact us Link.");
			return null;
		}
	}

	public ProductsPage clickProductsLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkProducts);
			element.click();
			log.info("Clicked on Products Link.");
			return new ProductsPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Products Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isSubscriptionLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(lblSubscription);
			log.info("'Subscription' label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("'Subscription' label not displayed on home page. Error occured : " + e.getMessage());
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

	public HomePage clickArrowButton() {
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

	public HomePage enterSubscriptionEmail(String email) {
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
			log.info("Subscription success label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Subscription success label not displayed on home page. Error occured : " + e.getMessage());
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

	public HomePage scrollToFooter() {
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

	public CartPage clickCartLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkCart);
			element.click();
			log.info("Clicked on Cart Link.");
			log.info("Navigating to Cart page.");
			return new CartPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Cart Link." + e.getMessage());
			return null;
		}
	}

	public ProductDetailsPage clickViewProduct(String productName) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(
					By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div")));
			log.info("Scrolling to products : " + productName);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
					+ productName
					+ "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a")))
					.perform();
			log.info("Hovering over the product : " + productName);
			driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName
					+ "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a"))
					.click();
			log.info("Clicking on the view product link of product : " + productName);
			return new ProductDetailsPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on the view product link of product : " + productName + ". Error occured : "
					+ e.getMessage());
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
				log.info("Hovering over Product : '" + elements.get(i).getText() + "'.");
				driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/following-sibling::div/div/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']"))
						.click();
				log.info("Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				driver.findElement(btnContinueShopping).click();
				log.info("Clicked on continue shopping link.");
				foundProducts.add(elements.get(i).getText());
				log.info("Products added to cart : '" + foundProducts + "'.");
				counter++;
				if (counter == productNames.length) {
					break;
				}
			}
		}
		return this;
	}
}
