package com.tutorials.com.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
    @FindBy(id="input-firstname")
	private WebElement FirstNameFileds;
    @FindBy(id="input-lastname")
    private WebElement lastNameField;
    @FindBy(id="input-email")
    private WebElement emailAddressField;
    
    @FindBy(id="input-telephone")
    private WebElement telephoneField;
    
    @FindBy(id="input-password")
    private WebElement passwordFeild;
     
    @FindBy(id="input-confirm")
    private WebElement passwordConfirmField;
    @FindBy(name="agree")
    private WebElement privacyPolicyField;
    
    @FindBy(xpath="//input[@value='Continue']")
    private WebElement contionueButton;
    @FindBy(xpath="//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsLetterOption ;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement duplicateEmailAddressWaring;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement privacypolicyWaring;
    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWaring;
    @FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWaring;
    @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
    private WebElement emailWaring;
    @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWaring;
    @FindBy(xpath="//input[@id='input-password']/following-sibling::div")
    private WebElement ActuvalPasswordWaring;
    
    public RegisterPage(WebDriver driver)
    {
    	this.driver=driver;
    	
    	PageFactory.initElements(driver, this);
    }
    public String retriveActuvalPasswordWaring()
    {
    	String ActuvalPasswordWaringText=ActuvalPasswordWaring.getText();
    	return ActuvalPasswordWaringText;
    }
    public String retrivetelephoneWaring()
    {
    	String telephoneWaringText=telephoneWaring.getText();
    	return telephoneWaringText;
    }
    
    public String retriveEmailWaring()
    {
    	String emailWaringText=emailWaring.getText();
    	return emailWaringText;
    }
    
    
    public String retrivelastNameWaring()
    {
    	String lastNameWaringText=lastNameWaring.getText();
    	return lastNameWaringText;
    }
    public String retrivefirstNameWaring()
    {
     String	privacyfirstNameWaring= firstNameWaring.getText();
     return privacyfirstNameWaring;
    }
    
    public String retriveprivacypolicyWaring()
    {
    	String privacypolicyWaringText= privacypolicyWaring.getText();
    	return privacypolicyWaringText;
    }
    public void enterFirstName(String firstNameText)
    {
    	FirstNameFileds.sendKeys(firstNameText);
    }
    public void enterLastName(String LastNameText)
    {
    	lastNameField.sendKeys(LastNameText);
    }
    public void enterEmailAddress(String emailText)
    {
    	emailAddressField.sendKeys(emailText);
    }
    
    public void enterTelephone(String telephoneText)
    {
    	telephoneField.sendKeys(telephoneText);
    }
    public void EnterPassword(String passwordText)
    {
    	passwordFeild.sendKeys(passwordText);
    }
    public void enterConfirmPassword(String ConfirmPasswordText)
    {
    	passwordConfirmField.sendKeys(ConfirmPasswordText);
    }
    public  void enterprivacyPolicyField()
    {
    	privacyPolicyField.click();
    }
    public void ClickcontionueButton()
    {
    	contionueButton.click();
    }
    public void seleceYesNewsLetterOption()
    {
    	 yesNewsLetterOption.click();
    }
    public String retriveduplicateEmailAddressWaring()
    {
    	 String  duplicateEmailAddressWaringText=duplicateEmailAddressWaring.getText();
    	 
    	 
    	 return duplicateEmailAddressWaringText;
    }
    
    
    
    
}
