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
import org.testng.annotations.Test;

import com.LearnProja.utils.utilities;
import com.learn.qa.base.Base;
import com.tutorials.com.java.pageObject.AccountSucessPage;
import com.tutorials.com.java.pageObject.HomePage;
import com.tutorials.com.java.pageObject.RegisterPage;

public class RegisterTest  extends Base{
	
	public RegisterTest()
	{
		super();
	}
	 public WebDriver driver;
	
	@BeforeMethod
	public void setUpMethod()
	{
		 driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		 HomePage homepage=new HomePage(driver);
		 homepage.clickOnMyAccountDropMenu();
		 homepage.selectRegisterOption();
			
	}
	
    @AfterMethod
	public void tearDown()
	{
    	driver.quit();
	}
	
	
	@Test(priority=1)
	
	public void verifyRegisteringAnAccountWithMandatoryFields()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName")); 
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(utilities.gereateEmailWithTimeStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerpage.EnterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.enterprivacyPolicyField();
		registerpage.ClickcontionueButton();
		
	
		AccountSucessPage accountsucesspage=new AccountSucessPage(driver);
		
		String	actuvalSucessHeading=accountsucesspage.retriveAccountSucessPageHeading();
		
		Assert.assertEquals(actuvalSucessHeading,dataProp.getProperty("accountSucessfullyCreatedHeading"),"Account Sucess page is not Displayed");
	
	}
	@Test(priority=2)
	
	public void verifyRegisteringAccountByProvidingAllFileds()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(utilities.gereateEmailWithTimeStamp());
		registerpage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerpage.EnterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.seleceYesNewsLetterOption();
		registerpage.enterprivacyPolicyField();
		registerpage.ClickcontionueButton();


		AccountSucessPage accountsucesspage=new AccountSucessPage(driver);
		
		String	actuvalSucessHeading=accountsucesspage.retriveAccountSucessPageHeading();
		
		Assert.assertEquals(actuvalSucessHeading,dataProp.getProperty("accountSucessfullyCreatedHeading"),"Account Sucess page is not Displayed");
	}
	@Test(priority=3)
	
	
	public void verifyRegisterAccountWithExisitingEmail()
	{
		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(prop.getProperty("validEmail"));
		registerpage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerpage.EnterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.seleceYesNewsLetterOption();
		registerpage.enterprivacyPolicyField();
		registerpage.ClickcontionueButton();
	
		String ActuvalWarinnig=registerpage.retriveduplicateEmailAddressWaring();
		Assert.assertTrue(ActuvalWarinnig.contains(dataProp.getProperty("duplicateEmailWaring")),"Waring message is Not Displayed");
		
		
		
	}
	@Test(priority=4)
	
	public void VerifyRegisteringWithoutProvidingAnyDetails()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		 registerpage.ClickcontionueButton();
		
		
		String ActuvalprivacyPolicyWarining=registerpage.retriveprivacypolicyWaring();
		Assert.assertTrue(ActuvalprivacyPolicyWarining.contains(dataProp.getProperty("privacyWaring")),"Privacy Policy warining message Not Displayed");
		
		String AcuvalFirstNameWarining=registerpage.retrivefirstNameWaring();
		Assert.assertEquals(AcuvalFirstNameWarining,dataProp.getProperty("firstNameWaring"),"ActuvalNamePrivacyWarining not displayed");
		
		
         String AcuvalLastNameWarining=registerpage.retrivelastNameWaring();
         Assert.assertEquals(AcuvalLastNameWarining,dataProp.getProperty("lastNameWaring"),"ActuvalLastNamePrivacyWarining not displayed");
		
		
        String ActuvalEmailidWarining=registerpage.retriveEmailWaring();
        Assert.assertEquals(ActuvalEmailidWarining,dataProp.getProperty("emailAddressWaring"),"ActuvalEmailPrivacyWarining not displayed");
		


        String ActuvalPhoneNumberWarining=registerpage.retrivetelephoneWaring();
        Assert.assertEquals(ActuvalPhoneNumberWarining,dataProp.getProperty("telephoneNumberWaring"),"ActuvalPhoneNumberPrivacyWarining not displayed");


       String ActuvalPasswordWarining=registerpage.retriveActuvalPasswordWaring();
       Assert.assertEquals(ActuvalPasswordWarining,dataProp.getProperty("passwordWaring"),"ActuvalPasswordPrivacyWarining not displayed");
	
		
		
		
		
	}
	
	
	
}
