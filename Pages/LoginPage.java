package com.actitime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.Library.WebActionUtil;

public class LoginPage extends BasePage
{
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(name="pwd")
	private WebElement passWord;

	@FindBy(id="loginButton")
	private WebElement loginButton;


	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public HomePage login(String UN, String PWD)
	{
		webActionUtil.enterKeys(userName, UN);
		webActionUtil.enterKeys(passWord, PWD);
		webActionUtil.clickOnElement(loginButton);
		
		return new HomePage(driver,  webActionUtil);
	}
	

}
