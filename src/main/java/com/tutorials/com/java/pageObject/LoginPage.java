package com.tutorials.com.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id="input-email")
	 private WebElement emailAddressField;
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailPasswordNotMatchingWaring;
	 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String emailText) {
		
		 emailAddressField.sendKeys(emailText);
			
	}
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}

	public void clickOnLoginButtonPage()
	{
		loginButton.click();
	}
	
	public String retriveEmailPasswordNotMatchingWaringMessageText() {
		String text=emailPasswordNotMatchingWaring.getText();
		return text;
	}
}



