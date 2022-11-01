package com.InetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.LoginPage;

public class TC_Login_001 extends BaseClass {

	@Test
	public void VerifyHomePage() {
		LoginPage lp=new LoginPage(driver);
		log.info("Username entered");
		lp.setusername(username);
		log.info("Password entered");
		lp.setpassword(password);
		log.info("Clicked on login button");
		lp.setlogin();
		String title=driver.getTitle();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true, "Home Page Verified");
			log.info("Home Page Verified");
			log.info("Clicked on logout button");
			lp.setlogout();
		} else {
			Assert.assertFalse(false, "Home Page is not Verified");
			log.info("Home Page is not Verified");
		}
	}
}
