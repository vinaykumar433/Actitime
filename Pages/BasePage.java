package com.actitime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.actitime.Library.WebActionUtil;



public class BasePage 
{
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	
	BasePage(WebDriver driver, WebActionUtil webActionUtil )
	{
		this.driver=driver;
		this.webActionUtil=webActionUtil;
		PageFactory.initElements(driver, this);
	}

}
