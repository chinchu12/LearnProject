package com.toutorial.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learn.qa.base.Base;
import com.tutorials.com.java.pageObject.HomePage;
import com.tutorials.com.java.pageObject.SearchPage;

public class SearchProductTest extends Base {
	
	public SearchProductTest()
	{
		super();
	}
	 public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		 driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
	}
	@AfterMethod
public void tearDown()
{driver.quit();
	}
	@Test(priority=1)
	public void verifySearchwithValidProduct()
	{
		HomePage homepage=new HomePage(driver);
		homepage.enterProductItoSearchBox(dataProp.getProperty("vaildPdoduct"));
		homepage.ClickOnsearchButton();
		
		SearchPage searchpage=new SearchPage(driver);
		searchpage.displayStatuesOfHPValidProduct();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Avlid hp product is  Not Displayed in the search fields");
			
		
	}
	@Test(priority=2)
	public void verifySearchWithNonExistingProduct()
	{
		HomePage homepage=new HomePage(driver);
		homepage.enterProductItoSearchBox(dataProp.getProperty("invalidProduct"));
		homepage.ClickOnsearchButton();
	
		SearchPage searchpage=new SearchPage(driver);
		String actuvalSearchMessage=searchpage.rertiveNoProductMessageText();
		
			Assert.assertEquals(actuvalSearchMessage,dataProp.getProperty("NoProductTextInSearchResult"),"No Product inSearch Result");
		
	}
	
   @Test(priority=3)
	public void verifySearchWithoutProvidingAnyProduct()
	{
	   HomePage homepage=new HomePage(driver);
	   homepage.ClickOnsearchButton();
	  	
	   SearchPage searchpage=new SearchPage(driver);
		String actuvalSearchMessage=searchpage.rertiveNoProductMessageText();
		
			Assert.assertEquals(actuvalSearchMessage,dataProp.getProperty("NoProductTextInSearchResult"),"No Product inSearch Result");
		
		
	}
}
