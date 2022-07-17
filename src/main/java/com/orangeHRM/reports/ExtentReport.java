package com.orangeHRM.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	static ExtentReports extent;

	public static ExtentReports getReporter(String reportName) {
		if (extent == null) {
			ExtentSparkReporter html = new ExtentSparkReporter(reportName);
			html.config().setDocumentTitle("Orange HRM extent report");
			html.config().setReportName("QA xperts");
			html.config().setTheme(Theme.STANDARD);
			extent = new ExtentReports();
			extent.attachReporter(html);
		}
		return extent;
	}
	
	public static ExtentTest startReport(String reportName, String testName, String desc) {
		return getReporter(reportName).createTest(testName, desc);
	}
	

}
