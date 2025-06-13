package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.Customers;
import com.ae.pages.AccountCreatedPage;
import com.ae.pages.AccountDeletedPage;
import com.ae.pages.HomePage;
import com.ae.pages.SignupLoginPage;
import com.ae.pages.SignupPage;

public class RegisterTest extends BaseTest{
	HomePage homePage;
	SignupLoginPage signupLoginPage;
	SignupPage signupPage;
	AccountCreatedPage accountCreatedPage;
	AccountDeletedPage accountDeletedPage;
	
	/*
	 * Test Case 1: Register User
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		4. Click on 'Signup / Login' button
		6. Enter name and email address
		7. Click 'Signup' button
		9. Fill details: Title, Name, Email, Password, Date of birth
		10. Select checkbox 'Sign up for our newsletter!'
		11. Select checkbox 'Receive special offers from our partners!'
		12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		13. Click 'Create Account button'
		15. Click 'Continue' button
		16. Verify that 'Logged in as username' is visible
	 */
	
	@Test (priority = 0, description = "Test Case 1: Register User with new email")
	public void verifyRegisterWithNewEmail() {
		Customers customer = new Customers();
		customer.setTitle("Mr");
		customer.setPassword("johndoe");
		customer.setDay("15");
		customer.setMonth("August");
		customer.setYear("1990");
		customer.setNewsletter("Yes");
		customer.setSpecialOffer("Yes");
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setCompany("The Lawrence Company");
		customer.setAddress1("1379, Spring Hill Rd");
		customer.setAddress2("Farend avenue");
		customer.setCountry("United States");
		customer.setState("AR");
		customer.setCity("Shreveport");
		customer.setZipcode("50576");
		customer.setMobileNumber("9999999999");
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		signupLoginPage = homePage.clickSignupLoginLink();
		signupPage = signupLoginPage.enterSignupName("johndoe05").enterSignupEmail("johndoe05@email.com").clickSignup();
		Assert.assertTrue(signupPage.isEnterAccountInformationLabelIsVisible() && signupPage.getEnterAccountInformationText() .equals("ENTER ACCOUNT INFORMATION"), "'ENTER ACCOUNT INFORMATION' label is missing or not visible.");
		accountCreatedPage = signupPage.fillCustomerInformation(customer).clickCreateAccount();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedHeaderVisible() && accountCreatedPage.getAccountCreatedHeaderText() .equals("ACCOUNT CREATED!"), "'ACCOUNT CREATED!' label is missing or not visible.");
		homePage = accountCreatedPage.clickContinue();
		Assert.assertTrue(homePage.isLoggedInAsUsernameVisible() && homePage.getLoggedInAsUsernameText().equals("Logged in as johndoe05"), "'Logged in as username' label is missing or not visible.");
	}
	
	/*
	 * 1. Launch browser
	 * 2. Navigate to url 'http://automationexercise.com'
	 * 3. Click on 'Signup / Login' button
	 * 4. Enter name and already registered email address
	 * 5. Click 'Signup' button
	 * 6. Verify error 'Email Address already exist!' is visible
	 */
	
	@Test (priority = 1, description = "Test Case 5: Register User with existing email.")
	public void verifyRegisterWithExistingEmail() {
		homePage = new HomePage(driver);
		signupPage = homePage.clickSignupLoginLink().enterSignupName("Johndoe01").enterSignupEmail("johndoe01@email.com").clickSignup();
		signupLoginPage = new SignupLoginPage(driver);
		Assert.assertTrue(signupLoginPage.isSignupErrorVisible() && signupLoginPage.getSignupErrorText().equals("Email Address already exist!"), "'Email Address already exist!' label is missing or not visible.");
	}
}
