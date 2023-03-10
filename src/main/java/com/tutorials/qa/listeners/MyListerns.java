package com.tutorials.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.LearnProja.utils.ExtendedReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class MyListerns implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		 extentReport = ExtendedReporter.generateExtendReport();
		
	}


	@Override
	public void onTestStart(ITestResult result) {
	String testName=	result.getName();
     extentTest = extentReport.createTest(testName);
    extentTest.log(Status.INFO, testName+" Started exicuting");
	
	}
		
	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=	result.getName();
		extentTest.log(Status.PASS, testName+" got sucessfully exicuted");
		System.out.println(testName+" got sucessfully exicuted");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=	result.getName();
		
		
		
	WebDriver driver=null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		
		e.printStackTrace();
	}
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL,testName+" got failed");

		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=	result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, testName+" got Skippped");
		
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	


}
