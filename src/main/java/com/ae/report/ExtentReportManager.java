package com.ae.report;

import com.ae.utilities.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

	public static ExtentReports extenReport;
	public static String extentReportFile;

	public static ExtentReports setupExtentReport() {
		
//		String fileName = "ExecutionReport_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".html";
		String fileName = "ExecutionReport.html";
		String filePath = System.getProperty("user.dir")+"\\reports\\";
				
		extentReportFile = filePath + fileName;

		extenReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setReportName("Automation exercise functional test report");
		sparkReporter.config().setDocumentTitle("Automation exercise automation execution report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
		
		extenReport.attachReporter(sparkReporter);
		extenReport.setSystemInfo("Application URL", ConfigReader.readProperty("url"));
		extenReport.setSystemInfo("Browser",  ConfigReader.readProperty("browser"));
		extenReport.setSystemInfo("Tester", "Amul Sinfal");
		extenReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extenReport.setSystemInfo("Java version", System.getProperty("java.version"));

		return extenReport;
	}
}
