package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.HomePage;

public class SearchTest extends BaseTest{
	HomePage homePage;
	
	/* 
	 * 1. Launch browser
	 * 2. Navigate to url 'http://automationexercise.com'
	 * 3. Click on 'Products' button
	 * 4. Enter product name in search input and click search button
	 * 6. Verify all the products related to search are visible
	 */
	
	@Test(priority = 0, description = "Test Case 9: Search Product")
	public void testToVerifyProductsRelatedToSearchAreVisible() {
		homePage = new HomePage(driver);
		String searchString = "Men";
		String[] expectedResultList = {"Men Tshirt", "Madame Top For Women", "Lace Top For Womens", "GRAPHIC DESIGN MEN T SHIRT - BLUE"};
		Assert.assertTrue(homePage.clickProductsLink().enterSearchText(searchString).clickSearch().isProductPresent(expectedResultList), "Product not found in the search list.");
	}
	
	@Test(priority = 0, description = "Test Case: Search Invalid Product")
	public void testToSearchInvalidProduct() {
		homePage = new HomePage(driver);
		String searchString = "Black Top";
		Assert.assertFalse(homePage.clickProductsLink().enterSearchText(searchString).clickSearch().isProductPresent(searchString), "Product not found in the search list.");
	}
	
	@Test(priority = 0, description = "Test Case: Search Valid Product")
	public void testToSearchValidProduct() {
		homePage = new HomePage(driver);
		String searchString = "Blue Top";
		Assert.assertTrue(homePage.clickProductsLink().enterSearchText(searchString).clickSearch().isProductPresent(searchString), "Product not found in the search list.");
	}
}
