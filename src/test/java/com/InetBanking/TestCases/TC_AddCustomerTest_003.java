package com.InetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.AddCustomerPage;
import com.InetBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() {
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.setlogin();
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("King");
		addcust.custGender();
		addcust.custdob("02", "23", "2022");
		addcust.custAdress("Germany");
		addcust.customerCity("Walldorf");
		addcust.custstate("Wallstreet");
		addcust.custpinno("754211");
		addcust.custtelephoneno("8734675523");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword(password);
		addcust.custsubmit();
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
	}
	
	
}
