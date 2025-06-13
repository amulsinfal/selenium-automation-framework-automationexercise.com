package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.AccountDeletedPage;
import com.ae.pages.HomePage;
import com.ae.pages.SignupLoginPage;

public class LoginTest extends BaseTest {
	HomePage homePage;
	SignupLoginPage signupLoginPage;
	AccountDeletedPage accountDeletedPage;	

	/*
	 * 1. Launch browser
	 * 2. Navigate to url 'http://automationexercise.com'
	 * 3. Click on 'Signup / Login' button
	 * 4. Enter correct email address and password
	 * 5. Click 'login' button
	 * 6. Verify that 'Logged in as username' is visible
	 */

	@Test (priority = 0, description = "Test Case 1: Login User with correct email and password")
	public void verifyLoginWithCorrectEmailAndPassword() {
		homePage = new HomePage(driver);
		homePage.clickSignupLoginLink().enterLoginEmail("johndoe02@email.com").enterLoginPassword("johndoe").clickLogin();
		Assert.assertTrue(homePage.isLoggedInAsUsernameVisible() && homePage.getLoggedInAsUsernameText().equals("Logged in as johndoe02"), "'Logged in as username' label is missing or not visible.");
	}

	/*
	 * 1. Launch browser
	 * 2. Navigate to url 'http://automationexercise.com'
	 * 3. Click on 'Signup / Login' button
	 * 4. Enter incorrect email address and password
	 * 5. Click 'login' button
	 * 6. Verify error 'Your email or password is incorrect!' is visible
	 */

	@Test (priority = 1, description = "Test Case 2: Login User with incorrect email and password")
	public void verifyLoginWithIncorrectEmailAndPassword() {
		homePage = new HomePage(driver);
		homePage = homePage.clickSignupLoginLink().enterLoginEmail("johndoexx@email.com").enterLoginPassword("johndoe").clickLogin();
		signupLoginPage = new SignupLoginPage(driver);
		Assert.assertTrue(signupLoginPage.isLoginErrorVisible() && signupLoginPage.getLoginErrorText().equals("Your email or password is incorrect!"), "'Your email or password is incorrect!' label is missing or not visible.");
	}
}