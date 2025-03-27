package com.actitime.TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.ReportPage;


public class TestCase_TC013 extends BaseTest
{
	@Test
	public void test13() throws InterruptedException 
	{
		HomePage h=new HomePage(driver,webActionUtil);
		ReportPage r = h.clickOnReports();
		r.clickOnCopyToDropDown("Scheduled vs. Worked Hours+Overtime");
		String deptName = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 3, 0);
		r.selectDept(deptName);
		r.clickOnCopyToButton();
		Assert.assertTrue(r.isConfPopUpDisplayed());
		Reporter.log("Report Configuration has been successfully copied to the perticular dashboard and pop-up is displayed.", true);
		
	}
	

}



