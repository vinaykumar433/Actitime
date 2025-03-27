package com.actitime.Pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.Library.WebActionUtil;

public class ReportPage extends BasePage
{
	
	@FindBy(xpath="//span[text()='Create Chart']")
	private WebElement createChartbtn;
	
	@FindBy(xpath="//div[@class=\"addToDashboard\"]")
	private WebElement addToDashboardEle;
	
	@FindBy(xpath="//input[contains(@class,'reportNameEdit')]")
	private WebElement chartNmaeTF;
	
	@FindBy(xpath="//td[@class=\"saveNewConfigButton greyButton\"]")
	private WebElement saveBtn;
	
	@FindBy(id="closeCreateChartLightboxButton")
	private WebElement closeCreateChartIcon;
	
	@FindBy(xpath="//div[@class=\"supportQuestionButton\"]")
	private WebElement questionIcon;
	
	@FindBy(xpath="//div[@class=\"hideButton\"]")
	private WebElement closeQuestionPopUp;
	
	@FindBy(xpath="//div[@class=\"config-name\"]")
	private List<WebElement> chartList;
	
	@FindBy(xpath="//div[text()='Create Chart:']/../../../../..//span[text()='All Staff']")
	private WebElement allStaffDD;
	
	@FindBy(xpath="//label[text()='Selected Staff']")
	private WebElement selectedStaffRadioButton;
	
	@FindBy(xpath="//span[text()='Apply']")
	private WebElement applyBtn;
	
	@FindBy(xpath="//span[text()='Export to PDF']")
	private WebElement exportToPDFBtn;
	
	@FindBy(xpath="//span[text()='Download PDF']")
	private WebElement downloadPDFBtn;
	
	@FindBy(xpath="//span[text()='reset filter']/../../../..//span[text()='Copy to']")
	private WebElement copyToBtn;
	
	@FindBy(xpath="//span[contains(text(),'Report configuration has been successfully copied')]")
	private WebElement confPopup;
	
	@FindBy(xpath="//div[contains(@class,'createReportDropdownButton')]")
	private WebElement newReportDD;
	
	@FindBy(xpath="//a[@class=\"x-menu-item\"]")
	private List<WebElement> newReportList;
	
	@FindBy(xpath="//span[@id=\"cancelReportConfiguration\"]/..//span[text()='Generate HTML Report']")
	private WebElement generateHTMLReportBtn;
	
	@FindBy(linkText="Reports Dashboard")
	private WebElement reportDashBoard;
	
	
	
	
	
	
	public ReportPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public void clickOnCreateChart()
	{
		webActionUtil.clickOnElement(createChartbtn);
	}
	
	public void waitForAddToDashboard()
	{
		WebElement dropdown = driver.findElement(By.xpath("//span[text()='Current month']"));
		webActionUtil.clickOnElement(dropdown);
		webActionUtil.clickOnElement(dropdown);
	}
	public void clickOnaddToDashboard()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", addToDashboardEle);
	}
	
	public void enterChartName(String chartName)
	{
		webActionUtil.enterKeys(chartNmaeTF, chartName);
	}
	
	public void clickOnSave()
	{
		webActionUtil.clickOnElement(saveBtn);
	}
	
	public void clickOnCloseCreateChart()
	{
		webActionUtil.clickOnElement(closeCreateChartIcon);
	}
	
	 public void waitAfterChartCreated()
	  {
		  webActionUtil.mouseHover(questionIcon);
		  webActionUtil.clickOnElement(questionIcon);
		  webActionUtil.clickOnElement(closeQuestionPopUp);
	  }
	
	public Boolean isChartCreated(String chartName)
	{
		try
		{
			driver.findElement(By.xpath("//div[text()='"+chartName+"']"));
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public void clickOnAllStaffDD()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", allStaffDD);
	}
	
	public void clickOnSelectedStaffRadioButton()
	{
		webActionUtil.clickOnElement(selectedStaffRadioButton);
	}
	
	public void selectDept(String deptName)
	{
		WebElement dept = driver.findElement(By.xpath("//span[text()='"+deptName+"']"));
		webActionUtil.clickOnElement(dept);
	}
	 
	public void clickOnApplyBtn()
	{
		webActionUtil.clickOnElement(applyBtn);
	}
	
	public void waitForExportToPdfPopUp()
	{
		WebElement dropdown = driver.findElement(By.xpath("//span[text()='Current month']"));
		webActionUtil.scrollIntoVIEW(dropdown);
		webActionUtil.clickOnElement(dropdown);
		webActionUtil.clickOnElement(dropdown);
	}
	
	public void clickOnExportToPdf()
	{
		webActionUtil.scrollIntoVIEW(exportToPDFBtn);
		webActionUtil.clickOnElement(exportToPDFBtn);
	}
	
	public void waitForDownloadoPdfPopUp() 
	{
		WebElement checkbox = driver.findElement(By.xpath("//label[text()='Show list of % values']"));
		for (int i = 0; i < 12; i++)
		{
			webActionUtil.clickOnElement(checkbox);
		}
		
	}
	
	public void clickOnDownloadPdf()
	{
		webActionUtil.scrollIntoVIEW(downloadPDFBtn);
		webActionUtil.clickOnElement(downloadPDFBtn);
	}
	
	public void clickOnCopyToDropDown(String chartName)
	{
		driver.findElement(By.xpath("//div[text()="+"\""+chartName+"\""+"]/../../../..//span[text()='Copy to']")).click();
	}
	
	public void clickOnCopyToButton()
	{
		webActionUtil.clickOnElement(copyToBtn);
	}
	
	public Boolean isConfPopUpDisplayed()
	{
		if(confPopup.isDisplayed())
		{
			return true;
		}
		else return false;
	}
	
	public void clickOnDeleteChartIcon(String chartName)
	{
		driver.findElement(By.xpath("//div[text()="+"\""+chartName+"\""+"]/../../../..//td[@class=\"configHeaderRemoveCell\"]")).click();
	}
	
	 public void waitAfterChartDeleted()
	  {
		  webActionUtil.mouseHover(questionIcon);
		  webActionUtil.clickOnElement(questionIcon);
		  webActionUtil.clickOnElement(closeQuestionPopUp);
	  }
	
	public Boolean isChartDeleted(String chartName)
	{
		try
		{
			driver.findElement(By.xpath("//div[text()="+"\""+chartName+"\""+"]"));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnNewReportDropDown()
	{
		webActionUtil.clickOnElement(newReportDD);
	}
	
	public void selectReportType(String reportType)
	{
		for (WebElement list : newReportList)
		{
			if(list.getText().equalsIgnoreCase(reportType))
			{
				webActionUtil.actonClick(list);
				break;
			}
		}
	}
	
	public void clickOnGenerateHTMLReport()
	{
		webActionUtil.clickOnElement(generateHTMLReportBtn);
	}
	
	public void clickOnReportdashboard()
	{
		webActionUtil.clickOnElement(reportDashBoard);
	}
	
	public void waitForReportsToLoad()
	  {
		  webActionUtil.mouseHover(questionIcon);
		  webActionUtil.clickOnElement(questionIcon);
		  webActionUtil.clickOnElement(closeQuestionPopUp);
		  webActionUtil.clickOnElement(questionIcon);
		  webActionUtil.clickOnElement(closeQuestionPopUp);
	  }
	
	
	
	

}
