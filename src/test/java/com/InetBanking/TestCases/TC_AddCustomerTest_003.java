package com.InetBanking.TestCases;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.AddCustomerPage;
import com.InetBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() {
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		log.info("Add Customer==>Username Entered");
		lp.setpassword(password);
		log.info("Add Customer==>Password Entered");
		lp.setlogin();
		log.info("Add Customer==>Clicked on Login Button");
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		log.info("Clicked on Add New Customer Button");
		addcust.custName("King");
		log.info("Customer Name Entered");
		addcust.custGender();
		log.info("Gender Entered");
		addcust.custdob("02", "23", "2022");
		log.info("D.O.B  Entered");
		addcust.custAdress("Germany");
		log.info("Adress Entered");
		addcust.customerCity("Walldorf");
		log.info("City Entered");
		addcust.custstate("Wallstreet");
		log.info("State Entered");
		addcust.custpinno("754211");
		log.info("Pin Number Entered");
		addcust.custtelephoneno("8734675523");
		log.info("Telephone Number Entered");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		log.info("Mail ID Entered");
		addcust.custpassword(password);
		log.info("Password Entered");
		addcust.custsubmit();
		log.info("Clicked on Submit Button");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		String customerID=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[1]")).getText();
		String ID=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		System.out.println(customerID+"  "+ID);
		
		try {
			PrintStream prs=new PrintStream("export.properties");
//			prs.print("customerid="+ID);
			prs.println("customerid="+ID);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
