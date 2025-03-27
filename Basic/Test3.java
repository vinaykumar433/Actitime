package Basic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		
		Dimension dim = driver.manage().window().getSize();
		System.out.println(dim.getHeight());
		System.out.println(dim.getWidth());
		
		Thread.sleep(2000);
		
		Dimension dim1=new Dimension(800,600);
		driver.manage().window().setSize(dim1);
		
		Thread.sleep(2000);
		
		driver.close();
		  
		
		
	}

}
