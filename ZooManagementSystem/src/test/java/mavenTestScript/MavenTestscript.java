package mavenTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenTestscript {
	
	@Test
	public void execute()
	{
	String Browser=	System.getProperty("browser");
	String URL	=System.getProperty("url");
	String USERNAME=System.getProperty("UserName");
	String Password=System.getProperty("Password");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.get(URL);
	driver.findElement(By.xpath("//span[text()='Hospital Management System']/ancestor::div[@class='place-card-container1']//button[@class='outline-button-button button']/span[text()='Open Application']")).click();
	driver.findElement(By.xpath("//h3[text()='Admin Login']/ancestor::div[@class='text list_1_of_2']/descendant::a[text()='Click Here']   ")).click();
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(Password);
	driver.findElement(By.name("submit")).click()
;	
	
		
	}
	
	
	

}
