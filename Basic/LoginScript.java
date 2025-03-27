package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScript extends BaseSettings
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("pwd"));
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		
		if(userName.isDisplayed()) System.out.println("Passed::username Tf is dispalyed");
		else System.out.println("Failed::username Tf is not dispalyed");
		
		if(password.isDisplayed()) System.out.println("Passed::password TF id displayed");
		else System.out.println("Failed::password TF is not displayed");
		
		if(loginButton.isDisplayed()) System.out.println("Passed::loginbutton is displayed");
		else System.out.println("Failed::loginbutton id not dislayed");
		
		userName.sendKeys("admin");
		password.sendKeys("manager");
		loginButton.click();
		Thread.sleep(5000);
		
		//Using Webpage Title
//		String expectedTitle ="actiTIME - Enter Time-Track";
//		String actualTitle = driver.getTitle();
		
//		if(actualTitle.equals(expectedTitle)) System.out.println("Passed::Homepage is displayed");
//		else System.out.println("Failed::Homepage is not displayed");
		
		//Using Web Element
		WebElement logout = driver.findElement(By.id("logoutLink"));
		
		if(logout.isDisplayed())  System.out.println("Passed::Homepage is displayed");
		else System.out.println("Failed::Homepage is not displayed");
		
		
		driver.close();
		
		
		
		
		

	}

}
