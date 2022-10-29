package com.InetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver1) {
		PageFactory.initElements(driver1,this);
	}
	
	@FindBy(name="uid")
	WebElement un;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement lgn;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement lgt;
	
	
	
	public void setusername(String username) {
		un.sendKeys(username);
	}
	public void setpassword(String password) {
		pwd.sendKeys(password);
	}
	public void setlogin() {
		lgn.click();
	}
	public void setlogout() {
		lgt.click();
	}
}
