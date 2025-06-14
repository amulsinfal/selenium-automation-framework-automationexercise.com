package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.CartPage;
import com.ae.pages.HomePage;
import com.ae.pages.ProductDetailsPage;
import com.ae.pages.ProductsPage;

public class CartPageTest extends BaseTest {
	HomePage homePage; 
	ProductsPage productsPage;
	CartPage cartPage;
	ProductDetailsPage productDetailsPage;
	
	//	Test Case 13: Verify Product quantity in Cart
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Click 'View Product' for any product on home page
	//	5. Verify product detail is opened
	//	6. Increase quantity to 4
	//	7. Click 'Add to cart' button
	//	8. Click 'View Cart' button
	//	9. Verify that product is displayed in cart page with exact quantity
	
	@Test (priority = 4, description = "Test to verify quantity of the product in the cart.")
	public void testToVerifyProductQuantityInCart() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		productDetailsPage = homePage.clickViewProduct("Blue Top");
		Assert.assertTrue(productDetailsPage.isProductDetailsPageVisible(),"Products details page is not Visible.");
		cartPage = productDetailsPage.selectQuantity("4").clickAddToCart().clickViewCartLink();
		Assert.assertTrue(cartPage.getProductQuantity("Blue Top").equals("4"),"Product quantity in the cart Page is not matching");
	}
	
	//	Test Case 17: Remove Products From Cart
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Add products to cart
	//	5. Click 'Cart' button
	//	6. Verify that cart page is displayed
	//	7. Click 'X' button corresponding to particular product
	//	8. Verify that product is removed from the cart
	
	@Test (priority = 5, description = "Test Case 17: Remove Products From Cart.")
	public void testToRemoveProductsFromCart() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		String[] products = {"Blue Top", "Men Tshirt"};
		productsPage = homePage.clickProductsLink().addToCart(products);
		cartPage = productsPage.clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(),"");
		cartPage = cartPage.clickXButton(products);
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty.");
	}

}
