package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.ReportPage;
import com.actitime.Pages.TimeTrackPage;


public class TestCase_TC024 extends BaseTest
{
	
	@Test
	public void test24() 
	{
		HomePage h=new HomePage(driver,webActionUtil);
		TimeTrackPage t = h.clickOnTimeTrack();
		t.clickOnNewTask();
		
	}
	

}



