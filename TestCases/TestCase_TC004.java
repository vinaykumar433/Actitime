package com.actitime.TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.Library.ExcelDataProvider;
import com.actitime.Library.RandomStringProvider;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.UserListPage;


public class TestCase_TC004 extends BaseTest
{
	@Test
	public void test4() throws InterruptedException 
	{

		HomePage h=new HomePage(driver,webActionUtil);
		UserListPage u = h.clickOnUsers();
		u.clickOnBulkInvitation();
		u.clickOnEditUserPermissionsTemplates();
		u.clickOnCreateNewTemplate();
		Thread.sleep(1500);
		String templateName=RandomStringProvider.getRandomString()+" Employee";
		u.enterPermissionTemplateName(templateName);
		u.clickOnManageScopeOfWork();
		u.clickOnSaveTemplate();
		Thread.sleep(1500);
		u.clickOnEditUserPermissionsTemplates();
		Assert.assertTrue(u.verifyCreatedTemplate(templateName));
		Reporter.log("Newly added Permission Template is listed in the already existing template permissions under Edit user permissions templates in User List Page.", true);
	}

}


