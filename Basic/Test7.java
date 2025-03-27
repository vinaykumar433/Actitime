//WAS to fetch all d window titles of naukri.com & finally close the last child window.
package Basic;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test7 extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Thread.sleep(3000);
		Set<String> id = driver.getWindowHandles();
		
		for(String a:id)
		{
			driver.switchTo().window(a); //here switching to every window to get the title
		    String title = driver.getTitle();
		    System.out.println(title);
		}
		driver.close();
		Thread.sleep(2000);
		driver.quit();
	}

}
