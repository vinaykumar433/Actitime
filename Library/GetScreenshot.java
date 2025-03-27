package com.actitime.Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot 
{
	public static void captureScreenshot(WebDriver driver, String path)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest=new File(path);
	    try {
			FileUtils.copyFile(src, dest);
			System.out.println("screenshot captured");
		} 
	    catch (IOException e)
	    {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
	}
}
