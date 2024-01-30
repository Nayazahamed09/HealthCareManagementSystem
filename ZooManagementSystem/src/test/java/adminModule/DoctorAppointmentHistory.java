package adminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import comGenericUtilities.BaseClass;
import comGenericUtilities.ExcelUtils;
import comGenericUtilities.Fileutils;
import comGenericUtilities.WebdriverUtils;
import comGenericUtilities.javaUtils;

public class DoctorAppointmentHistory extends BaseClass{
	@Test(groups = "System")

	public void DoctorAppointmentHistory  () throws Throwable {
		
		//get commom data from Property File
		
		 Fileutils propFileUtils = new Fileutils();
		 ExcelUtils exceldata = new ExcelUtils();
		 javaUtils javaPac = new javaUtils();	
		 WebdriverUtils webdriver = new WebdriverUtils();
		 
		String Browser= propFileUtils.readdata("browser");
		String URL=propFileUtils.readdata("url");
		String PASSWORD=propFileUtils.readdata("password");
		String USERNAME=propFileUtils.readdata("UserName");
		
		
		/*FileInputStream Fis= new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
		Properties Ob= new Properties();
		Ob.load(Fis);
		String URL=Ob.getProperty("url");
		String USERNAME=Ob.getProperty("UserName");
		String PASSWORD=Ob.getProperty("password");*/
		
		//get Test data From Excel sheet
		
		/*FileInputStream FI =new FileInputStream(".\\src\\test\\resources\\Testdata2.xlsx");
		Workbook wb=WorkbookFactory.create(FI);
		Sheet Sh=wb.getSheet("Admin");
		int Rowcount=Sh.getLastRowNum();*/
		
		exceldata.readDataFromExcel("Admin", 0, 0);
				
		String Key=exceldata.readDataFromExcel("Admin", 0, 0);
		String VALUE=exceldata.readDataFromExcel("Admin", 0, 1);
		
		//Launch the browser
		
		WebDriver driver=new ChromeDriver();
		
		// maximize the browser
		webdriver.maxmizetheBrowser(driver);
		
		
		//Launch the URL
		
		driver.get(URL);
		// Use pageLoadTimeout
		
		webdriver.pageLoadTimeout(driver, 15);
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(int i = 0; i<=4; i++)
		{
		js.executeScript("window.scrollBy(0,40)");
		Thread.sleep(1000);
		}
		
		//login to Application
		
		driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();		
		//click on doctor Module in the Application
		
		WebElement docButton = driver.findElement(By.xpath("//span[text()=' Doctors ']"));
				docButton.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[.=' Add Doctor']")).click();
		
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
		
	
		//enter all the details
		
		
		exceldata.hashMapData("Admin", 0, driver);
		
	/*	
	 HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i<=Rowcount; i++)
		{
			String key = Sh.getRow(i).getCell(0).getStringCellValue();
			String value = Sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		

	}
		for(Entry<String, String> set:map.entrySet())
		{
			javaUtils javapac=new javaUtils();
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			
		}*/
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.quit();

}
	
}
