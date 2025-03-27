package com.actitime.TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.ReportPage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC014 extends BaseTest
{
	String chartName=RandomStringProvider.getRandomString()+" Chart";
	
	@Test
	public void createChart()  
	{
		HomePage h=new HomePage(driver,webActionUtil);
		ReportPage r = h.clickOnReports();
		r.clickOnCreateChart();
		r.waitForAddToDashboard();
		r.clickOnaddToDashboard();
		r.enterChartName(chartName);
		r.clickOnSave();
		r.clickOnCloseCreateChart();
		h.logout();
	}
	
	@Test(dependsOnMethods = {"createChart"})
	public void test14() 
	{
		HomePage h=new HomePage(driver,webActionUtil);
		ReportPage r = h.clickOnReports();
		r.clickOnDeleteChartIcon(chartName);
		webActionUtil.acceptPopUp();
		r.waitAfterChartDeleted();
		Assert.assertFalse(r.isChartDeleted(chartName));
		Reporter.log("User is able to delete the chart and Report has been successfully deleted pop-up is displayed.", true);
	}
	

}



