package com.orangeHRM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.reports.Report;

public class Util {
	
	public static void sendKeys(WebDriver driver, By locator, String value, String desc) {
		WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = owait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
		System.out.println("User enters "+value+" into "+desc);
		Report.infoTest("User enters "+value+" into "+desc);
	}
	
	public static void click(WebDriver driver, By locator, String desc) {
		WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = owait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		System.out.println("User clicks on "+desc);
		Report.infoTest("User clicks on "+desc);
	}
	
	public static WebElement getElement(WebDriver driver, By locator) {
		WebDriverWait owait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = owait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public static String getProperty(String key) {
		Properties prop = new Properties();
		try {
			File file = new File(System.getProperty("user.dir")+"\\config.properties");
			FileInputStream fi = new FileInputStream(file);
			prop.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public static void hardWait(int sec) {
		try {
			Thread.sleep(sec*1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String captureScreenShot(WebDriver driver) {
		String dest = "";
		try {
			TakesScreenshot screen =  (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			dest = System.getProperty("user.dir") + "\\Reports\\screenshots.png";
			File target = new File(dest);
			FileUtils.copyFile(src, target);
			return dest;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
}
