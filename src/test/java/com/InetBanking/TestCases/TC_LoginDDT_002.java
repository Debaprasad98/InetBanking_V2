package com.InetBanking.TestCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.*;

import com.InetBanking.PageObjects.LoginPage;
import com.InetBanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	public static LoginPage lp;
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd,String res) throws InterruptedException {
		lp=new LoginPage(driver);
		lp.setusername(user);
		log.info("Username Entered");
		lp.setpassword(pwd);
		log.info("Password Entered");
		lp.setlogin();
		log.info("Clicked on login button");
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();//Close invalid credentials Alert
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			Assert.assertTrue(true);
		} else {
			lp.setlogout();
			driver.switchTo().alert().accept();//Close Logout Alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
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

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
		String path="C:\\Users\\debap\\eclipse-workspace\\InetBanking_V2\\src\\test\\java\\com\\InetBanking\\TestData\\LoginData.xlsx";
		XLUtils xlutil=new XLUtils(path);
		int rownum=XLUtils.getRowCount("Sheet1");
		int cellnum=XLUtils.getCellCount("Sheet1",1);

		String logindata[][]=new String[rownum][cellnum];

		for (int i=1; i<=rownum;i++) {
			for (int j=0; j<cellnum;j++) {
				logindata[i-1][j]=XLUtils.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
