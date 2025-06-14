package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.Customers;
import com.ae.objects.Payments;
import com.ae.pages.AccountCreatedPage;
import com.ae.pages.CartPage;
import com.ae.pages.CheckoutPage;
import com.ae.pages.HomePage;
import com.ae.pages.PaymentDonePage;
import com.ae.pages.PaymentPage;
import com.ae.pages.SignupLoginPage;

public class CheckoutTest extends BaseTest {
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	SignupLoginPage signupLoginPage;
	PaymentPage paymentPage;
	PaymentDonePage paymentDonePage;
	AccountCreatedPage accountCreatedPage;
	
	@Test(priority = 0, description = "Test Case 14: Place Order: Register while Checkout.")
	public void testToRegisterWhileCheckout() {
		
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
		
		Payments payment = new Payments();
		payment.setNameOnCard("John Doe");
		payment.setCardNumber("6452789545625468");
		payment.setCvc("311");
		payment.setExpiryMonth("05");
		payment.setExpiryYear("2026");
		
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		cartPage = homePage.addToCart(productsToAddToCart).clickCartLink().clickProceedToCheckout();
		cartPage.clickRegisterLoginLink();
		signupLoginPage = new SignupLoginPage(driver);
		accountCreatedPage = signupLoginPage.enterSignupName("johndoe05").enterSignupEmail("johndoe05@email.com").clickSignup().fillCustomerInformation(customer).clickCreateAccount();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedLabelVisible() && accountCreatedPage.getAccountCreatedLabelText() .equals("ACCOUNT CREATED!"), "'ACCOUNT CREATED!' label is missing or not visible.");
		homePage = accountCreatedPage.clickContinue();
		Assert.assertTrue(homePage.isLoggedInAsUsernameVisible() && homePage.getLoggedInAsUsernameText().equals("Logged in as johndoe05"), "'Logged in as username' label is missing or not visible.");
		cartPage = homePage.clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(),"Cart page not visible.");		
		cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.getCustomerName().equals("Mr. John Doe"),"Customer name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCompany().equals("The Lawrence Company"),"Customer company name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress1().equals("1379, Spring Hill Rd"),"Customer address1 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress2().equals("Farend avenue"),"Customer address2 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCityStateZip().equals("Shreveport AR 50576"),"Customer city, state and zipcode is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCountry().equals("United States"),"Customer country is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerMobile().equals("9999999999"),"Customer mobile is incorrect.");
		Assert.assertTrue(checkoutPage.getProductPrice("Blue Top").equals("500"),"Product Price is incorrect.");
		Assert.assertTrue(checkoutPage.getProductQuantity("Blue Top").equals("1"),"Product Quantity is incorrect.");
		Assert.assertTrue(checkoutPage.getProductTotalAmount("Blue Top").equals("500"),"Product Total Amount is incorrect.");
		Assert.assertTrue(checkoutPage.getProductPrice("Men Tshirt").equals("400"),"Product Price is incorrect.");
		Assert.assertTrue(checkoutPage.getProductQuantity("Men Tshirt").equals("1"),"Product Quantity is incorrect.");
		Assert.assertTrue(checkoutPage.getProductTotalAmount("Men Tshirt").equals("400"),"Product Total Amount is incorrect.");		
		paymentDonePage =  checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder().fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible() && paymentDonePage.getConfirmedMessageText().equals("Congratulations! Your order has been confirmed!"), "");
		homePage.clickDeleteAccountLink().clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
	@Test(priority = 1, description = "Test Case 15: Place Order: Register before Checkout")
	public void testToRegisterBeforeCheckout() {
		
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
		
		Payments payment = new Payments();
		payment.setNameOnCard("John Doe");
		payment.setCardNumber("6452789545625468");
		payment.setCvc("311");
		payment.setExpiryMonth("05");
		payment.setExpiryYear("2026");
		
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		signupLoginPage = homePage.clickSignupLoginLink();
		accountCreatedPage = signupLoginPage.enterSignupName("johndoe05").enterSignupEmail("johndoe05@email.com").clickSignup().fillCustomerInformation(customer).clickCreateAccount();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedLabelVisible() && accountCreatedPage.getAccountCreatedLabelText() .equals("ACCOUNT CREATED!"), "'ACCOUNT CREATED!' label is missing or not visible.");
		homePage = accountCreatedPage.clickContinue();
		Assert.assertTrue(homePage.isLoggedInAsUsernameVisible() && homePage.getLoggedInAsUsernameText().equals("Logged in as johndoe05"), "'Logged in as username' label is missing or not visible.");
		cartPage = homePage.addToCart(productsToAddToCart).clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(), "Cart Page is not visible.");
		cartPage = cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.getCustomerName().equals("Mr. John Doe"),"Customer name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCompany().equals("The Lawrence Company"),"Customer company name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress1().equals("1379, Spring Hill Rd"),"Customer address1 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress2().equals("Farend avenue"),"Customer address2 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCityStateZip().equals("Shreveport AR 50576"),"Customer city, state and zipcode is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCountry().equals("United States"),"Customer country is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerMobile().equals("9999999999"),"Customer mobile is incorrect.");
		Assert.assertTrue(checkoutPage.getProductPrice("Blue Top").equals("500"),"Product Price is incorrect.");
		Assert.assertTrue(checkoutPage.getProductQuantity("Blue Top").equals("1"),"Product Quantity is incorrect.");
		Assert.assertTrue(checkoutPage.getProductTotalAmount("Blue Top").equals("500"),"Product Total Amount is incorrect.");
		Assert.assertTrue(checkoutPage.getProductPrice("Men Tshirt").equals("400"),"Product Price is incorrect.");
		Assert.assertTrue(checkoutPage.getProductQuantity("Men Tshirt").equals("1"),"Product Quantity is incorrect.");
		Assert.assertTrue(checkoutPage.getProductTotalAmount("Men Tshirt").equals("400"),"Product Total Amount is incorrect.");		
		paymentDonePage =  checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder().fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible() && paymentDonePage.getConfirmedMessageText().equals("Congratulations! Your order has been confirmed!"), "");
		homePage.clickDeleteAccountLink().clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
	@Test(priority = 2, description = "Test Case 16: Place Order: Login before Checkout")
	public void testToLoginBeforeCheckout() {
		
		RegisterUser();
		
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
		
		Payments payment = new Payments();
		payment.setNameOnCard("John Doe");
		payment.setCardNumber("6452789545625468");
		payment.setCvc("311");
		payment.setExpiryMonth("05");
		payment.setExpiryYear("2026");
		
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		homePage = homePage.clickSignupLoginLink().enterLoginEmail("johndoe04@email.com").enterLoginPassword("johndoe").clickLogin();
		Assert.assertTrue(homePage.isLoggedInAsUsernameVisible() && homePage.getLoggedInAsUsernameText().equals("Logged in as johndoe04"), "'Logged in as username' label is missing or not visible.");
		cartPage = homePage.clickProductsLink().addToCart(productsToAddToCart).clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(), "Cart Page is not visible.");
		cartPage = cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.getCustomerName().equals("Mr. John Doe"),"Customer name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCompany().equals("The Lawrence Company"),"Customer company name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress1().equals("1379, Spring Hill Rd"),"Customer address1 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress2().equals("Farend avenue"),"Customer address2 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCityStateZip().equals("Shreveport AR 50576"),"Customer city, state and zipcode is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCountry().equals("United States"),"Customer country is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerMobile().equals("9999999999"),"Customer mobile is incorrect.");
		Assert.assertTrue(checkoutPage.getProductPrice("Blue Top").equals("500"),"Product Price is incorrect.");
		Assert.assertTrue(checkoutPage.getProductQuantity("Blue Top").equals("1"),"Product Quantity is incorrect.");
		Assert.assertTrue(checkoutPage.getProductTotalAmount("Blue Top").equals("500"),"Product Total Amount is incorrect.");
		Assert.assertTrue(checkoutPage.getProductPrice("Men Tshirt").equals("400"),"Product Price is incorrect.");
		Assert.assertTrue(checkoutPage.getProductQuantity("Men Tshirt").equals("1"),"Product Quantity is incorrect.");
		Assert.assertTrue(checkoutPage.getProductTotalAmount("Men Tshirt").equals("400"),"Product Total Amount is incorrect.");		
		paymentDonePage =  checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder().fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible() && paymentDonePage.getConfirmedMessageText().equals("Congratulations! Your order has been confirmed!"), "");
		homePage.clickDeleteAccountLink().clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
		
	}
	
}
