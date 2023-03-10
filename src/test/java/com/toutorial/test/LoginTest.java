package com.toutorial.test;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LearnProja.utils.utilities;
import com.learn.qa.base.Base;
import com.tutorials.com.java.pageObject.AccountPage;
import com.tutorials.com.java.pageObject.HomePage;
import com.tutorials.com.java.pageObject.LoginPage;

public class LoginTest  extends Base{
          
	public LoginTest() 
	{
		super();
		
	}
	
	 public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		
		
		   driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		   HomePage homepage=new HomePage(driver);
		   homepage.clickOnMyAccountDropMenu();
		   homepage.selectLoginOption();
			
	}
	
	
	@AfterMethod
	public void teadDown()
	{
		driver.quit();
	}
	@Test(priority=1,dataProvider="validCredentialSupplier")
	public void verifyLoginWithValidCredentials(String email,String password) 
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginButtonPage();
		
		AccountPage accountpage=new AccountPage(driver);
		
	    Assert.assertTrue(accountpage.getDisplayStatusOfEdityourAccountInfomationOption(),("Edit your account information"));
	   
	
	
				
			
	}
	
	@DataProvider(name="validCredentialSupplier")
	public Object[][] supplyTestData()
	{
		Object[][] data=utilities.getDataFromExcel("Login"); 
		return data;
	}
	
	@Test(priority=2)
	public void LoginWithInvallidCredentials()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(utilities.gereateEmailWithTimeStamp());
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButtonPage();
		
		
	     String actuvalWaringMessage = loginpage.retriveEmailPasswordNotMatchingWaringMessageText();
		 String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	     Assert.assertTrue(actuvalWaringMessage.contains(expectedWaringMessage),"Expected Waring message is not displayed" );
		
		
		
	
	}
	@Test(priority=3)
	public void VerifyLoginWithInvaildEmailAndValidPassword() 
	{
		
      LoginPage loginpage = new LoginPage(driver);
      loginpage.enterEmailAddress(utilities.gereateEmailWithTimeStamp());
      loginpage.enterPassword(prop.getProperty("validPassword"));
	
		loginpage.clickOnLoginButtonPage();
		

	     String actuvalWaringMessage = loginpage.retriveEmailPasswordNotMatchingWaringMessageText();
		 String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	     Assert.assertTrue(actuvalWaringMessage.contains(expectedWaringMessage),"Expected Waring message is not displayed" );
		
		
		
		
		
		
	}
	@Test(priority=4)
	
	public void VerifyLoginWithValidEmailAndInvalidPassword()
	
	{
		 LoginPage loginpage = new LoginPage(driver);
		 loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword")); 
		loginpage.clickOnLoginButtonPage();
		
	 


	     String actuvalWaringMessage = loginpage.retriveEmailPasswordNotMatchingWaringMessageText();
		 String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	     Assert.assertTrue(actuvalWaringMessage.contains(expectedWaringMessage),"Expected Waring message is not displayed" );
		
		
		
		
	}
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {
		
	
		 LoginPage loginpage = new LoginPage(driver);
		 loginpage.clickOnLoginButtonPage();
		
		
		 String actuvalWaringMessage = loginpage.retriveEmailPasswordNotMatchingWaringMessageText();
		 String expectedWaringMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	     Assert.assertTrue(actuvalWaringMessage.contains(expectedWaringMessage),"Expected Waring message is not displayed" );
		
		
		
		
		
	}

		
		
		
}
