package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericScript extends BaseSettings
{
	public static boolean isElementPresent(WebDriver driver,By b)
	{
		boolean status=false;
		try 
		{
			WebElement userName=driver.findElement(b);
			System.out.println("Element is present");
			if (userName.isDisplayed()) status=true;
			else status=false;
			
		} 
		catch (NoSuchElementException e)
		{
			System.out.println("Element is not present");
		}
		return status;
	}
	
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		boolean result = isElementPresent (driver,By.name("username"));
		System.out.println(result);
		driver.close();
	}

}
