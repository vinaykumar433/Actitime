package com.actitime.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.actitime.Library.RandomStringProvider;
import com.actitime.Library.WebActionUtil;

public class UserListPage extends BasePage
{
	private WebElement user;
	 
	@FindBy(xpath="//div[text()='New User']")
	private WebElement newUserBtn;
	
	@FindBy(xpath="//div[text()='Bulk Invitations']")
	private WebElement bulkInvitationBtn;
	
	@FindBy(xpath="//div[contains(text(),'Departments')]")
	private WebElement departentBtn;
	
	@FindBy(id="createUserPanel_firstNameField")
	private WebElement firstNameTF;
	
	@FindBy(id="createUserPanel_lastNameField")
	private WebElement lastNameTF;
	
	@FindBy(id="createUserPanel_emailField")
	private WebElement emailTF;
	
	@FindBy(xpath="//div[@id='createUserPanel_accessToOtherProductSelectorLabel']/../..//div[@class='downIcon']")
	private WebElement departmentDropDown;
	
	@FindBy(xpath="//div[@class=\"item\"]")
	private List<WebElement> departmentList;
	
	
	@FindBy(xpath="(//td[@class='x-btn-right'])[4]")
	private WebElement CalenderIcon;
	
	@FindBy(xpath="(//div[.='Overtime Tracking:'])[2]/..//tr[@class=\" x-btn-with-menu\"]")
	private WebElement overtimedropDown ;
	
	@FindBy(xpath="//a[@class=\"x-menu-item\"]")
	private List<WebElement> overtimedropDownList ;
	
	@FindBy(xpath="//div[text()='Save & Send Invitation']")
	private WebElement saveAndSendBtn ;
	
	@FindBy(xpath="//span[text()='Close']")
	private WebElement closeInvitationBtn ;
	
	@FindBy(xpath="//div[text()='Add User']")
	private WebElement addUserTitle ;
	
	@FindBy(xpath="//span[text()='PERMISSIONS']")
	private WebElement permissionBtn ;
	
	@FindBy(xpath="//div[text()='Apply template']")
	private WebElement applyTemplateBtn ;
	
	@FindBy(xpath="//td[@class=\"name\"]/div")
	private List<WebElement> templatePermissionsList ;
	
	@FindBy(xpath="//div[text()='Manage Scope of Work']/..//div[@class=\"img\"]")
	private WebElement permissionCheckbox ;
	
	@FindBy(xpath="//td/input[@placeholder=\"First Name\"]")
	private List<WebElement> listOfFirstNames ;
	
	@FindBy(xpath="//td/input[@placeholder=\"Last Name\"]")
	private List<WebElement> listOfLastNames ;
	
	@FindBy(xpath="//td/input[@placeholder=\"Email\"]")
	private List<WebElement> listOfEmails ;
	
	@FindBy(xpath="//span[@class=\"permissionsTemplateButtonArrow\"]")
	private List<WebElement> listOfPermissionDropDown ;
	
	@FindBy(xpath="//tr[@class=\"permissionsTemplateSelectorRow \" or @class=\"permissionsTemplateSelectorRow last\"]/td/div")
	private List<WebElement> listOfPermissions ;
	
	@FindBy(xpath="//span[text()='Send Invitations']")
	private WebElement sendInvitationBtn ;
	
	@FindBy(xpath="//span[text()='Invite more users']/../..//span[text()='Close']")
	private WebElement closeBtnForBulkInvitation;
	
	@FindBy(xpath="//span[@class=\"userNameSpan\"]")
	private List<WebElement> listOfUsersCreated ;
	
	@FindBy(linkText="Edit user permissions templates")
	private WebElement EditUserPermissionsTemplatesLink;
	
	@FindBy(linkText="Create New Template")
	private WebElement createNewTemplateLink;
	
	@FindBy(xpath="(//div[text()='Permission template  name is empty']/..)[5]")
	private WebElement permissionTemplateNameTF;
	
	@FindBy(xpath="(//div[text()='Permission template  name is empty']/..)[5]/..//div[text()='Manage Scope of Work']")
	private WebElement manageScopeCheckBox;
	
	@FindBy(xpath="(//div[text()='Permission template  name is empty']/..)[5]/..//div[text()='Save Template']")
	private WebElement saveTemplateBtn;
	
	@FindBy(xpath="//div[@class=\"mainIcon\"]")
	private WebElement filterIcon;
	
	@FindBy(xpath="//div[@class=\"list\" and @style=\"display: block;\"]/div/span")
	private List<WebElement> filterList;
	
	@FindBy(xpath="//div[text()='Copy settings from']")
	private WebElement copySettingsFromDD;
	
	@FindBy(xpath="//div[text()='DELETE']")
	private WebElement deleteUserBtn;
	
