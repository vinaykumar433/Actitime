package Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.actitime.com/");
		Thread.sleep(2000);
		String pageSrc = driver.getPageSource();
		String text= "Start Using actiTIME";
		if(pageSrc.contains(text))
		{
			System.out.println("test case is passed");
		}
		else
		{
			System.out.println("test case is Failed");
		}
		driver.close();
	}

}