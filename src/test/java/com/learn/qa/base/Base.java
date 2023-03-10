package com.learn.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.LearnProja.utils.utilities;

public class Base {

	WebDriver driver;
	 public Properties prop;
	 public Properties dataProp;
	
	public Base()
	{
		 prop=new Properties();
		File proFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\totutorials\\qa\\config\\Congifig.proprites");
		dataProp=new Properties();
		File dtaPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorials\\qa\\testData\\testDataproperties");
		try
		{
		FileInputStream dataFis= new FileInputStream(dtaPropFile);
		dataProp.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	
		
		try {
		    FileInputStream fis= new FileInputStream(proFile);
		   prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
			
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)
	{

		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_WAIT_TIME));
			driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
}
