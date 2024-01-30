package adminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import comGenericUtilities.BaseClass;
import comGenericUtilities.javaUtils;

public class AdminToverifyPatientDetails  extends BaseClass{
	@Test

	public void AdminToverifyPatientDetails() throws Throwable {
		//GET COMMON DATA FROM PROPERTY FILE
		FileInputStream Fis=new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
		
		Properties ob = new Properties();
		ob.load(Fis);
		
		String URL=ob.getProperty("url");
		String USERNAME=ob.getProperty("UserName");
		String PASSWORD=ob.getProperty("password");
		
		String Username=ob.getProperty("User");
		
		String Pass=ob.getProperty("Pass");
		
		//Get the Test data from Excel sheet
		
		FileInputStream FI=new FileInputStream(".\\src\\test\\resources\\Testdata2.xlsx");
		Workbook wb=WorkbookFactory.create(FI);
		  Sheet sh = wb.getSheet("PATIENT");
		  
		  int Rowcount=sh.getLastRowNum();
		  int LastCell=sh.getRow(0).getLastCellNum();
		  String key=wb.getSheet("PATIENT").getRow(1).getCell(0).getStringCellValue();
		  String Value=wb.getSheet("PATIENT").getRow(1).getCell(1).getStringCellValue();
		  
		  // Launch the Browser
		  
		  WebDriver driver=new ChromeDriver();
		  
		  //maximize the browser
		  
		  driver.manage().window().maximize();
		  
		  //launch the URL
		  
		  driver.get(URL);
		  
		  // Use the IMPLICIT WAIT
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		  Thread.sleep(4000);
		  
		  // Use javaScript Executor to scroll the window to view port area
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  for(int i=0;i<=4;i++) {
		  js.executeScript("window.scrollBy(0,40)");
		  Thread.sleep(1000);
		  }
		  
		  //login to application
		  
		  driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		  
		  driver.findElement(By.name("username")).sendKeys( USERNAME);
		  
		  driver.findElement(By.name("password")).sendKeys(PASSWORD);
		  
		  driver.findElement(By.name("submit")).click();
		  
		  //click on Admin logout button
		  
		  driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		  
		  //Scroll down the window
		  
		  for(int i=0;i<=4;i++) {
			  js.executeScript("window.scrollBy(0,40)");
			  }
		  
		  //login as doctor module
		  
		  driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();
		  
		  
		  driver.findElement(By.name("username")).sendKeys( Username);
		  driver.findElement(By.name("password")).sendKeys(Pass);
		  driver.findElement(By.name("submit")).click();
		  
		  
		  //click on patient button
		  
		  driver.findElement(By.xpath(" //span[text()=' Patients ']")).click();
		  driver.findElement(By.xpath(" //span[text()=' Add Patient']")).click();
		  
		  // add the patient details in the add patient page
		  
		  HashMap<String, String>map=new HashMap<String, String>();
		  
		  
		  for(int i=0; i<=Rowcount; i++)
			{
				String k = sh.getRow(i).getCell(0).getStringCellValue();
				String value = sh.getRow(i).getCell(1).getStringCellValue();
				map.put(key, value);
				}
		  
	
		  
			for(Entry<String, String> set:map.entrySet())
			{
				javaUtils JU=new javaUtils();
				//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
				
				Thread.sleep(4000);
				if(set.getKey().contains("Vishnu"))
				{
					driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+JU.getRandomNo());
				}
				else
				{
					driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
				}
				
			}
			
			//click on add button
			
			driver.findElement(By.name("submit")).click();
			
			//click on manage patient
			 driver.findElement(By.xpath(" //span[text()=' Patients ']")).click();
			
			driver.findElement(By.xpath(" //span[text()=' Manage Patient ']")).click();
			
			List<WebElement> patientList = driver.findElements(By.xpath("//tbody/tr[1]/td[2]"));
			for ( WebElement List : patientList) {
				
				String Expspecl = "Nayaz Ahmad";
				String Actspecl = List.getText();
				if(Expspecl.equals(Actspecl))
				{
					System.out.println("DATA HAS BEEN ADDED IN THE LIST");
				}
				else
				{
					System.out.println("Data is mismatched with actual list");
				}
				
			}
			
			
			
		
		  
		  
		  
		  
		
		

	}

}
