package KsrtcPackage;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']"));
		for(;;)
		{
		/*	try
			{
				driver.findElement(By.xpath(""));
			} */
		}
			
			

	}
}

