//WAS to enter the username and password textfields facebook app.abstract
package Basic;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException, NoSuchElementException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Forgotten account?")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("manvivinay");
		Thread.sleep(1000);
		driver.findElement(By.name("pass")).sendKeys("jaguar");
		Thread.sleep(1000);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		String id = driver.getWindowHandle();
		System.out.println(id);
		String ttl = driver.getTitle();
		System.out.println(ttl);
		driver.navigate().to("https://www.playstation.com/en-in/explore/ps4/");
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("We use cookies to personalise")).click();
		Thread.sleep(10000);
		driver.close();
		
	}

}
