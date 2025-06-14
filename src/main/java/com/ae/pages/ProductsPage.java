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
	private final By txtSearch = By.id("search_product");
	private final By btnSearch = By.id("submit_search");
	private final By btnContinueShopping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private final By lnkCart = By.xpath("//a[@href='/view_cart']");
	private final By imgSaleImage = By.id("sale_image");
	private final By lstProductItems = By.xpath("//div[@class='productinfo text-center']/p");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isProductsPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(imgSaleImage);
			log.info("Products page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Products page not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public boolean isProductListVisible() {
		try {
			List<WebElement> elements = driver.findElements(lstProductItems);
			if (!elements.isEmpty()) {
				log.info("Products list are visible.");

				return true;
			} else {
				log.info("Products list is visible but empty.");
				return false;
			}
		} catch (Exception e) {
			log.info("Products list not displayed. Error occured : " + e.getMessage());
			return false;
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
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
								+ elements.get(i).getText() + "']/parent::div")));
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']")))
						.perform();
				log.info("Hovering over Product : '" + elements.get(i).getText() + "'.");
				driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/following-sibling::div/div/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']"))
						.click();
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

	public boolean isProductPresent(String[] productNames) {
		boolean flag = false;
		List<String> foundProducts = new ArrayList<String>();
		List<String> missingProducts = new ArrayList<String>();
		for (String productName : productNames) {
			if (!driver
					.findElements(By.xpath(
							"//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div"))
					.isEmpty()) {
				foundProducts.add(productName);
			} else {
				missingProducts.add(productName);
			}
		}
		if (missingProducts.size() > 0) {
			flag = false;
			log.info("Products missing in the list : " + missingProducts);
		} else {
			flag = true;
			log.info("Products found in the list : " + foundProducts);
		}
		return flag;
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

	public ProductDetailsPage clickViewProduct(int index) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver
					.findElement(By.xpath("(//div[@class='productinfo text-center']/p/parent::div)[" + index + "]")));
			log.info("Scrolling to product with index " + index);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(
					"(//div[@class='productinfo text-center']/p/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a)["
							+ index + "]")))
					.perform();
			log.info("Hovering over the product with index " + index);
			driver.findElement(By.xpath(
					"(//div[@class='productinfo text-center']/p/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a)["
							+ index + "]"))
					.click();
			log.info("Clicking on the view product link of product with index " + index);
			return new ProductDetailsPage(driver);
		} catch (Exception e) {
			log.info("Unable to click on the view product link of product with index " + index + ". Error occured : "
					+ e.getMessage());
			return null;
		}
	}

}
