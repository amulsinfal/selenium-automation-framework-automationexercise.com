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

	@Test (priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 2: Login User with correct email and password")
	public void verifyLoginWithCorrectEmailAndPassword() {
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		signupLoginPage = homePage.clickSignupLoginLink();
		Assert.assertTrue(signupLoginPage.isLoginToYourAccountLabelVisible()&&signupLoginPage.getLoginToYourAccountLabelText().equals("Login to your account"),"'Login to your account' label is missing or not visible.");
		
		homePage = homePage.clickSignupLoginLink().enterLoginEmail("johndoe04@email.com").enterLoginPassword("johndoe").clickLogin();
		Assert.assertTrue(homePage.isLoggedInAsUsernameVisible() && homePage.getLoggedInAsUsernameText().equals("Logged in as johndoe04"), "'Logged in as username' label is missing or not visible.");
		
//		accountDeletedPage = homePage.clickDeleteAccountLink();
//		Assert.assertTrue(accountDeletedPage.isAccountDeletedLabelVisible() && accountDeletedPage.getAccountDeletedLabelText().equals("ACCOUNT DELETED!"), "'ACCOUNT DELETED!' label is missing or not visible.");
	}

	@Test (priority = 1, groups = {"Sanity", "Regression"}, description = "Test Case 3: Login User with incorrect email and password")
	public void verifyLoginWithIncorrectEmailAndPassword() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		signupLoginPage = homePage.clickSignupLoginLink();
		Assert.assertTrue(signupLoginPage.isLoginToYourAccountLabelVisible() && signupLoginPage.getLoginToYourAccountLabelText().equals("Login to your account"),"'Login to your account' label is missing or not visible.");
		
		homePage = homePage.clickSignupLoginLink().enterLoginEmail("johndoexx@email.com").enterLoginPassword("johndoe").clickLogin();
		signupLoginPage = new SignupLoginPage(driver);
		Assert.assertTrue(signupLoginPage.isLoginErrorVisible() && signupLoginPage.getLoginErrorText().equals("Your email or password is incorrect!"), "'Your email or password is incorrect!' label is missing or not visible.");
	}
}