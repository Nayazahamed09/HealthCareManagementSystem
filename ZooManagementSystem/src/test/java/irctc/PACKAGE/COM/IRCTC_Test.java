package irctc.PACKAGE.COM;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class IRCTC_Test{

	public static void main(String [] args) throws InterruptedException
	{

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		ChromeOptions Options =new ChromeOptions();
		Options.addArguments("--disable-notifications");
			Set<String> WindowsID = driver.getWindowHandles();
	Iterator<String>Window=WindowsID.iterator();
	while(Window.hasNext())
	{
		String Id=Window.next();
		String WinTitle=driver.switchTo().window(Id).getTitle();
		System.out.println(WinTitle);
		if(WinTitle.contains("Book Bus Ticket")) 
		{
			
			break;
		}
	
	}
	
	driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
	Thread.sleep(5000);	
	driver.findElement(By.xpath("//input[@name='departFrom']")).sendKeys("Bangalore");
	Thread.sleep(5000);	
	driver.findElement(By.xpath("//input[@name='goingTo']")).sendKeys("Chennai");
	Thread.sleep(5000);	
	driver.findElement(By.id("departDate")).click();
	Thread.sleep(5000);	
	driver.findElement(By.xpath("//span[text()='January']/ancestor::div[@id='ui-datepicker-div']/descendant::table[@class='ui-datepicker-calendar']/descendant::td[27]")).click();
	driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
	driver.findElement(By.xpath("//label[text()='After 6 pm']")).click();
	
		

	}
	
	
	

}
