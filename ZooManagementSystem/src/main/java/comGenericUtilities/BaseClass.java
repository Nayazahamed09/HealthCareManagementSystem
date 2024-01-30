package comGenericUtilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public DataBaseUtils Db=new DataBaseUtils();
	public Fileutils Fu = new Fileutils();
	public ExcelUtils Eu= new ExcelUtils();
	public WebdriverUtils Wu= new WebdriverUtils();
	public javaUtils ju= new javaUtils();
	public static WebDriver driver;
	public  static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws Throwable
	{
		Db.getConnectiontoDatabase();
		System.out.println("----Connected to Database-----");
		Reporter.log("Connected to Database",true);
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Throwable
	{
		//launch the browser
		driver=new ChromeDriver();
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			System.out.println("----Invalid Browser Name----");
//		}
		
	
		
		//sdriver=driver;
		
		// maximize the Browser
		Wu.maxmizetheBrowser(driver);	
		
		
		
		//Launch the Application
		driver.get("https://www.irctc.co.in/");
//		String URL=Fu.readdata("url");
//		driver.get(URL);
		Wu.Implicitlywait(driver, 20);
		System.out.println("----Browser is launched-----");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		//Close the Application
		
		driver.quit();
		System.out.println("----Browser is closed-----");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() throws Throwable
	{
		Db.closeDB();
		System.out.println("----DataBase is closed-----"); 
		
	}
	

}
