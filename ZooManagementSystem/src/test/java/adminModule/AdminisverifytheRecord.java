package adminModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import comGenericUtilities.ExcelUtils;
import comGenericUtilities.Fileutils;
import comGenericUtilities.WebdriverUtils;
import comGenericUtilities.javaUtils;

public class AdminisverifytheRecord {

	public static void main(String[] args) throws Throwable {
		// Get common data from FileUtils
		
		Fileutils FU=new Fileutils();
		javaUtils JU=new javaUtils();
		ExcelUtils EU=new ExcelUtils();
		WebdriverUtils WU=new WebdriverUtils();
		
		String URL=FU.readdata("url");
		String USERNAME=FU.readdata("UserName");
		String PASSWORD=FU.readdata("password");
		
		// Launch the browser
		
		WebDriver driver=new ChromeDriver();
		
		// maximize the browser
		
		WU.maxmizetheBrowser(driver);
		
		//launch the URL
		
		driver.get(URL);
		
		// Apply page load timeout condition
		
		WU.pageLoadTimeout(driver, 25);
JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(int i = 0; i<=4; i++)
		{
		js.executeScript("window.scrollBy(0,40)");
		Thread.sleep(1000);
		}
		
		//login to application
		
		 driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		 driver.findElement(By.name("username")).sendKeys( USERNAME);
		  
		  driver.findElement(By.name("password")).sendKeys(PASSWORD);
		  
		  driver.findElement(By.name("submit")).click();
		 
		 // enter into report link
		 
		 driver.findElement(By.xpath("//span[text()=' Reports ']")).click();
		 
		 // click on between dates in report link
		 
	WebElement element = driver.findElement(By.xpath("//span[text()='B/w dates reports ']"));
	
	Actions A= new Actions(driver);
	A.click(element).perform();
	
	
		 
		 driver.findElement(By.id("submit")).click();
		
		
		
		
		

	}

}
