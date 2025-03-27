package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC006 extends BaseTest
{
	@Test
	public void test6() throws InterruptedException 
	{
		String userFN = RandomStringProvider.getRandomString();
		String userLN = RandomStringProvider.getRandomString();
		String userEMAIL = userFN+"@gmail.com";
		
		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnNewuser();
		Thread.sleep(1000);
		u.enterAccountInfo(userFN, userLN, userEMAIL);
		u.clickOnCalender();
		u.selectdate("June 2020", "25");
		u.clickOncopySettingsFromDD();
		u.selectUserFromCopySettinsDD("Daniel");
		u.clickOnSaveAndSendInvitation();
		u.closeInvitation();
		u.clickOnNewlyAddedUser(userFN);
		u.clickOnPermission();
		Assert.assertTrue(u.verifyUserCopiedSettings());
		Reporter.log("User is able to get the settings of the Already existing user to the Newly Adding user and "
				+ "User added successfully under List of Users in User List Page.", true);
	}

}


