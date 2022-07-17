package com.orangeHRM.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.orangeHRM.reports.ExtentReport;
import com.orangeHRM.utils.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static ExtentTest report;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		launchBrowser(Util.getProperty("browser"), Util.getProperty("url"));
		report = ExtentReport.startReport(System.getProperty("user.dir")+"//Reports//ExtentReport.html", method.getName(), "Desc");
	}

	@AfterMethod
	public void afterMethod() {
		ExtentReport.getReporter(System.getProperty("user.dir")+"//Reports//ExtentReport.html").flush();
		if(driver !=null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void afterSuite() {

	}

	
	public void launchBrowser(String browser, String url) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\OrangrHRM_TDD_May22\\Drivers\\chromedriver.exe");*/
		/*	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();*/
			
			driver = WebDriverManager.chromedriver().create();
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if(browser.equalsIgnoreCase("edge")) {
			
		} else if(browser.equalsIgnoreCase("ie")) {
			
		} else if(browser.equalsIgnoreCase("safari")) {
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
	}
}
