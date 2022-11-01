package com.InetBanking.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {

	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest test;

	public void onStart(ITestContext context) {
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
	}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}



}
