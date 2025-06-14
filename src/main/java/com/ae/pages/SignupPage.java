package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ae.base.BasePage;
import com.ae.objects.CustomerAccountInformation;
import com.ae.objects.CustomerAddressInformation;
import com.ae.objects.Customers;

public class SignupPage extends BasePage {

	private static final Logger log = LogManager.getLogger(SignupPage.class);
	private final By txtPassword = By.id("password");
	private final By drpDays = By.id("days");
	private final By drpMonths = By.id("months");
	private final By drpYears = By.id("years");
	private final By chkNewsletter = By.id("newsletter");
	private final By chkSpecialOffer = By.id("optin");
	private final By txtFirstName = By.id("first_name");
	private final By txtLastName = By.id("last_name");
	private final By txtCompany = By.id("company");
	private final By txtAddress1 = By.id("address1");
	private final By txtAddress2 = By.id("address2");
	private final By drpCountry = By.id("country");
	private final By txtState = By.id("state");
	private final By txtCity = By.id("city");
	private final By txtZipcode = By.id("zipcode");
	private final By txtMobileNumber = By.id("mobile_number");
	private final By btnCreateAccount = By.xpath("//button[@data-qa='create-account']");
	private final By lblEnterAccInfo = By.xpath("//div[@class='login-form']/h2/b");

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	private SignupPage selectTitle(String title) {
		try {
			String xpathString = "//input[@name='title' and @value='" + title + "']";
			WebElement element = waitForElementToBeClickable(By.xpath(xpathString));
			element.click();
			log.info("Clicked on the title: " + title);
			return this;
		} catch (Exception e) {
			log.info("Unable to click on the title: " + title + ". Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage enterPassword(String password) {
		try {
			WebElement element = waitForElementToBeClickable(txtPassword);
			element.sendKeys(password);
			log.info("'" + password + "' entered in the password text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + password + "' text in the password text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage selectDay(String day) {
		try {
			WebElement element = waitForElementToBeClickable(drpDays);
			Select select = new Select(element);
			select.selectByVisibleText(day);
			log.info("'" + day + "' selected in the day dropdown list box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to select '" + day + "' text in the the day dropdown list box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage selectMonth(String month) {
		try {
			WebElement element = waitForElementToBeClickable(drpMonths);
			Select select = new Select(element);
			select.selectByVisibleText(month);
			log.info("'" + month + "' selected in the month dropdown list box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to select '" + month + "' text in the the month dropdown list box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage selectYear(String year) {
		try {
			WebElement element = waitForElementToBeClickable(drpYears);
			Select select = new Select(element);
			select.selectByVisibleText(year);
			log.info("'" + year + "' selected in the year dropdown list box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to select '" + year + "' text in the the year dropdown list box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage selectNewsLetter(String value) {
		try {
			WebElement element = waitForElementToBeClickable(chkNewsletter);
			if (value.equalsIgnoreCase("Yes")) {
				element.click();
				log.info("NewsLetter checkbox selected.");
			} else {
				log.info("NewsLetter checkbox not selected.");
			}
			return this;
		} catch (Exception e) {
			log.info("Unable to click on the newletters checkbox. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage selectSpecialOffer(String value) {
		try {
			WebElement element = waitForElementToBeClickable(chkSpecialOffer);
			if (value.equalsIgnoreCase("Yes")) {
				element.click();
				log.info("Speical offer checkbox selected.");
			} else {
				log.info("Speical offer checkbox not selected.");
			}
			return this;
		} catch (Exception e) {
			log.info("Unable to click on the Speical offer checkbox. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterFirstName(String firstName) {
		try {
			WebElement element = waitForElementToBeClickable(txtFirstName);
			element.sendKeys(firstName);
			log.info("'" + firstName + "' entered in the firstName text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + firstName + "' text in the firstName text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage enterLastName(String lastName) {
		try {
			WebElement element = waitForElementToBeClickable(txtLastName);
			element.sendKeys(lastName);
			log.info("'" + lastName + "' entered in the lastName text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + lastName + "' text in the lastName text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage enterCompany(String company) {
		try {
			WebElement element = waitForElementToBeClickable(txtCompany);
			element.sendKeys(company);
			log.info("'" + company + "' entered in the company text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + company + "' text in the company text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage enterAddress1(String address1) {
		try {
			WebElement element = waitForElementToBeClickable(txtAddress1);
			element.sendKeys(address1);
			log.info("'" + address1 + "' entered in the address1 text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + address1 + "' text in the address1 text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage enterAddress2(String address2) {
		try {
			WebElement element = waitForElementToBeClickable(txtAddress2);
			element.sendKeys(address2);
			log.info("'" + address2 + "' entered in the address2 text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + address2 + "' text in the address2 text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage selectCountry(String country) {
		try {
			WebElement element = waitForElementToBeClickable(drpCountry);
			Select select = new Select(element);
			select.selectByVisibleText(country);
			log.info("'" + country + "' selected in the country dropdown list box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to select '" + country + "' text in the the country dropdown list box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage enterState(String state) {
		try {
			WebElement element = waitForElementToBeClickable(txtState);
			element.sendKeys(state);
			log.info("'" + state + "' entered in the state text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + state + "' text in the state text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterCity(String city) {
		try {
			WebElement element = waitForElementToBeClickable(txtCity);
			element.sendKeys(city);
			log.info("'" + city + "' entered in the city text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + city + "' text in the city text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterZipcode(String zipcode) {
		try {
			WebElement element = waitForElementToBeClickable(txtZipcode);
			element.sendKeys(zipcode);
			log.info("'" + zipcode + "' entered in the zipcode text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + zipcode + "' text in the zipcode text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private SignupPage enterMobile(String mobileNumber) {
		try {
			WebElement element = waitForElementToBeClickable(txtMobileNumber);
			element.sendKeys(mobileNumber);
			log.info("'" + mobileNumber + "' entered in the mobile number text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + mobileNumber + "' text in the mobile number text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public AccountCreatedPage clickCreateAccount() {
		try {
			WebElement element = waitForElementToBeClickable(btnCreateAccount);
			element.click();
			log.info("Clicked on the Create Account button.");
			log.info("Navigating to Account created page.");
			return new AccountCreatedPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Craete Account button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public SignupPage fillCustomerAccountInformation(CustomerAccountInformation customerAccountInformation) {
		return selectTitle(customerAccountInformation.getTitle()).enterPassword(customerAccountInformation.getPassword()).selectDay(customerAccountInformation.getDay())
				.selectMonth(customerAccountInformation.getMonth()).selectYear(customerAccountInformation.getYear());
	}
	
	public SignupPage fillCustomerAddressInformation(CustomerAddressInformation customerAddressInformation) {
		return enterFirstName(customerAddressInformation.getFirstName()).enterLastName(customerAddressInformation.getLastName())
				.enterCompany(customerAddressInformation.getCompany()).enterAddress1(customerAddressInformation.getAddress1())
				.enterAddress2(customerAddressInformation.getAddress2()).selectCountry(customerAddressInformation.getCountry())
				.enterState(customerAddressInformation.getState()).enterCity(customerAddressInformation.getCity()).enterZipcode(customerAddressInformation.getZipcode())
				.enterMobile(customerAddressInformation.getMobileNumber());
	}

	public SignupPage fillCustomerInformation(Customers customer) {
		return selectTitle(customer.getTitle()).enterPassword(customer.getPassword()).selectDay(customer.getDay())
				.selectMonth(customer.getMonth()).selectYear(customer.getYear())
				.selectNewsLetter(customer.getNewsletter()).selectSpecialOffer(customer.getSpecialOffer())
				.enterFirstName(customer.getFirstName()).enterLastName(customer.getLastName())
				.enterCompany(customer.getCompany()).enterAddress1(customer.getAddress1())
				.enterAddress2(customer.getAddress2()).selectCountry(customer.getCountry())
				.enterState(customer.getState()).enterCity(customer.getCity()).enterZipcode(customer.getZipcode())
				.enterMobile(customer.getMobileNumber());
	}

	public boolean isEnterAccountInformationLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblEnterAccInfo);
			log.info("Account information header is displayed on the Signup page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Account information header not displayed on the Signup page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getEnterAccountInformationLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(lblEnterAccInfo);
			log.info("Account information header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Account information header text on the Signup page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Account information header text on the Signup page.";
		}
	}

}
