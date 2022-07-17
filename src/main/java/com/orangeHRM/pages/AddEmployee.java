package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.utils.Util;

public class AddEmployee {	
	WebDriver driver;
	String expeHeader = "Add Employee";
	public AddEmployee(WebDriver driver) {
		this.driver = driver;
	}

	By lbl_header = By.xpath("//h1");
	By inp_fname = By.id("firstName");
	By inp_lname = By.id("lastName");
	By btn_save = By.id("btnSave");
	
	public void isOpened() {
		String actHeader = Util.getElement(driver, lbl_header).getText();
		if(actHeader.equalsIgnoreCase(expeHeader)) {
			System.out.println("User successfully navigates to Add Employee");
		} else {
			System.out.println("User not navigates to Add Employee");
		}
	}
	
	public void addAnEmployee(String fname, String lname) {
		Util.sendKeys(driver, inp_fname, fname, "First name");
		Util.sendKeys(driver, inp_lname, lname, "Last name");
		Util.click(driver, btn_save, "Save");
	}
}
