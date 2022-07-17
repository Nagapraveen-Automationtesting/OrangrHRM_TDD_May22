package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By inp_username = By.id("txtUsername");
	By inp_password = By.id("txtPassword");
	By btn_login = By.id("btnLogin");
	
	String expTitle = "OrangeHRM";
	
	public void isOpened() {
		String actTitle = driver.getTitle();
		if(actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Page successfully launched");
			Report.passTest(driver, "Page successfully launched");
		} else {
			System.out.println("Page not successfully launched");
			Report.failTest(driver, "Page not successfully launched");
		}
	}
	
	public void logInToApplication(String username, String password) {
		Util.sendKeys(driver, inp_username, username, "User name");
		Util.sendKeys(driver, inp_password, password, "Password");
		Util.hardWait(3);
		Util.click(driver, btn_login, "Login");
		/*driver.findElement(inp_username).sendKeys("Admin");
		driver.findElement(inp_password).sendKeys("admin123");
		driver.findElement(btn_login).click();*/
	}

}
