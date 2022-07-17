package com.orangeHRM.testcases;

import org.testng.annotations.Test;

import com.orangeHRM.config.BaseClass;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

public class TC01_LoginFunctionality extends BaseClass {
	
	
	@Test
	public void validateLoginFunctinality() {
		try {
			LoginPage login = new LoginPage(driver);
			login.isOpened();
			login.logInToApplication(Util.getProperty("username"), Util.getProperty("password"));
			HomePage home = new HomePage(driver);
			home.isOpened();
			home.logOutOfApplication();
		}catch (Exception e) {
			Report.failTest(driver, e.getMessage());
		}
	}

}
