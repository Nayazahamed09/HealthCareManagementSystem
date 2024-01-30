package adminModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import comGenericUtilities.ExcelUtils;
import comGenericUtilities.Fileutils;
import comGenericUtilities.WebdriverUtils;
import comGenericUtilities.javaUtils;

public class PatientisabletoseetheAppointment {

	public static void main(String[] args) throws Throwable {
		// Get common data from FileUtils
		
				Fileutils FU=new Fileutils();
				javaUtils JU=new javaUtils();
				ExcelUtils EU=new ExcelUtils();
				WebdriverUtils WU=new WebdriverUtils();
				
				String URL=FU.readdata("url");
				String USERNAME=FU.readdata("PatientUserName");
				String PASSWORD=FU.readdata("PatientPassword");
				
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
				 driver.findElement(By.xpath("(//a[text()='Click Here'])[1]")).click();
				 driver.findElement(By.name("username")).sendKeys( USERNAME);
				  
				  driver.findElement(By.name("password")).sendKeys(PASSWORD);
				  
				  driver.findElement(By.name("submit")).click();
				  
				  //click on Book APPOINTMENT
				  
				driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
				
				WebElement DoctorSpecialization = driver.findElement(By.name("Doctorspecialization"));
				
				Select SELECT=new Select(DoctorSpecialization);
				List<WebElement> allOptions = SELECT.getOptions();
				for ( WebElement webElement : allOptions) {
					
					String Expspecl = "Ayurveda";
					String Actspecl = webElement.getText();
					if(Expspecl.equals(Actspecl))
					{
						webElement.click();
					}
					
				}
				driver.findElement(By.xpath("//option[text()='Select Doctor']")).click();
				WebElement element = driver.findElement(By.xpath("appdate"));
				
				Actions A=new Actions(driver);
				
				A.moveToElement(element, -5, 3).click().perform();
				
				WebElement element1 = driver.findElement(By.id("timepicker1"));
				
				A.moveToElement(element1, -10, -15).click()
.perform();				
	}

}
