package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.ReportPage;


public class TestCase_TC019 extends BaseTest
{
	
	@Test
	public void test19() 
	{
		HomePage h=new HomePage(driver,webActionUtil);
		ReportPage r = h.clickOnReports();
		r.clickOnNewReportDropDown();
		String reportType = ExcelDataProvider.getStringValue(XL_PATH, "ReportPage Details", 5, 0);
		r.selectReportType(reportType);
		r.clickOnGenerateHTMLReport();
		r.waitForAddToDashboard();
		r.clickOnaddToDashboard();
		String chartName=RandomStringProvider.getRandomString()+" Chart";
		r.enterChartName(chartName);
		r.clickOnSave();
		r.clickOnReportdashboard();
		r.waitForReportsToLoad();
		Assert.assertTrue(r.isChartCreated(chartName));
		Reporter.log("User is bale to create Time Reports of 'Estimated vs Actual Time' and it reflects in Reports Dashboard.", true);
	}
	

}



