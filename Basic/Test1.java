package Basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 extends BaseSettings
{
	public static void main(String[] arg) throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		String expectedTitle = "Facebook";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("TC Passed");
			
		}
		else
		{
			System.out.println("TC Failed");
			
		}
		Thread.sleep(2000);
		driver.close();
	}
}
