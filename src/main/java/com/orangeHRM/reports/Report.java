package com.orangeHRM.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.orangeHRM.config.BaseClass;
import com.orangeHRM.utils.Util;

public class Report {
	
	public static void passTest(String desc) {
		BaseClass.report.pass(desc);
//		BaseClass.log.info(desc);
	}
	
	public static void passTest(WebDriver driver, String desc)  {
		BaseClass.report.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(Util.captureScreenShot(driver)).build());
//			BaseClass.log.info(desc);
	}
	
	public static void failTest(String desc) {
		BaseClass.report.fail(desc);
//		BaseClass.log.error(desc);
	}
	
	public static void failTest(WebDriver driver,String desc)  {
		BaseClass.report.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(Util.captureScreenShot(driver)).build());
//			BaseClass.log.error(desc);
		
	}
	
	
	public static void infoTest(String desc) {
		BaseClass.report.info(desc);
//		BaseClass.log.error(desc);
	}


}
