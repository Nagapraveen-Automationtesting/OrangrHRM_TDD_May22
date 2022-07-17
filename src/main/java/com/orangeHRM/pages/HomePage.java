package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

public class HomePage {
	WebDriver driver;
	String expeHeader = "Dashboard";
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By lbl_header = By.xpath("//h1");
	By lbl_PIM = By.id("menu_pim_viewPimModule");
	By lnk_addEmp = By.linkText("Add Employee");
	By menu_user = By.id("welcome");
	By lnk_Logout = By.linkText("Logout");
	
	public void isOpened() {
		String actHeader = Util.getElement(driver, lbl_header).getText();
		if(actHeader.equalsIgnoreCase(expeHeader)) {
			System.out.println("User successfull logged in");
			Report.passTest(driver, "User successfull logged in");
		} else {
			System.out.println("User not successfull logged in");
			Report.failTest(driver, "User not successfull logged in");
		}
	}
	
	public void goToAddEmeployee() {
		Util.click(driver, lbl_PIM, "PIM");
		Util.click(driver, lnk_addEmp, "Add Employee");
	}
	
	public void logOutOfApplication() {
		Util.click(driver, menu_user, "User menu");
		Util.click(driver, lnk_Logout, "Logout");
	}

}
