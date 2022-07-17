package com.orangeHRM.testcases;

import org.testng.annotations.Test;

import com.orangeHRM.config.BaseClass;
import com.orangeHRM.pages.AddEmployee;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.Util;
import com.orangeHRM.utils.XLutils;

public class TC02_AddEmployee extends BaseClass{
	
	
	@Test
	public void addEmployee() {
		LoginPage login = new LoginPage(driver);
		login.isOpened();
		login.logInToApplication(Util.getProperty("username"), Util.getProperty("password"));
		HomePage home = new HomePage(driver);
		home.isOpened();
		home.goToAddEmeployee();
		AddEmployee addemp = new AddEmployee(driver);
		addemp.addAnEmployee(XLutils.readValueFromExcel(System.getProperty("user.dir")+"\\TestData\\Sample.xlsx", "Sheet1", 1, 0), XLutils.readValueFromExcel(System.getProperty("user.dir")+"\\TestData\\Sample.xlsx", "Sheet1", 1, 1));
		home.logOutOfApplication();
	}

}
