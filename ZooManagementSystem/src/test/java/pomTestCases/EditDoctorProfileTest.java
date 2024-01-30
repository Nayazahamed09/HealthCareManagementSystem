package pomTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.DoctorLoginpage;
import com.ObjectRepo.DomainPage;

import comGenericUtilities.BaseClass;
import comGenericUtilities.ExcelUtils;
import comGenericUtilities.Fileutils;
import comGenericUtilities.WebdriverUtils;
import comGenericUtilities.javaUtils;

@Listeners(comGenericUtilities.ListenerImplementationclass.class)
public class EditDoctorProfileTest  extends BaseClass{
	
	
// Create the object for General Utility classes
	@Test
	//(retryAnalyzer = comGenericUtilities.RetryImplementation.class)
	
	public  void EditDoctorProfileTest() throws Throwable {
		Fileutils Fu=new Fileutils();
		ExcelUtils Eu=new ExcelUtils();
		javaUtils ju=new javaUtils();
		WebdriverUtils wu=new WebdriverUtils();
		
		//load the data
		
		String Browser= Fu.readdata("browser");
		String URL=Fu.readdata("url");
		String PASSWORD=Fu.readdata("Pass");
		String USERNAME=Fu.readdata("User");
		
		// Launch the browser
		
	 //WebDriver driver=new ChromeDriver();
	 
	 
	 // maximize the browser
	 
	// driver.manage().window().maximize();
	 
	 //launch the URL
	 
	 driver.get(URL);
	 
	 Assert.fail();
	 // Use Java Script Executor
	 
	 JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(int i = 0; i<=4; i++)
		{
		js.executeScript("window.scrollBy(0,40)");
		
		}
		
		DomainPage Dp=new DomainPage(driver);
		
		Dp.getDoctorClickLink().click();
		
		
		
		//Enter  login Details in Doctor Page
		
		DoctorLoginpage DL= new DoctorLoginpage(driver);
		
		DL.getAdminUserName();
		DL.getAdminPassword();
		DL.getAdminLogin();
		
		DL.logintoAdminModule(USERNAME, PASSWORD);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Update Profile')]")).click();
		
		
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
	
		Eu.readDataFromExcel("Sheet4", 0, 0);
		Eu.hashMapData("Sheet4", 0, driver);

		
		driver.findElement(By.name("submit")).click();
		
		driver.quit();
	
	
	
	
}
}
