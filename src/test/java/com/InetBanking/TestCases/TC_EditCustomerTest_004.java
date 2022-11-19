package com.InetBanking.TestCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.AddCustomerPage;
import com.InetBanking.PageObjects.EditCustomerPage;
import com.InetBanking.PageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@Test
	public void editCustomer() {
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		log.info("Edit Customer==>Username Entered");
		lp.setpassword(password);
		log.info("Edit Customer==>Password Entered");
		lp.setlogin();
		log.info("Edit Customer==>Clicked on Login Button");
		
		EditCustomerPage edit=new EditCustomerPage(driver);
		edit.clickEditCustomer();
		log.info("Clicked on EditCustomer");
		edit.customerID(exportval);
		log.info("Customer ID entered");
		edit.clickSubmit();
		log.info("Clicked on Submit Button");
		edit.custpinno("432567");
		log.info("Customer Page Edited");
		edit.finalSubmit();
		log.info("Clicked on Final Submit button");
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			lp.setlogout();
		} else {
			lp.setlogout();
		}

	}
	public boolean isAlertPresent() { //User Defines method to check Alert is Present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
