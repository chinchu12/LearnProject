package com.tutorials.com.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {
	WebDriver driver;
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement AccountSucessPageHeading;
	
	public  AccountSucessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public String retriveAccountSucessPageHeading()
	{
		 String acoountSucessPageHeadingText=AccountSucessPageHeading.getText();
		 return acoountSucessPageHeadingText;
	}
	

}
