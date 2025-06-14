package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.objects.Messages;

public class ContactUsPage extends BasePage {

	private static final Logger log = LogManager.getLogger(ContactUsPage.class);
	private final By lblGetInTouch = By.xpath("//div[@class='contact-form']/child::h2");
	private final By txtName = By.name("name");
	private final By txtEmail = By.name("email");
	private final By txtsubject = By.name("subject");
	private final By txtMessage = By.id("message");
	private final By txtUpload = By.name("upload_file");
	private final By btnSubmit = By.name("submit");
	private final By lblSuccessMessage = By.xpath("//div[@class='status alert alert-success']");
	private final By btnHome = By.xpath("//a[@class='btn btn-success']/span/i");

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	private ContactUsPage enterName(String name) {
		try {
			WebElement element = waitForElementToBeClickable(txtName);
			element.sendKeys(name);
			log.info("'" + name + "' entered in the name text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + name + "' text in the name text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private ContactUsPage enterEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(txtEmail);
			element.sendKeys(email);
			log.info("'" + email + "' entered in the email text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + email + "' text in the email text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private ContactUsPage enterSubject(String subject) {
		try {
			WebElement element = waitForElementToBeClickable(txtsubject);
			element.sendKeys(subject);
			log.info("'" + subject + "' entered in the subject text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + subject + "' text in the subject text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	private ContactUsPage enterMessage(String Message) {
		try {
			WebElement element = waitForElementToBeClickable(txtMessage);
			element.sendKeys(Message);
			log.info("'" + Message + "' entered in the Message text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + Message + "' text in the Message text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public ContactUsPage enterFilePath(String filePath) {
		try {
			WebElement element = waitForElementToBeClickable(txtUpload);
			element.sendKeys(filePath);
			log.info("'" + filePath + "' entered in the choose file text box.");
			return this;
		} catch (Exception e) {
			log.info("Unable to enter '" + filePath + "' text in the choose file text box. Error occured : "
					+ e.getMessage());
			return this;
		}
	}

	public ContactUsPage clickSubmit() {
		try {
			WebElement element = waitForElementToBeClickable(btnSubmit);
			element.click();
			log.info("Clicked on the Submit button.");
			return this;
		} catch (Exception e) {
			log.info("Unable to click on Submit button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isGetInTouchLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblGetInTouch);
			log.info("Contact us form header is displayed on the Contact us page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Contact us form header not displayed on the Contact us page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getGetInTouchText() {
		try {
			WebElement element = waitForElementToBeVisible(lblGetInTouch);
			log.info("Contact us form header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Contact us form header text on the Contact us page. Error occured : "
					+ e.getMessage());
			return "Unable to retrive Contact us form header text on the Contact us page.";
		}
	}

	public ContactUsPage fillContactForm(Messages message) {
		return enterName(message.getName()).enterEmail(message.getEmail()).enterSubject(message.getSubject())
				.enterMessage(message.getMessage());
	}

	public HomePage clickHome() {
		try {
			WebElement element = waitForElementToBeClickable(btnHome);
			element.click();
			log.info("Clicked on the Home button.");
			return new HomePage(driver);
		} catch (Exception e) {
			log.info("Unable to click on Home button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isSuccessMessageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(lblSuccessMessage);
			log.info("Success message is displayed on the Contact us page");
			return element.isDisplayed();
		} catch (Exception e) {
			log.info("Success message is not displayed on the Contact us page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSuccessMessageText() {
		try {
			WebElement element = waitForElementToBeVisible(lblSuccessMessage);
			log.info("Success message text on Contact us page retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			log.info("Unable to retrive Success message text on Contact us page . Error occured : " + e.getMessage());
			return "Unable to retrive Success message text on Contact us page .";
		}
	}

}
