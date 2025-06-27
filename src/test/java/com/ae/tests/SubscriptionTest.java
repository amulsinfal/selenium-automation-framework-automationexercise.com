package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.CartPage;
import com.ae.pages.HomePage;

public class SubscriptionTest extends BaseTest{
	HomePage homePage;
	CartPage cartPage;

	@Test (priority = 0, groups = {"Regression"}, description="Test Case 10: Verify Subscription in home page")
	public void verifySubscriptionInHomePage() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		homePage = homePage.scrollToFooter();
		Assert.assertTrue(homePage.isSubscriptionLabelDisplayed() && homePage.getSubscriptionText().equals("SUBSCRIPTION"),"'SUBSCRIPTION' label is missing or not visible.");
		
		homePage = homePage.enterSubscriptionEmail("johndoe01@email.com").clickArrowButton();
		Assert.assertTrue(homePage.isSubscriptionSuccessLabelDisplayed() && homePage.getSubscriptionSuccessText().equals("You have been successfully subscribed!"),"'You have been successfully subscribed!' label is missing or not visible.");
	}
	
	@Test (priority = 0, groups = {"Regression"}, description="Test Case 11: Verify Subscription in Cart page")
	public void verifySubscriptionInCartPage() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		cartPage = homePage.clickCartLink().scrollToFooter();
		Assert.assertTrue(cartPage.isSubscriptionLabelDisplayed() && cartPage.getSubscriptionText().equals("SUBSCRIPTION"),"'SUBSCRIPTION' label is missing or not visible.");
		
		cartPage = cartPage.enterSubscriptionEmail("johndoe01@email.com").clickArrowButton();
		Assert.assertTrue(cartPage.isSubscriptionSuccessLabelDisplayed() && cartPage.getSubscriptionSuccessText().equals("You have been successfully subscribed!"),"'You have been successfully subscribed!' label is missing or not visible.");
	}
	
}
