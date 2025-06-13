package com.ae.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.ae.base.BasePage;
import com.ae.base.PageDriver;

public class SeleniumUtils extends BasePage{
	
	private static final Logger log = LogManager.getLogger(SeleniumUtils.class);

	public SeleniumUtils(WebDriver driver) {
		super(driver);
	}

	private static Alert getAlert() {
		try {
			log.info("Switching to Alert popup.");
			return PageDriver.getDriver().switchTo().alert();
		} catch (Exception e) {
			log.info("Error occured while Switching to Alert popup. Error occured : " + e.getMessage());
			return null;
		}
	}

	public static void acceptAlert() {
		try {
			getAlert().accept();
			log.info("Clicked on 'Ok' on Alert popup.");
		} catch (Exception e) {
			log.info("Error occured while Clicking on 'Ok' on Alert popup. Error occured : " + e.getMessage());
		}
	}

	public static void dismissAlert() {
		try {
			getAlert().dismiss();
			log.info("Clicked on 'Cancel' on Alert popup.");
		} catch (Exception e) {
			log.info("Error occured while Clicking on 'Cancel' on Alert popup. Error occured : " + e.getMessage());
		}
	}

}
