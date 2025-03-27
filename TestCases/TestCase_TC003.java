package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC003 extends BaseTest
{
	@Test
	public void test3() throws InterruptedException 
	{

		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnBulkInvitation();
		u.enterFirstName();
		u.enterLastName();
		u.enterEmail();
		String selectPermission = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 4, 2);
		u.selectfromPermissionDropdown(selectPermission);
		int expUsers = u.noOfUsersExisted()+7;
		u.clickOnSendinvitation();
		u.clickOnCloseForBulkInvitation();
		int actUsers = u.noOfUsersExisted();
		Assert.assertEquals(actUsers, expUsers);
		Reporter.log("User is able to send the invitations to the multiple users and is able to see the added users under the List of Users in User list Page.", true);
	}

}


