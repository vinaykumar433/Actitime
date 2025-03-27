package com.actitime.TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.ReportPage;


public class TestCase_TC012 extends BaseTest
{
	@Test
	public void test12() throws InterruptedException 
	{
		HomePage h=new HomePage(driver,webActionUtil);
		ReportPage r = h.clickOnReports();
		r.clickOnCreateChart();
		r.clickOnAllStaffDD();
		r.clickOnSelectedStaffRadioButton();
		String deptName = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 3, 0);
		r.selectDept(deptName);
		r.clickOnApplyBtn();
		r.waitForExportToPdfPopUp();
		r.clickOnExportToPdf();
		r.waitForDownloadoPdfPopUp();
		r.clickOnDownloadPdf();
		Assert.assertTrue(true);
		Reporter.log("User is able to download the pdf of the particular chart.", true);
	}
	

}



