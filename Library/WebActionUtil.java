package com.actitime.Library;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil 
{
	public WebDriver driver;
	public long ETO;
	public WebDriverWait wait;
	
	public WebActionUtil(WebDriver driver, long ETO)
	{
		this.driver=driver;
		wait= new WebDriverWait(driver, ETO);
		this.ETO=ETO;
    }

	public  void clickOnElement(WebElement target)
	{
		wait.until(ExpectedConditions.elementToBeClickable(target)).click();
	}
	
	public void enterKeys(WebElement target , String keyToSend)
	{
		wait.until(ExpectedConditions.visibilityOf(target));
		target.clear();
		target.sendKeys(keyToSend);
	}
	
	public void selectDropDownText(WebElement target, String text)
	{
		Select select = new Select(target);
		select.selectByVisibleText(text);	
	}
	
	public void mouseHover(WebElement target)
	{
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}
	
	public void actonClick(WebElement target)
	{
		Actions action = new Actions(driver);
		action.click(target).perform();
	}
	
	public void scrollIntoVIEW(WebElement target)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", target);
	}
	
	public void waitForElementToLoad(WebElement target, String attribute, String value  )
	{
		wait.until(ExpectedConditions.attributeToBe(target, attribute, value));
	}
	
	public void waitForUrlCheck(String currentUrl)
	{
		wait.until(ExpectedConditions.urlContains(currentUrl));
	}
	
	public  void createIdAttribute(WebElement ele )
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript( "var att=document.createAttribute('id');" 
				         + "att.value='usethis';" 
		                 + "arguments[0].setAttributeNode(att);",ele);
	}
	
	public void acceptPopUp()
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	public void dismissPopUp()
	{
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
	}
	
	public void scrollBY(int wheelAmt) throws AWTException
	{
		Robot robot=new Robot();
		robot.mouseWheel(wheelAmt);
	}
	
	

}
