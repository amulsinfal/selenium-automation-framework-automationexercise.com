package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.objects.Payments;

public class PaymentPage extends BasePage{

	private static final Logger log = LogManager.getLogger(HomePage.class);
	private final By lblPageHeader = By.xpath("//div[@class='step-one']/h2[@class='heading']");
	private final By txtNameOnCard = By.name("name_on_card");
	private final By txtCardNumber = By.name("card_number");
	private final By txtCardCvc = By.name("cvc");
	private final By txtCardExpiryMonth = By.name("expiry_month");
	private final By txtCardExpiryYear = By.name("expiry_year");
	private final By btnPayAndConfirm = By.id("submit");
	private final By lblSuccessMessage = By.xpath("//div[@id='success_message']/div[@class='alert-success alert']");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	
    public boolean isPaymentPageVisible() {
        try {
            WebElement element = waitForElementToBeVisible(lblPageHeader);
            log.info("Payment page displayed is " + element.isDisplayed());
            return element.isDisplayed();
        } catch (Exception e) {
        	log.info("Payment page not displayed. Error occured : " + e.getMessage());
            return false;
        }
    }
    
	public PaymentPage enterNameOnCard(String name) {
		try {
			WebElement element = waitForElementToBeClickable(txtNameOnCard);
			element.sendKeys(name);
			log.info("'" + name + "' entered in the Name on card text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + name + "' text in the Name on card text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}
    
	public PaymentPage enterCardNumber(String cardNumber) {
		try {
			WebElement element = waitForElementToBeClickable(txtCardNumber);
			element.sendKeys(cardNumber);
			log.info("'" + cardNumber + "' entered in the Card number text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + cardNumber + "' text in the Card number text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}
    
	public PaymentPage enterCvc(String cvc) {
		try {
			WebElement element = waitForElementToBeClickable(txtCardCvc);
			element.sendKeys(cvc);
			log.info("'" + cvc + "' entered in the cvc text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + cvc + "' text in the cvc text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}
    
	public PaymentPage enterExpiryMonth(String expiryMonth) {
		try {
			WebElement element = waitForElementToBeClickable(txtCardExpiryMonth);
			element.sendKeys(expiryMonth);
			log.info("'" + expiryMonth + "' entered in the Expiry Month text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + expiryMonth + "' text in the Expiry Month text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}
	
	public PaymentPage enterExpiryYear(String expiryYear) {
		try {
			WebElement element = waitForElementToBeClickable(txtCardExpiryYear);
			element.sendKeys(expiryYear);
			log.info("'" + expiryYear + "' entered in the Expiry Year text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + expiryYear + "' text in the Expiry Year text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}
	
	public PaymentDonePage clickPayAndConfirmOrder() {
		try {
			WebElement element = waitForElementToBeClickable(btnPayAndConfirm);
			element.click();
			log.info("Clicked on the Pay And Confirm Order button.");
			log.info("Navigating to Home page.");
			return new PaymentDonePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Login button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public PaymentPage fillCardDetails(Payments payment) {
		return enterNameOnCard(payment.getNameOnCard()).enterCardNumber(payment.getCardNumber()).
				enterCvc(payment.getCvc()).enterExpiryMonth(payment.getExpiryMonth()).enterExpiryYear(payment.getExpiryYear());
	}
	
	public boolean isOrderSuccessMessageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblSuccessMessage);
			log.info("Order Placed success message header is displayed on the Payment done page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Order Placed success message header not displayed on the Payment done page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getOrderSuccessMessageText() {
		try {
			WebElement element = waitForElementToBeVisible(lblSuccessMessage);
			log.info("Order Placed success message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Order Placed success message text on the Payment done page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Order Placed success message text on the Payment done page.";
		}
	}
	
}