	@FindBy(xpath="//div[@class=\"supportQuestionButton\"]")
	private WebElement questionIcon;
	
	@FindBy(xpath="//div[@class=\"hideButton\"]")
	private WebElement closeQuestionPopUp;
	
	@FindBy(id="groupManagementLightBox_newGroupInput")
	private WebElement newDeptNameTF;
	
	@FindBy(id="groupManagementLightBox_addGroupButton")
	private WebElement addDeptBtn;
	
	@FindBy(id="groupManagementLightBox_showDisabledUsersCheckbox")
	private WebElement showDisableAccountsCheckBox;
	
	@FindBy(xpath="//button[text()='Move To']")
	private WebElement moveToBtn;
	
	@FindBy(xpath="//a[@class=\"x-menu-item\"]")
	private List<WebElement> moveToOptionsList ;

	
	
	
	
	public UserListPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public void clickOnNewuser()
	{
		webActionUtil.clickOnElement(newUserBtn);
	}
	
	public void clickOnBulkInvitation()
	{
		webActionUtil.clickOnElement(bulkInvitationBtn);
	}
	
	public void clickOnDepartments()
	{
		webActionUtil.clickOnElement(departentBtn);
	}
	
	public void waitTillAddUserPopUp()
	{
		webActionUtil.clickOnElement(departmentDropDown);
		webActionUtil.clickOnElement(departmentDropDown);
	}
	
	
	public void enterAccountInfo(String userFN, String userLN, String userEMAIL) 
	{
		webActionUtil.mouseHover(firstNameTF);
		firstNameTF.click();
		webActionUtil.enterKeys(firstNameTF, userFN);
		webActionUtil.enterKeys( lastNameTF, userLN);
		webActionUtil.enterKeys(emailTF, userEMAIL);
	}
	
	public void clickOnDeptDropDown()
	{
		webActionUtil.clickOnElement(departmentDropDown);
	}
	
	public void selectDepartment(String enterDept)
	{
		for (WebElement list : departmentList)
		{
			if(list.getText().equalsIgnoreCase(enterDept))
			{
				list.click();
				break;
			}
		}
	}
	
	public void clickOnCalender()
	{
		webActionUtil.clickOnElement(CalenderIcon);
	}
	
	public void selectdate(String Date, String Day)
	{
		while(true)
		{
			try
			{
				WebElement date = driver.findElement(By.xpath("//button[text()='"+Date+"']"));
				WebElement day = driver.findElement(By.xpath("//span[text()='"+Day+"'] "));
				if(date.getText().equals(Date))
				{
				     webActionUtil.clickOnElement(day);
				     break;
				}
			}
			 catch(NoSuchElementException e)
			{
				WebElement leftBtn = driver.findElement(By.xpath("//td[@class='x-date-left']"));
				webActionUtil.clickOnElement(leftBtn);
			}
		}
		
	}
	public void selectDateBeforeToPresent(String Date, String Day)
	{
		outer:
		while(true)
		{
			 List<WebElement> date = driver.findElement(By.xpath("//li[@class=\"x-menu-list-item x-menu-date-item\"]")).findElements(By.xpath("(//button[@class=\"x-btn-text\"])[5]"));
			 for (WebElement date1 : date) 
			 {
				 if(date1.getText().equalsIgnoreCase(Date)) break outer;
				 else
				 {
					 WebElement leftBtn = driver.findElement(By.xpath("//td[@class='x-date-left']"));
					 webActionUtil.clickOnElement(leftBtn);
				 }
			 }
		}
	
		 WebElement day = driver.findElement(By.xpath("//span[text()='"+Day+"'] "));
		 webActionUtil.clickOnElement(day);
	}
	
	public void clickOnOvertimeDropDown()
	{
		webActionUtil.scrollIntoVIEW(overtimedropDown);
		webActionUtil.clickOnElement(overtimedropDown);
	}
	
	
	  public void selectfromOvertimeDropDown(String enterOverTimeTrackType)
	  { 
		  for(WebElement overtimelist : overtimedropDownList) 
		  {
			  if(overtimelist.getText().contains(enterOverTimeTrackType))
			  {
				  webActionUtil.clickOnElement(overtimelist);
				  break;
			  }
		  }
	  }
	  
	  public void clickOnSaveAndSendInvitation()
	  {
		  webActionUtil.clickOnElement(saveAndSendBtn);
	  }
	  
	  public void closeInvitation()
	  {
		  webActionUtil.clickOnElement(closeInvitationBtn);
	  }
	  
