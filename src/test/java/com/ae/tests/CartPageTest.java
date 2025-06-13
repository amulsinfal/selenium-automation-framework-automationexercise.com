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

	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Click 'Products' button
	//	5. Hover over a product and click 'Add to cart'
	//	6. Click 'Continue Shopping' button
	//	7. Click 'Cart' link
	//	8. Verify both products are added to Cart
	
	@Test (priority = 0, description = "Test to Verify the product is added to the Cart.")
	public void testToVerifyProductIsAddedToCart() {
		homePage = new HomePage(driver);
		String[] productsToSearch = {"Blue Top", "Men Tshirt"};
		cartPage = homePage.clickProductsLink().addToCart(productsToSearch).clickCartLink();
		Assert.assertTrue(cartPage.isProductPresent(productsToSearch));		
	}

	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Click 'Products' button
	//	5. Hover over a product and click 'Add to cart'
	//	6. Click 'Continue Shopping' button
	//	7. Hover over another product and click 'Add to cart'
	//	8. Click 'Continue Shopping' button
	//	9. Click 'Cart' link
	//	10. Verify both products are added to Cart

	@Test (priority = 1, description = "Test to Verify the product is added to the Cart.")
	public void testToVerifyProductsAreAddedToCart() {
		homePage = new HomePage(driver);
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		cartPage = homePage.clickProductsLink().addToCart(productsToAddToCart).clickCartLink();
		Assert.assertTrue(cartPage.isProductPresent(productsToAddToCart));		
	}
	
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Click 'Products' button
	//	4. Hover over first product and click 'Add to cart'
	//	5. Click 'Continue Shopping' button
	//	6. Hover over second product and click 'Add to cart'
	//	7. Click 'View Cart' button
	//	8. Verify both products are added to Cart
	
	@Test (priority = 2, description = "Test to verify prices, quantity and total price of the products in the cart.")
	public void testToVerifyFirstAndSecondProductAreAddedToCart() {
		homePage = new HomePage(driver);
		cartPage = homePage.clickProductsLink().hoverAndAddToCart(1).clickContinueShopping().hoverAndAddToCart(2).clickViewCartLink();
		String[] productsToSearch = {"Blue Top", "Men Tshirt"};
		Assert.assertTrue(cartPage.isProductPresent(productsToSearch));		
	}
	
	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Click 'Products' button
	//	5. Hover over first product and click 'Add to cart'
	//	6. Click 'Continue Shopping' button
	//	7. Hover over second product and click 'Add to cart'
	//	8. Click 'View Cart' button
	//	9. Verify both products are added to Cart
	//	10. Verify their prices, quantity and total price
	
	@Test (priority = 3, description = "Test to verify prices, quantity and total price of the products in the cart.")
	public void VerifyTheirPricesQuantityAndTotalPrice() {
		homePage = new HomePage(driver);
		cartPage = homePage.clickProductsLink().addProductToCart("Blue Top").clickContinueShopping().addProductToCart("Men Tshirt").clickViewCartLink();
		Assert.assertTrue(cartPage.getProductPrice("Blue Top").equals("500"));
		Assert.assertTrue(cartPage.getProductQuantity("Blue Top").equals("1"));
		Assert.assertTrue(cartPage.getProductTotalAmount("Blue Top").equals("500"));
		
		Assert.assertTrue(cartPage.getProductPrice("Men Tshirt").equals("400"));
		Assert.assertTrue(cartPage.getProductQuantity("Men Tshirt").equals("1"));
		Assert.assertTrue(cartPage.getProductTotalAmount("Men Tshirt").equals("400"));
	}
	
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
		cartPage = homePage.clickViewProduct("Blue Top").selectQuantity("4").clickAddToCart().clickViewCartLink();
		Assert.assertTrue(cartPage.getProductQuantity("Blue Top").equals("4"));
	}
		
	/*
	 * Test Case 17: Remove Products From Cart
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		3. Add products to cart
		4. Click 'Cart' button
		5. Click 'X' button corresponding to particular product
		6. Verify that product is removed from the cart
	 */
	
	@Test (priority = 5, description = "Test Case 17: Remove Products From Cart.")
	public void testRemoveProductFromCart() {
		homePage = new HomePage(driver);
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		cartPage = homePage.clickProductsLink().addToCart(productsToAddToCart).clickCartLink().removeProducts(productsToAddToCart);
		Assert.assertTrue(cartPage.isCartEmptyLabelVisible() && cartPage.getCartEmptyText().equals("Cart is empty!"),"'Cart is Empty' label is missing or not visible.");
	}
	
}
