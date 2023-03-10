package com.tutorials.com.java.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(linkText="Login")
	private WebElement loginOption;
	@FindBy(linkText="Register")
	private WebElement registerOption;
	@FindBy(name="search")
	private WebElement searchOption;
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//Actions
	public void ClickOnsearchButton()
	{
		searchButton.click();
		
	}
	public void enterProductItoSearchBox(String productText)
	{
		searchOption.sendKeys(productText);
	}
	public void clickOnMyAccountDropMenu()
	{
		myAccountDropMenu.click();
		
	}
	public void selectLoginOption()
	{
		loginOption.click();
	}
	public void selectRegisterOption()
	{
		 registerOption.click();
	}
}



