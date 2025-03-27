//WAS to close a specific child window with a specific title in naukri.com (example prokarma title)
package Basic;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8 extends BaseSettings
{
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Set<String> ids = driver.getWindowHandles();
		for(String a:ids)
		{
			driver.switchTo().window(a);
			String ttl = driver.getTitle();
			System.out.println(ttl);
			if(ttl.equals("Prokarma"))
			{
				driver.close();
				break;
			}
		}
		driver.quit();
	}

}
