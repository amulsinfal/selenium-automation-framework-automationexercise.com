package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ae.base.BasePage;
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
	private final By lblAddressInfo = By
			.xpath("//div[@id='uniform-optin']/parent::div[@class='checkbox']/following-sibling::h2/b");

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	public SignupPage selectTitle(String title) {
		try {
			String xpathString = "//input[@name='title' and @value='" + title + "']";
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathString)));
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
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
			element.sendKeys(password);
			log.info("'" + password + "' entered in the password text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + password + "' text in the password text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage selectDay(String day) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(drpDays));
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

	public SignupPage selectMonth(String month) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(drpMonths));
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

	public SignupPage selectYear(String year) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(drpYears));
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
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chkNewsletter));
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
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chkSpecialOffer));
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

	public SignupPage enterFirstName(String firstName) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtFirstName));
			element.sendKeys(firstName);
			log.info("'" + firstName + "' entered in the firstName text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + firstName + "' text in the firstName text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage enterLastName(String lastName) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtLastName));
			element.sendKeys(lastName);
			log.info("'" + lastName + "' entered in the lastName text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + lastName + "' text in the lastName text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage enterCompany(String company) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtCompany));
			element.sendKeys(company);
			log.info("'" + company + "' entered in the company text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + company + "' text in the company text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage enterAddress1(String address1) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtAddress1));
			element.sendKeys(address1);
			log.info("'" + address1 + "' entered in the address1 text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + address1 + "' text in the address1 text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage enterAddress2(String address2) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtAddress2));
			element.sendKeys(address2);
			log.info("'" + address2 + "' entered in the address2 text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + address2 + "' text in the address2 text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage selectCountry(String country) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(drpCountry));
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

	public SignupPage enterState(String state) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtState));
			element.sendKeys(state);
			log.info("'" + state + "' entered in the state text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + state + "' text in the state text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage enterCity(String city) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtCity));
			element.sendKeys(city);
			log.info("'" + city + "' entered in the city text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + city + "' text in the city text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage enterZipcode(String zipcode) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtZipcode));
			element.sendKeys(zipcode);
			log.info("'" + zipcode + "' entered in the zipcode text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + zipcode + "' text in the zipcode text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public SignupPage enterMobile(String mobileNumber) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtMobileNumber));
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
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnCreateAccount));
			element.click();
			log.info("Clicked on the Create Account button.");
			log.info("Navigating to Account created page.");
			return new AccountCreatedPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Craete Account button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public SignupPage setCustomer(Customers customer) {
		return selectTitle(customer.getTitle()).enterPassword(customer.getPassword()).selectDay(customer.getDay())
				.selectMonth(customer.getMonth()).selectYear(customer.getYear())
				.selectNewsLetter(customer.getNewsletter()).selectSpecialOffer(customer.getSpecialOffer())
				.enterFirstName(customer.getFirstName()).enterLastName(customer.getLastName())
				.enterCompany(customer.getCompany()).enterAddress1(customer.getAddress1())
				.enterAddress2(customer.getAddress2()).selectCountry(customer.getCountry())
				.enterState(customer.getState()).enterCity(customer.getCity()).enterZipcode(customer.getZipcode())
				.enterMobile(customer.getMobileNumber());
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

	public boolean isEnterAccountInformationLabelIsVisible() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lblEnterAccInfo));
			log.info("Account information header is displayed on the Signup page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Account information header not displayed on the Signup page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getEnterAccountInformationText() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lblEnterAccInfo));
			log.info("Account information header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Account information header text on the Signup page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Account information header text on the Signup page.";
		}
	}

	public boolean isAddressInformationLabelIsVisible() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lblAddressInfo));
			log.info("Address information header is displayed on the Signup page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Address information header not displayed on the Signup page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getAddressInformationText() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lblAddressInfo));
			log.info("Address information header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Address information header text on the Signup page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Address information header text on the Signup page.";
		}
	}

}
