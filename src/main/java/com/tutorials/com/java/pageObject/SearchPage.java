package com.tutorials.com.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
     
	WebDriver driver;
	@FindBy(linkText="HP LP3065")
	private WebElement vaildHPProduct;
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String rertiveNoProductMessageText()
	{
		String noProductMessageText=noProductMessage.getText();
		return noProductMessageText;
	}
	
	
	
	public boolean displayStatuesOfHPValidProduct()
	{
		boolean displayStatues= vaildHPProduct.isDisplayed();
		return displayStatues;
	}
	
}
