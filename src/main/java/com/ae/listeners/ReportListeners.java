package com.ae.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ae.base.PageDriver;

public class ReportListeners implements ITestListener {

	private static final Logger log = LogManager.getLogger(ReportListeners.class);

	@Override
	public void onTestStart(ITestResult result) {
		log.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has started **********");
		log.info("Test description -'" + result.getMethod().getDescription() + "'.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has passed **********");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has failed **********");
		File source = ((TakesScreenshot) PageDriver.getDriver()).getScreenshotAs(OutputType.FILE);
		String fileName = "Screenshot_" + result.getMethod().getMethodName() + "_"
				+ new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".png";
		String destinationPath = System.getProperty("user.dir") + "//screenshots//" + fileName;
		try {
			FileHandler.copy(source, new File(destinationPath));
		} catch (IOException e) {
			throw new RuntimeException("Error occured while copying screenshot to " + destinationPath);
		}
		log.info("Screenshot captured : " + fileName);
		log.info("Exception occured : " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("********** Execution of '" + result.getMethod().getMethodName() + "' test has skipped **********");
		log.info("Exception occured : " + result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
