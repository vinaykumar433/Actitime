package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC009 extends BaseTest
{
	@Test
	public void test9() throws InterruptedException  
	{
		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnDepartments();
		String deptName=RandomStringProvider.getRandomString();
		u.enterDeptName(deptName);
		u.clickOnAddDept();
		//above code is creating the department
		
		u.selectDeptDeleteIcon(deptName);
		u.clickOnYes_Delete(deptName);
		u.waitAfterDeleted();
		Assert.assertFalse(u.verifyDeptAfterDelete(deptName));
		Reporter.log("User is able to delete the particular Department under the Manage Departments in User List Page.", true);
	}
	

}


