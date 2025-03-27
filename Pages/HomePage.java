package com.actitime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.Library.WebActionUtil;

public class HomePage extends BasePage
{
	@FindBy(id="logoutLink")
	public WebElement logoutBtn;

	@FindBy(id="container_users")
	private WebElement usersModule;

	@FindBy(id="container_reports")
	private WebElement reportsModule;

	@FindBy(id="container_tt")
	private WebElement timeTrackModule;



	public HomePage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}

	public void logout()
	{
		webActionUtil.clickOnElement(logoutBtn);
	}
	public UserListPage clickOnUsers()
	{
		webActionUtil.clickOnElement(usersModule);
		return new UserListPage(driver,  webActionUtil);
	}

	public ReportPage clickOnReports()
	{
		webActionUtil.clickOnElement(reportsModule);
		return new ReportPage(driver,  webActionUtil);
	}

	public TimeTrackPage clickOnTimeTrack()
	{
		webActionUtil.clickOnElement(timeTrackModule);
		return new TimeTrackPage(driver,  webActionUtil);
	}
}