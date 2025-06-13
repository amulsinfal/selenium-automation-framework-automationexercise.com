package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.HomePage;
import com.ae.pages.SignupLoginPage;

public class LogoutTest extends BaseTest{
	HomePage homePage;
	SignupLoginPage signupLoginPage;
	
	/*
	 * 1. Launch browser
	 * 2. Navigate to url 'http://automationexercise.com'
	 * 3. Click on 'Signup / Login' button
	 * 4. Enter correct email address and password
	 * 5. Click 'login' button
	 * 6. Click 'Logout' button
	 * 7. Verify that user is navigated to login page
	 */
	
	@Test (priority = 0, description = "Test Case 4: Logout User")
	public void verifyLogoutFromWebsite() {
		homePage = new HomePage(driver);
		signupLoginPage = homePage.clickSignupLoginLink().enterLoginEmail("johndoe01@email.com").enterLoginPassword("johndoe").clickLogin().clickLogoutLink();
		Assert.assertTrue(signupLoginPage.isSignupLoginPageVisible(), "Signup / login page not displayed.");
	}
	
}
