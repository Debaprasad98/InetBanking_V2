package com.InetBanking.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com.InetBanking.Utilities.ReadConfig;
import com.InetBanking.Utilities.ReadExportValue;

public class BaseClass {
	public static WebDriver driver;
	Logger log;
	ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.geturl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public String browser=readconfig.getbrowser();
	
	ReadExportValue expval=new ReadExportValue();
	String exportval=expval.getexportValue();


	@BeforeClass
	public void Lunchbrowser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("Edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		log=Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4j.properties");
		log.info("Browser lunched and URL entered");

	}
	@AfterClass
	public void closebrowser() {
		log.info("Closed the browser");
		driver.quit();
	}
	public String randomestring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randomNum() {
		String generatenum=RandomStringUtils.randomNumeric(4);
		return generatenum;
	}
}
