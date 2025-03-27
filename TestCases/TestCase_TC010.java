package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC010 extends BaseTest
{
	String userFN = RandomStringProvider.getRandomString();
	
	@Test
	public void createUser()
	{
		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnNewuser();
		String userLN = RandomStringProvider.getRandomString();
		String userEMAIL = userFN+"@gmail.com";
		u.enterAccountInfo(userFN, userLN, userEMAIL);
		u.clickOnDeptDropDown();
		u.selectDepartment("Production");
		u.clickOnSaveAndSendInvitation();
		u.closeInvitation();
		h.logout();
	}
		
	@Test(dependsOnMethods = {"createUser"})
	public void test10() throws InterruptedException  
	{
		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnDepartments();
		u.clickOnDept("Production");
		u.clickOnUserAsPerDept(userFN);
		u.clickOnMoveTo();
		u.selectMoveToOption("Quality Control");
		u.waitAfterMoved();
		Assert.assertTrue(u.verifyUseAfterMoving("Quality Control", userFN));
		Reporter.log("User is able to move the particular user to the another department and able to see the user in that department in User List page.", true);
	}
	

}


