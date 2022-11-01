package com.InetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver idriver;

	public AddCustomerPage(WebDriver cdriver){
		idriver=cdriver;
		PageFactory.initElements(cdriver, this);
	}

	@FindBy(xpath="//a[text()='New Customer']")
	WebElement lnkAddNewCustomer;

	@FindBy(name="name")
	WebElement txtCustomerName;

	@FindBy(name="rad1")
	WebElement customerGender;

	@FindBy(id="dob")
	WebElement txtdob;

	@FindBy(name="addr")
	WebElement txtaddress;

	@FindBy(name="city")
	WebElement txtCity;

	@FindBy(name="state")
	WebElement txtState;

	@FindBy(name="pinno")
	WebElement txtPinno;

	@FindBy(name="telephoneno")
	WebElement txtTelephoneno;

	@FindBy(name="emailid")
	WebElement txtEmailid;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name="sub")
	WebElement btnSubmit;


	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	public void custGender() {
		customerGender.click();
	}
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custAdress(String cadress) {
		txtaddress.sendKeys(cadress);
	}
	public void customerCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
		txtState.sendKeys(cstate);
	}
	public void custpinno(String cpinno) {
		txtPinno.sendKeys(String.valueOf(cpinno));
	}
	public void custtelephoneno(String ctelephoneno) {
		txtTelephoneno.sendKeys(ctelephoneno);
	}
	public void custemailid(String cemailid) {
		txtEmailid.sendKeys(cemailid);
	}
	public void custpassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	public void custsubmit() {
		btnSubmit.click();
	}
}