	  public Boolean userVerification(String userName)
	  {
		  try
		  {
			  user = driver.findElement(By.xpath("//span[contains(text(),'"+userName+"')]"));
			  if(user.getText().contains(userName)) 
				  {
				  	return true;
				  }
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
		  return false;
	  }
	  
	  public void clickOnNewlyAddedUser(String userName)
	  {
		  user = driver.findElement(By.xpath("//span[contains(text(),'"+userName+"')]"));
		  webActionUtil.clickOnElement(user);
	  }
	  
	  public void clickOnPermission()
	  {
		  webActionUtil.clickOnElement(permissionBtn);
	  }
	  
	  public void clickOnApplyTemplate()
	  {
		  webActionUtil.clickOnElement(applyTemplateBtn);
	  }
	  
	  public void selectTempltePermission(String enterPermission)
	  {
		  for (WebElement permission : templatePermissionsList)
		  {
			  if(permission.getText().equalsIgnoreCase(enterPermission))
			  {
				  webActionUtil.clickOnElement(permission);
				  break;
			  }
		  }
	  }
	  
	  
	  public Boolean userPermissionVerification()
	  {
		  String expectedValue="rgba(33, 108, 189, 1)";
		  String actualvalue = permissionCheckbox.getCssValue("color");
		  if(actualvalue.equalsIgnoreCase(expectedValue))
		  {
			  return true;
		  }
		  return false;
	  }
	  
	  public void enterFirstName()
	  {
		  for (WebElement list : listOfFirstNames)
		  {
			  String FN = RandomStringProvider.getRandomString();
			  webActionUtil.enterKeys(list, FN);
		  }
	  }
	  
	  public void enterLastName()
	  {
		  for (WebElement list : listOfLastNames)
		  {
			  String LN = RandomStringProvider.getRandomString();
			  webActionUtil.enterKeys(list, LN);
		  }
	  }
	  
	  public void enterEmail()
	  {
		  for (WebElement list : listOfEmails)
		  {
			  String email = RandomStringProvider.getRandomString()+"@rediffmail.com";
			  webActionUtil.enterKeys(list, email);
		  }
	  }
	  
	  public void selectfromPermissionDropdown(String selectPermission )
	  {
		  for (WebElement DD : listOfPermissionDropDown)
		  {
			 webActionUtil.clickOnElement(DD);
			 for (WebElement permission : listOfPermissions)
			 {
				 if(permission.getText().contains(selectPermission))
				 {
					 webActionUtil.clickOnElement(permission);
					 break;
				 }
				
			 }
		  }
	  }
	  
	  public void clickOnSendinvitation()
	  {
		  webActionUtil.clickOnElement(sendInvitationBtn);
	  }
	  
	  public void clickOnCloseForBulkInvitation()
	  {
		  webActionUtil.clickOnElement(closeBtnForBulkInvitation);
	  }
	  
	  public int noOfUsersExisted()
	  {
		 int noOfUsers = listOfUsersCreated.size();
		 return noOfUsers;
	  }
	  
	  public void clickOnEditUserPermissionsTemplates()
	  {
		  webActionUtil.clickOnElement(EditUserPermissionsTemplatesLink);
	  }
	  
	  public void clickOnCreateNewTemplate()
	  {
		  webActionUtil.clickOnElement(createNewTemplateLink);
	  }
	  
	  public void enterPermissionTemplateName(String templateName)
	  {
		  Actions action=new Actions(driver);
		  action.moveToElement(permissionTemplateNameTF).click().sendKeys(templateName).perform();
	  }
	  
	  public void clickOnManageScopeOfWork()
	  {
		  webActionUtil.clickOnElement(manageScopeCheckBox);
	  }
	  
	  public void clickOnSaveTemplate()
	  {
		  webActionUtil.clickOnElement(saveTemplateBtn);
	  }
	  
	  public Boolean verifyCreatedTemplate(String templateName)
	  {
		  WebElement template = driver.findElement(By.xpath("//div[text()='"+templateName+"']"));
		  if(template.getText().equalsIgnoreCase(templateName))
		  {
			  return true;
		  }
		  return false;
	  }
	  
	  public void clickOnFilterIcon()
	  {
		  webActionUtil.clickOnElement(filterIcon);
	  }
	  
	  public void selectOptionFromFilter(String option)
	  {
		 for (WebElement filtlist : filterList)
		 {
			if(filtlist.getText().equalsIgnoreCase(option)) 
			  {
				  webActionUtil.clickOnElement(filtlist);
				  break; 
			  }
		}
	  }
	  
	  public int noOfUsersAsPerFilter()
	  {
		 webActionUtil.waitForElementToLoad(departentBtn, "class", "userList_manageButtons_component_groupItem department ");
		 webActionUtil.waitForUrlCheck("https://demo.actitime.com/administration/userlist.do");
		 int noOfUsers = listOfUsersCreated.size();
		 return noOfUsers;
	  }
	  
	  public void clickOncopySettingsFromDD()
	  {
		  webActionUtil.clickOnElement(copySettingsFromDD);
	  }
	  
	  public void selectUserFromCopySettinsDD(String addedUserName)
	  {
		  user = driver.findElement(By.xpath("//label[text()='Copy user settings from:']/../../../../..//span[contains(text(),'"+addedUserName+"')]"));
		  webActionUtil.clickOnElement(user);
	  }
	  
	  public Boolean verifyUserCopiedSettings()
	  {
		  WebElement manageScope = driver.findElement(By.xpath("//div[text()='Manage Scope of Work']"));
		  WebElement modifyTT = driver.findElement(By.xpath("//div[text()='Modify Time-Track of Other Users']"));
		  if(manageScope.getCssValue("color").equalsIgnoreCase("rgba(33, 108, 189, 1)")
				  && modifyTT.getCssValue("color").equalsIgnoreCase("rgba(33, 108, 189, 1)")  )
		  {
			  return true;
		  }
		  return false;
	  }
	  
	  public void clickOnDeleteUser()
	  {
		  webActionUtil.clickOnElement(deleteUserBtn);
	  }
	  
	  public void waitAfterPopUp()
	  {
		  webActionUtil.scrollIntoVIEW(questionIcon);
		  webActionUtil.clickOnElement(questionIcon);
		  webActionUtil.clickOnElement(closeQuestionPopUp);
	  }
	  
	  public void enterDeptName(String deptName)
	  {
		  webActionUtil.enterKeys(newDeptNameTF, deptName);
	  }
	  
	  public void clickOnAddDept()
	  {
		  webActionUtil.clickOnElement(addDeptBtn);
	  }
	  
	  public Boolean verifyAddedDepartment(String deptName)
	  {
		  try
		  {
			  driver.findElement(By.xpath("(//div[contains(text(),'Departments')])[2]/../../..//div[text()='"+deptName+"']"));
			  return true;
		  }
		  catch(NoSuchElementException e)
		  {
			  return false;
		  }
	  }
	  
	  public void selectDeptDeleteIcon(String deptName)
	  {
		  WebElement deptDeleteIcon = driver.findElement(By.xpath("//div[text()='"+deptName+"']/../../..//td[@class=\"deleteGroupCell\"]"));
		  webActionUtil.clickOnElement(deptDeleteIcon);
	  }
	  
	  public void clickOnYes_Delete(String deptName)
	  {
		    WebElement delete = driver.findElement(By.xpath("//div[text()='"+deptName+"']/../../..//button[@class=\"confirmDeleteGroupButton\"]"));
		    webActionUtil.clickOnElement(delete);
	  }
	  public void waitAfterDeleted()
	  {
		 webActionUtil.mouseHover(showDisableAccountsCheckBox);
		 webActionUtil.clickOnElement(showDisableAccountsCheckBox);
		 webActionUtil.clickOnElement(showDisableAccountsCheckBox);
	  }
	  
	  public Boolean verifyDeptAfterDelete(String deptName)
	  {
		  try
		  {
			  driver.findElement(By.xpath("//td[@class=\"folderImageCell\"]/..//div[text()='"+deptName+"']"));
			  return true;
		  }
		  catch(NoSuchElementException e)
		  {
			  return false;
		  }
	  }	
	  
	  public void clickOnDept(String deptName)
	  {
		  WebElement dept = driver.findElement(By.xpath("//td[@class=\"folderImageCell\"]/..//div[text()='"+deptName+"']")); 
		  webActionUtil.clickOnElement(dept);
	  }
	  
	  public void clickOnUserAsPerDept(String userName)
	  {
		  WebElement userCheckbox = driver.findElement(By.xpath("//label[contains(text(),'"+userName+"')]/../../..//td[@class=\"checkboxCell\"]"));
		  webActionUtil.clickOnElement(userCheckbox);
	  }
	  
	  public void clickOnMoveTo()
	  {
		  webActionUtil.clickOnElement(moveToBtn);
	  }
	  
	  public void selectMoveToOption(String deptName )
	  {
		  for (WebElement moveToList : moveToOptionsList)
		  {
			  if(moveToList.getText().equalsIgnoreCase(deptName))
			  {
				  webActionUtil.clickOnElement(moveToList);
				  break;
			  }
		  }
	  }
	  
	  public void waitAfterMoved()
	  {
		 webActionUtil.mouseHover(showDisableAccountsCheckBox);
		 webActionUtil.clickOnElement(showDisableAccountsCheckBox);
		 webActionUtil.clickOnElement(showDisableAccountsCheckBox);
	  }
	  
	  public Boolean verifyUseAfterMoving(String deptName, String userName)
	  {
		 try
		 {
			 driver.findElement(By.xpath("//td[@class=\"folderImageCell\"]/..//div[text()='"+deptName+"']")).click();
			 driver.findElement(By.xpath("//label[contains(text(),'"+userName+"')]"));
			 return true;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	  }

	

	  
	  
}
