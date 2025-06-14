package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;

public class SignupLoginPage extends BasePage {

	private static final Logger log = LogManager.getLogger(SignupLoginPage.class);
	private final By lblLoginFormHeader = By.xpath("//div[@class='login-form']/h2");
	private final By txtLoginEmail = By.name("email");
	private final By txtLoginPassword = By.name("password");
	private final By btnLogin = By.xpath("//button[@data-qa='login-button']");
	private final By lblLoginError = By.xpath("//div[@class='login-form']/form/p");

	private final By lblSignupFormHeader = By.xpath("//div[@class='signup-form']/h2");
	private final By txtSignupName = By.name("name");
	private final By txtSignupEmail = By.xpath("//input[@data-qa='signup-email']");
	private final By btnSignup = By.xpath("//button[@data-qa='signup-button']");
	private final By lblSignupError = By.xpath("//div[@class='signup-form']/form/p");

	private final By lnkHome = By.xpath("//a[@href='/' and contains(text(),'Home')]");

	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean isLoginToYourAccountLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblLoginFormHeader);
			log.info("Login To Your Account Label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Login To Your Account Label not displayed on the Signup / login page. Error occured : "
					+ e.getMessage());
			return false;
		}
	}

	public String getLoginToYourAccountLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(lblLoginFormHeader);
			log.info("Login To Your Account Label text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Login To Your Account Label text on the Signup / login page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Login To Your Account Label text on the Signup / login page.";
		}
	}

	public SignupLoginPage enterLoginEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(txtLoginEmail);
			element.sendKeys(email);
			log.info("'" + email + "' entered in the login email text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + email + "' text in the login email text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupLoginPage enterLoginPassword(String password) {
		try {
			WebElement element = waitForElementToBeClickable(txtLoginPassword);
			element.sendKeys(password);
			log.info("'" + password + "' entered in the login password text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + password + "' text in the login password text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public HomePage clickLogin() {
		try {
			WebElement element = waitForElementToBeClickable(btnLogin);
			element.click();
			log.info("Clicked on the Login button.");
			return new HomePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Login button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isLoginErrorVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblLoginError);
			log.info("Login error label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Login error lable not displayed on the Signup / login page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getLoginErrorText() {
		try {
			WebElement element = waitForElementToBeVisible(lblLoginError);
			log.info("Login error text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info(
					"Unable to retrive Login error text on the Signup / login page. Error occured : " + e.getMessage());
			return "Unable to retrive Login error text on the Signup / login page.";
		}
	}

	public boolean isSignupLoginPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(btnLogin);
			log.info("Signup / Login page is displayed.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Signup / Login page not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public boolean isNewUserSignupLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblSignupFormHeader);
			log.info("New user signup label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("New user signup label not displayed on the Signup / login page. Error occured : "
					+ e.getMessage());
			return false;
		}
	}

	public String getNewUserSignupLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(lblSignupFormHeader);
			log.info("New user signup text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive New user signup text on the Signup / login page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive New user signup text on the Signup / login page.";
		}
	}

	public SignupLoginPage enterSignupName(String name) {
		try {
			WebElement element = waitForElementToBeClickable(txtSignupName);
			element.sendKeys(name);
			log.info("'" + name + "' entered in the signup name text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + name + "' text in the signup name text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupLoginPage enterSignupEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(txtSignupEmail);
			element.sendKeys(email);
			log.info("'" + email + "' entered in the signup email text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + email + "' text in the signup email text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage clickSignup() {
		try {
			WebElement element = waitForElementToBeClickable(btnSignup);
			element.click();
			log.info("Clicked on the Signup button.");
			return new SignupPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Signup button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isSignupErrorVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblSignupError);
			log.info("Signup error label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Signup error lable not displayed on the Signup / login page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSignupErrorText() {
		try {
			WebElement element = waitForElementToBeVisible(lblSignupError);
			log.info("Signup error text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Signup error text on the Signup / login page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Signup error text on the Signup / login page.";
		}
	}

	public HomePage clickHomeLink() {
		try {
			WebElement element = waitForElementToBeVisible(lnkHome);
			element.click();
			log.info("Clicked on Home Link.");
			return new HomePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Home Link." + e.getMessage());
			return null;
		}
	}
}
