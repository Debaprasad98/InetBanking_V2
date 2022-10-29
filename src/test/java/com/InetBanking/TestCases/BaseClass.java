package com.InetBanking.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com.InetBanking.PageObjects.LoginPage;
import com.InetBanking.Utilities.ReadConfig;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	public static WebDriver driver;
	Logger log;
	ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.geturl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public String browser=readconfig.getbrowser();

	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void extentreport() {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//Start Reporter
		report=new ExtentHtmlReporter("./test-output/Extent-Report"+timestamp+".html");
		report.config().setReportName("Extent Report");
		report.config().setTheme(Theme.DARK);

		//Create Report and attach reporter
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Test Case name", "InetBanking");
		extent.setSystemInfo("Tester", "Debaprasad");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser", "Chrome");

		//Create Toggle for the given Test and add all log event under it
		test=extent.createTest("InetBanking Login","This is for Test the Login Page");

	}

	@BeforeClass
	public void Lunchbrowser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("Edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.info("Browser Lunched");
		driver.get(url);
		test.pass("URL Entered");
		driver.manage().window().maximize();
		log=Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4j.properties");
		log.info("Browser lunched and URL entered");

	}
	@AfterClass
	public void closebrowser() {
		log.info("Closed the browser");
		driver.quit();
		test.info("Browser Closed");
	}
	@AfterTest
	public void FlushReport() {
		extent.flush();
	}
}
