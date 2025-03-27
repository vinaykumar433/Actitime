package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC001 extends BaseTest
{
	@Test
	public void test1() throws InterruptedException 
	{
		String userFN = RandomStringProvider.getRandomString();
		String userLN = RandomStringProvider.getRandomString();
		String userEMAIL = userFN+"@gmail.com";
		String enterDept = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 1, 0);
		String enterOverTimeTrackType = ExcelDataProvider.getStringValue(XL_PATH, "UserDetails", 3, 0);


		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		Reporter.log("Clicked on Users module", true);
		u.clickOnNewuser();
		Reporter.log("Clicked on new user button", true);
		u.waitTillAddUserPopUp();
		u.enterAccountInfo(userFN, userLN, userEMAIL);
		Reporter.log("Provided required details", true);
		u.clickOnDeptDropDown();
		u.selectDepartment(enterDept);
		Reporter.log("Selected the department", true);
		u.clickOnCalender();
//		u.selectdate("July 2020", "5");
		u.selectDateBeforeToPresent("August 2019", "20");
		Reporter.log("Selected date", true);
		u.clickOnOvertimeDropDown();
		u.selectfromOvertimeDropDown(enterOverTimeTrackType);
		Reporter.log("Selected Overtime Tracking option", true);
		u.clickOnSaveAndSendInvitation();
		Reporter.log("clicked on save & send Invitation button", true);
		u.closeInvitation();
		Assert.assertTrue(u.userVerification(userFN));
		Reporter.log("New user is added Successfully and able to see the new user in the userlist page", true);

	}

}


