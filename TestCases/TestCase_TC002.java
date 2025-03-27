package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC002 extends BaseTest
{
	@Test
	public void test2() throws InterruptedException 
	{

		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnNewlyAddedUser("Daniel");
		u.clickOnPermission();
		u.clickOnApplyTemplate();
		String enterPermission = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 4, 2);
		u.selectTempltePermission(enterPermission);
		Assert.assertTrue(u.userPermissionVerification());
		Reporter.log("User is able to set the permissions for the particular newly added user in User List Page.", true);
	}

}


