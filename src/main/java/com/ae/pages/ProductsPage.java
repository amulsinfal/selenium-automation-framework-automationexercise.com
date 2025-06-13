package com.ae.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ae.base.BasePage;

public class ProductsPage extends BasePage {

	private static final Logger log = LogManager.getLogger(ProductsPage.class);
	private final By lblListHeader = By.xpath("//div[@class='features_items']/h2");
	private final By txtSearch = By.id("search_product");
	private final By btnSearch = By.id("submit_search");
	private final By btnContinueShopping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private final By lnkViewCart = By.xpath("//a[@href='/view_cart']/u");
	private final By lnkCart = By.xpath("//a[@href='/view_cart']");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isListHeaderVisible() {
		try {
			WebElement element = waitForElementToBeClickable(lblListHeader);
			log.info("List header is displayed on the Products page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("List header not displayed on the Products page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getListHeaderText() {
		try {
			WebElement element = waitForElementToBeClickable(lblListHeader);
			log.info("List header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive List header text on the Products page. Error occured : " + e.getMessage());
			return "Unable to retrive List header text on the Products page.";
		}
	}

	public ProductsPage enterSearchText(String searchItem) {
		try {
			WebElement element = waitForElementToBeClickable(txtSearch);
			element.sendKeys(searchItem);
			log.info("'" + searchItem + "' entered in the search text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + searchItem + "' text in the search text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public ProductsPage clickSearch() {
		try {
			WebElement element = waitForElementToBeClickable(btnSearch);
			element.click();
			log.info("Clicked on the Search button.");
			return this;
		} catch (Exception e) {
			log.info("Unable to click on search button. Error occured : " + e.getMessage());
			return null;
		}
	}

	// Add multiple products to cart.
	public ProductsPage addToCart(String[] productNames) {
		List<String> foundProducts = new ArrayList<String>();
		List<String> productNamesList = Arrays.asList(productNames);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		int counter = 0;
		for (int i = 0; i <= elements.size() - 1; i++) {
			if (productNamesList.contains(elements.get(i).getText())) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + elements.get(i).getText() + "']/parent::div")));
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']"))).perform();
				log.info("Hovering over Product : '" + elements.get(i).getText() + "'.");
				driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + elements.get(i).getText() + "']/parent::div/following-sibling::div/div/p[text()='"+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']")).click();
				log.info("Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				driver.findElement(btnContinueShopping).click();
				log.info("Clicked on continue shopping link.");
				foundProducts.add(elements.get(i).getText());
				log.info("Products added to cart : '" + foundProducts + "'.");
				counter++;
				if (counter == productNames.length) {
					break;
				}
			}
		}
		return this;
	}

	// Add single product to cart.
	public ProductsPage addProductToCart(String productName) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"+ productName + "']/parent::div/a[@class='btn btn-default add-to-cart']"))).perform();
		log.info("Hovering over Product : '" + productName + "'.");
		driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div/following-sibling::div/div/p[text()='" + productName + "']/parent::div/a[@class='btn btn-default add-to-cart']")).click();
		log.info("Clicked on Add to cart on product : '" + productName + "'.");
		return this;
	}

	public ProductsPage hoverAndAddToCart(int index) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//div[@class='productinfo text-center']/p/parent::div)[" + index + "]")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='productinfo text-center']/p/parent::div/a[@class='btn btn-default add-to-cart'])[" + index + "]"))) .perform();
		String productName = driver.findElement(By.xpath("(//div[@class='productinfo text-center']/p/parent::div/a[@class='btn btn-default add-to-cart'])[" + index + "]")).getText();
		log.info("Hovering over Product : '" + productName + "'.");
		driver.findElement(By.xpath("(//div[@class='productinfo text-center']/p/parent::div/following-sibling::div/div/p/parent::div/a[@class='btn btn-default add-to-cart'])[" + index + "]")).click();
		log.info("Clicked on Add to cart on product : '" + productName + "'.");
		return this;
	}

	public boolean isProductPresent(String[] productNames) {
		boolean flag = false;
		List<String> foundProducts = new ArrayList<String>();
		List<String> missingProducts = new ArrayList<String>();
		for (String productName : productNames) {
			if (!driver.findElements(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div")).isEmpty()) {
				foundProducts.add(productName);
			} else {
				missingProducts.add(productName);
			}
		}
		if(missingProducts.size() > 0) {
			flag = false;
			log.info("Products missing in the list : " + missingProducts);
		} else {
			flag = true;
			log.info("Products found in the list : " + foundProducts);		}
		return flag;
	}

	// Check if a product is present in the searched list
	public boolean isProductPresent(String productName) {
		boolean flag = false;
		if (!driver.findElements(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div")).isEmpty()) {
			log.info("Product found in the list: '" + productName + "'.");
			flag = true;
		} else {
			flag = false;
			log.info("Product missing in the list: '" + productName + "'.");
		}
		return flag;
	}

	public ProductsPage clickContinueShopping() {
		try {
			WebElement element = waitForElementToBeClickable(btnContinueShopping);
			element.click();
			log.info("Clicked on the Continue Shopping button.");
			return this;
		} catch (Exception e) {
			log.info("Unable to click on Continue Shopping button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public CartPage clickViewCartLink() {
		try {
			WebElement element = waitForElementToBeClickable(lnkViewCart);
			element.click();
			log.info("Clicked on the View cart link.");
			return new CartPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on view cart link. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public CartPage clickCartLink() {
		try {
			WebElement element = waitForElementToBeClickable(lnkCart);
			element.click();
			log.info("Clicked on the Cart link.");
			return new CartPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Cart link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public ProductDetailsPage clickViewProduct(String productName) {
		try {
			By xpathString = By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a");
			WebElement element = waitForElementToBeClickable(xpathString);
			element.click();
			log.info("Clicked on the view product link of product : '" + productName + "'.");
			return new ProductDetailsPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on view product  link of product : " + productName + ". Error occured : " + e.getMessage());
			return null;
		}
	}

}
