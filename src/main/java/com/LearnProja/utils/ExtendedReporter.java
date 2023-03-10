package com.LearnProja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendedReporter{
	
	public static ExtentReports generateExtendReport()
	{
		ExtentReports extentReports=new ExtentReports();
		 
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extendReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorial Learing Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReports.attachReporter(sparkReporter);
		
		Properties ConfigProp=new Properties();
		File configPropFile= new File(System.getProperty("user.dir")+"src\\main\\java\\com\\totutorials\\qa\\config\\Congifig.proprites");
		try {
			
		FileInputStream fisConfigProp= new FileInputStream(configPropFile);
		ConfigProp.load(fisConfigProp);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		extentReports.setSystemInfo("Application URL",ConfigProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", ConfigProp.getProperty("browser"));
		extentReports.setSystemInfo("Email", ConfigProp.getProperty("validEmail"));
		extentReports.setSystemInfo("Password", ConfigProp.getProperty("validPassword"));
		
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReports;

		
		
		
		
		

	}

}
