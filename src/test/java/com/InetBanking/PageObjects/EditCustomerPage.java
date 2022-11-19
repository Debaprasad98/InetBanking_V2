package com.InetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	public EditCustomerPage(WebDriver cdriver) {
		PageFactory.initElements(cdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement lnkEditCustomer;
	
	@FindBy(name="cusid")
	WebElement txtCustomerID;
	
	@FindBy(name="AccSubmit")
	WebElement btnSubmit;
	
	@FindBy(name="sub")
	WebElement fnlSubmit;
	
	@FindBy(name="pinno")
	WebElement txtPinno;
	
	public void clickEditCustomer() {
		lnkEditCustomer.click();
	}
	public void customerID(String Custid) {
		txtCustomerID.sendKeys(Custid);
	}
	public void clickSubmit() {
		btnSubmit.click();
	}
	public void finalSubmit() {
		fnlSubmit.click();
	}
	public void custpinno(String cpinno) {
		txtPinno.clear();
		txtPinno.sendKeys(String.valueOf(cpinno));
	}
}
