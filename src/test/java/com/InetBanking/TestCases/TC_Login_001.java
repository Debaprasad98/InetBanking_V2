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
		test.pass("Username entered");
		log.info("Password entered");
		lp.setpassword(password);
		test.pass("Password entered");
		log.info("Clicked on login button");
		lp.setlogin();
		test.pass("Clicked on Login button");
		String title=driver.getTitle();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true, "Home Page Verified");
			log.info("Home Page Verified");
			test.pass("Home Page Veriied");
			log.info("Clicked on logout button");
			lp.setlogout();
			test.pass("Clicked on Logout Button");
		} else {
			Assert.assertFalse(false, "Home Page is not Verified");
			log.info("Home Page is not Verified");
			test.fail("Home Page is not Verified");
		}
	}
}
