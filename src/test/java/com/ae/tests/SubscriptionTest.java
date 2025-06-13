package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.CartPage;
import com.ae.pages.HomePage;

public class SubscriptionTest extends BaseTest{
	HomePage homePage;
	CartPage cartPage;
	
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Scroll down to footer
	//	4. Enter email address in input and click arrow button
	//	5. Verify success message 'You have been successfully subscribed!' is visible

	@Test (priority = 0, description="Test Case 10: Verify Subscription in home page.")
	public void testToVerifySubscriptionSuccessMessageInTheHomePage() {
		homePage = new HomePage(driver);
		homePage.scrollToFooter().enterSubscriptionEmail("johndoe01@email.com").clickSubscribe();
		Assert.assertTrue(homePage.isSubscriptionSuccessLabelDisplayed() && homePage.getSubscriptionSuccessText().equals("You have been successfully subscribed!"));
	}
	
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Click 'Cart' button
	//	4. Scroll down to footer
	//	5. Enter email address in input and click arrow button
	//	6. Verify success message 'You have been successfully subscribed!' is visible

	@Test (priority = 1, description="Test Case 11: Verify Subscription in Cart page.")
	public void testToVerifySubscriptionSuccessMessageInTheCartPage() {
		homePage = new HomePage(driver);
		cartPage = homePage.clickCartLink().scrollToFooter().enterSubscriptionEmail("johndoe01@email.com").clickSubscribe();
		Assert.assertTrue(cartPage.isSubscriptionSuccessLabelDisplayed() && cartPage.getSubscriptionSuccessText().equals("You have been successfully subscribed!"));
	}

}
