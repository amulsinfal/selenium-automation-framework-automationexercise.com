package com.ae.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ae.objects.CustomerAccountInformation;
import com.ae.objects.CustomerAddressInformation;
import com.ae.pages.HomePage;
import com.ae.pages.SignupLoginPage;
import com.ae.utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	private static final Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	public void setup() {
		driver = PageDriver.intializeDriver(ConfigReader.readProperty("browser"));
		log.info("Navigating to url: '" + ConfigReader.readProperty("url") + "'");
		driver.get(ConfigReader.readProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		log.info("Quitting the browser.");
		driver.quit();
	}
	
	public void RegisterUser() {
		log.info("Creating user 'johndoe04' for testing.");
		createUser("johndoe04","johndoe04@email.com");		
	}
	
	public void RemoveUser() {
		log.info("Deleting user 'johndoe04' after testing.");
		deleteUser("johndoe04@email.com","johndoe04");
	}
	
	private void createUser(String username, String email) {
		CustomerAccountInformation customerAccountInformation = new CustomerAccountInformation();
		customerAccountInformation.setTitle("Mr");
		customerAccountInformation.setPassword("johndoe");
		customerAccountInformation.setDay("15");
		customerAccountInformation.setMonth("August");
		customerAccountInformation.setYear("1990");
		CustomerAddressInformation customerAddressInformation = new CustomerAddressInformation();
		customerAddressInformation.setFirstName("John");
		customerAddressInformation.setLastName("Doe");
		customerAddressInformation.setCompany("The Lawrence Company");
		customerAddressInformation.setAddress1("1379, Spring Hill Rd");
		customerAddressInformation.setAddress2("Farend avenue");
		customerAddressInformation.setCountry("United States");
		customerAddressInformation.setState("AR");
		customerAddressInformation.setCity("Shreveport");
		customerAddressInformation.setZipcode("50576");
		customerAddressInformation.setMobileNumber("9999999999");
		
		new HomePage(driver).clickSignupLoginLink()
		.enterSignupName(username).enterSignupEmail(email).clickSignup()
		.fillCustomerAccountInformation(customerAccountInformation)
		.selectNewsLetter("Yes").selectSpecialOffer("Yes")
		.fillCustomerAddressInformation(customerAddressInformation)
		.clickCreateAccount().clickContinue()
		.clickLogoutLink().clickHomeLink();
	}
	
	private void deleteUser(String email, String password) {
		HomePage homePage = new HomePage(driver).clickSignupLoginLink().enterLoginEmail(email).enterLoginPassword(password).clickLogin();
		SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
		if((!signupLoginPage.isSignupErrorVisible() && signupLoginPage.getSignupErrorText().equals("Email Address already exist!"))) {
			homePage.clickDeleteAccountLink();		
		}
	}
}
