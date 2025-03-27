package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC008 extends BaseTest
{
	@Test
	public void test8() throws InterruptedException 
	{
		
		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnDepartments();
		String deptName=RandomStringProvider.getRandomString();
		u.enterDeptName(deptName);
		u.clickOnAddDept();
		Assert.assertTrue(u.verifyAddedDepartment(deptName));
		Reporter.log("User is able to see the Newly added Department under Departments in User List Page.", true);
	}

}


