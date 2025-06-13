package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.Customers;
import com.ae.objects.Payments;
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
	
	// 1. Launch browser
	// 2. Navigate to url 'http://automationexercise.com'
	// 4. Add products to cart
	// 5. Click 'Cart' button
	// 7. Click Proceed To Checkout
	// 8. Click 'Register / Login' button
	// 9. Fill all details in Signup and create account
	// 12. Click 'Cart' button
	// 13. Click 'Proceed To Checkout' button
	// 15. Enter description in comment text area and click 'Place Order'
	// 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
	// 17. Click 'Pay and Confirm Order' button
	// 18. Verify success message 'Your order has been placed successfully!'
	// 19. Click 'Delete Account' button
	// 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

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
		
		homePage = new HomePage(driver);
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		cartPage = homePage.addToCart(productsToAddToCart).clickCartLink().clickProceedToCheckout();
		cartPage.clickRegisterLoginLink();
		signupLoginPage = new SignupLoginPage(driver);
		signupLoginPage.enterSignupName("johndoe10").enterSignupEmail("johndoe10@email.com").clickSignup().fillCustomerInformation(customer).clickCreateAccount().clickContinue()
		.clickCartLink().clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.getCustomerName().equals("Mr. John Doe"),"Customer name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCompany().equals("The Lawrence Company"),"Customer company name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress1().equals("1379, Spring Hill Rd"),"Customer address1 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress2().equals("Farend avenue"),"Customer address2 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCityStateZip().equals("Shreveport AR 50576"),"Customer city, state and zipcode is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCountry().equals("United States"),"Customer country is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerMobile().equals("9999999999"),"Customer mobile is incorrect.");
		paymentDonePage =  checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder().fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible() && paymentDonePage.getConfirmedMessageText().equals("Congratulations! Your order has been confirmed!"), "");
		homePage.clickDeleteAccountLink().clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
//	Test Case 15: Place Order: Register before Checkout
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfully
//	4. Click 'Signup / Login' button
//	5. Fill all details in Signup and create account
//	6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//	7. Verify ' Logged in as username' at top
//	8. Add products to cart
//	9. Click 'Cart' button
//	10. Verify that cart page is displayed
//	11. Click Proceed To Checkout
//	12. Verify Address Details and Review Your Order
//	13. Enter description in comment text area and click 'Place Order'
//	14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//	15. Click 'Pay and Confirm Order' button
//	16. Verify success message 'Your order has been placed successfully!'
//	17. Click 'Delete Account' button
//	18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
	
	@Test(priority = 0, description = "Test Case 14: Place Order: Register before Checkout.")
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
		
		homePage = new HomePage(driver);
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		homePage.clickSignupLoginLink().enterSignupName("johndoe10").enterSignupEmail("johndoe10@email.com").clickSignup().fillCustomerInformation(customer).clickCreateAccount().clickContinue()
		.clickProductsLink().addToCart(productsToAddToCart).clickCartLink().clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.getCustomerName().equals("Mr. John Doe"),"Customer name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCompany().equals("The Lawrence Company"),"Customer company name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress1().equals("1379, Spring Hill Rd"),"Customer address1 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress2().equals("Farend avenue"),"Customer address2 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCityStateZip().equals("Shreveport AR 50576"),"Customer city, state and zipcode is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCountry().equals("United States"),"Customer country is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerMobile().equals("9999999999"),"Customer mobile is incorrect.");
		paymentDonePage =  checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder().fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible() && paymentDonePage.getConfirmedMessageText().equals("Congratulations! Your order has been confirmed!"), "");
		homePage.clickDeleteAccountLink().clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
	
	//	Test Case 16: Place Order: Login before Checkout
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Click 'Signup / Login' button
	//	5. Fill email, password and click 'Login' button
	//	6. Verify 'Logged in as username' at top
	//	7. Add products to cart
	//	8. Click 'Cart' button
	//	9. Verify that cart page is displayed
	//	10. Click Proceed To Checkout
	//	11. Verify Address Details and Review Your Order
	//	12. Enter description in comment text area and click 'Place Order'
	//	13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
	//	14. Click 'Pay and Confirm Order' button
	//	15. Verify success message 'Your order has been placed successfully!'
	//	16. Click 'Delete Account' button
	//	17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
	
	@Test(priority = 0, description = "Test Case 14: Place Order: Login before Checkout.")
	public void testToLoginBeforeCheckout() {
		
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
		
		homePage = new HomePage(driver);
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		cartPage = homePage.clickSignupLoginLink().enterLoginEmail("johndoe10@email.com").enterLoginPassword("johndoe").clickLogin().clickProductsLink().addToCart(productsToAddToCart).clickCartLink().clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.getCustomerName().equals("Mr. John Doe"),"Customer name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCompany().equals("The Lawrence Company"),"Customer company name is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress1().equals("1379, Spring Hill Rd"),"Customer address1 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerAddress2().equals("Farend avenue"),"Customer address2 is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCityStateZip().equals("Shreveport AR 50576"),"Customer city, state and zipcode is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerCountry().equals("United States"),"Customer country is incorrect.");
		Assert.assertTrue(checkoutPage.getCustomerMobile().equals("9999999999"),"Customer mobile is incorrect.");
		paymentDonePage =  checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder().fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible() && paymentDonePage.getConfirmedMessageText().equals("Congratulations! Your order has been confirmed!"), "");
		homePage.clickDeleteAccountLink().clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
}
