//WAS to login & logout using implicityWait()
package Basic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicite extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
//		driver.findElement(By.id("username")).sendKeys("admin");
		driver.switchTo().activeElement().sendKeys("admin"); // activeElement()
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
//		Thread.sleep(10000);
		driver.findElement(By.id("logoutLink")).click();
		driver.close();
				
	}

}
