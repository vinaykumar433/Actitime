//WAS to open naukri.com & fetch all the window ID's and print it.
package Basic;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Thread.sleep(5000);
	    Set<String> set = driver.getWindowHandles();
	  
	    for(String a:set)
	    {
	    	 System.out.println(a);
	    }
	    driver.quit();
		
		
	}

}
