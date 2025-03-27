package Basic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 extends BaseSettings
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		Dimension dim=new Dimension(600,400);
		driver.manage().window().setSize(dim);
		Thread.sleep(2000);
		Point pt = driver.manage().window().getPosition();
		System.out.println(pt.getX());
		System.out.println(pt.getY());
		Point pt1=new Point(150,250);
		driver.manage().window().setPosition(pt1);
		Thread.sleep(2000);
		System.out.println("after reposition");
		System.out.println(pt1.getX());
		System.out.println(pt1.getY());
	
		driver.close();
		
	}

}
