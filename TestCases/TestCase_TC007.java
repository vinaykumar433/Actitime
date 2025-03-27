package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC007 extends BaseTest
{
	@Test
	public void test7() throws InterruptedException 
	{
		
		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		
		u.clickOnNewuser();
		String userFN = RandomStringProvider.getRandomString();
		String userLN = RandomStringProvider.getRandomString();
		String userEMAIL = userFN+"@gmail.com";
		u.enterAccountInfo(userFN, userLN, userEMAIL);
		u.clickOnSaveAndSendInvitation();
		u.closeInvitation();
		
		u.clickOnNewlyAddedUser(userFN);
		u.clickOnDeleteUser();
		webActionUtil.acceptPopUp();
		u.waitAfterPopUp();
		Assert.assertFalse(u.userVerification(userFN));
		Reporter.log("User is able to delete the particular user under the List of Users in User List Page.", true);
	}

}


