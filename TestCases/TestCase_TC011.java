package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.ReportPage;


public class TestCase_TC011 extends BaseTest
{
	@Test
	public void test11() throws InterruptedException   
	{
		HomePage h=new HomePage(driver,webActionUtil);
		ReportPage r = h.clickOnReports();
		r.clickOnCreateChart();
		r.waitForAddToDashboard();
		r.clickOnaddToDashboard();
		String chartName=RandomStringProvider.getRandomString()+" Chart";
		r.enterChartName(chartName);
		r.clickOnSave();
		r.clickOnCloseCreateChart();
		r.waitAfterChartCreated();
		Assert.assertTrue(r.isChartCreated(chartName));
		Reporter.log("User is able to create the chart with the provided name and that chart is displayed in reports dashboard.", true);
	}
	

}


