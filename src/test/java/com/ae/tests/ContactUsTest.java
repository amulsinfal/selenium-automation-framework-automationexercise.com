package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.Messages;
import com.ae.pages.ContactUsPage;
import com.ae.pages.HomePage;
import com.ae.utilities.SeleniumUtils;

public class ContactUsTest extends BaseTest{
	HomePage homePage;
	ContactUsPage contactUsPage;

	/*
	 * 1. Launch browser
	 * 2. Navigate to url 'http://automationexercise.com'
	 * 3. Click on 'Contact Us' button
	 * 4. Enter name, email, subject and message
	 * 5. Upload file
	 * 6. Click 'Submit' button
	 * 7. Click OK button
	 * 8. Verify success message 'Success! Your details have been submitted successfully.' is visible
	 */
	
	@Test (priority = 0, description = "Test Case 6: Verify success message after sending the message.")
	public void verifySuccessMessageAfterSendingMessage() {
		Messages message = new Messages();
		message.setName("john Doe");
		message.setEmail("jackdoe@email.com");
		message.setSubject("This is the sample Subject.");
		message.setMessage("This is the sample message body");
		message.setFilePath(System.getProperty("user.dir") + "/src/test/resources/testData/Sample.txt");
		
		homePage = new HomePage(driver);
		contactUsPage = homePage.clickContactUsLink().fillContactForm(message).clickSubmit();
		SeleniumUtils.acceptAlert();
		Assert.assertTrue(contactUsPage.isSuccessMessageVisible() && contactUsPage.getSuccessMessageText().equals("Success! Your details have been submitted successfully."),"'Success! Your details have been submitted successfully.' text is missing or not visible.");
	}

}
