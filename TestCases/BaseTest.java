package com.actitime.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.actitime.Library.DateTimeProvider;
import com.actitime.Library.GetScreenshot;
import com.actitime.Library.IAutoConstants;
import com.actitime.Library.WebActionUtil;
import com.actitime.Pages.HomePage;
import com.actitime.Pages.LoginPage;



public class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	
	@Parameters({"browserName", "appUrl", "ITO", "ETO"})
	@BeforeClass
	public void launchApp(@Optional (BROWSER_NAME)String browserName,
			              @Optional (APP_URL)String appUrl,
			              @Optional (ITO)String ITO, 
			              @Optional (ETO)String ETO)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VLAUE);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECHO_KEY, GECKO_VLAUE);
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver(options);
		}
		else
		{
			throw new IllegalArgumentException(browserName+"Not Supported");
		}
		
		driver.manage().window().maximize();
		long implicit=Long.parseLong(ITO);
		driver.manage().timeouts().implicitlyWait(implicit, TimeUnit.SECONDS);
		driver.get(APP_URL);
		long explicit=Long.parseLong(ETO);
		webActionUtil = new WebActionUtil(driver,explicit);
		
	}
	
	
	
	  @Parameters({"un","pwd"})
	  @BeforeMethod 
	  public void loginToApp(@Optional(USERNAME)String un, 
			                 @Optional(PASSWORD)String pwd) 
	  { 
		  try
		  {
			  LoginPage l=new LoginPage(driver, webActionUtil);
			  HomePage h = l.login(un, pwd);
			  Assert.assertEquals(h.logoutBtn.getAttribute("class"), "logout");
			  Reporter.log("Login is successfull", true);
		  }
		  catch(Exception e)
		  {
			  Reporter.log("Login is not successfull", true); 
		  }
	  }
	 
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==2)
		{
			GetScreenshot.captureScreenshot(driver, IMAGE_PATH+DateTimeProvider.getCurrentDateTime()+".png");
		}
	}
	
	
	@AfterClass(alwaysRun=true)
	public void closeApp()
	{
		driver.quit();
	}
}
