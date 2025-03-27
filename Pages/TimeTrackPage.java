package com.actitime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.Library.WebActionUtil;

public class TimeTrackPage extends BasePage
{
	@FindBy(xpath = "//span[text()='New']")
	public WebElement newTask;



	public TimeTrackPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}

	public void clickOnNewTask()
	{
		webActionUtil.clickOnElement(newTask);;
	}

}