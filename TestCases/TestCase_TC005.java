package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC005 extends BaseTest
{
	@Test
	public void test5() throws InterruptedException 
	{

		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnFilterIcon();
		String option = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 4, 3);
		u.selectOptionFromFilter(option);
		Thread.sleep(1500);
		if(u.noOfUsersAsPerFilter()>0)
		{
			Assert.assertTrue(true);
			Reporter.log("User is able able to see the users according to the Filter applied under List of Users in User List Page.", true);
		}
		else 
		{
			Assert.assertFalse(false);
			Reporter.log("There are no users according to the Filter applied under List of Users in User List Page.", true);
		}
	}

}


