package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		 Properties obj = new Properties();
		 //obj.setProperty("browser", "chrome");
		 //obj.setProperty("url", "'http://rmgtestingserver/domain/Hospital_Management_System/'");
		 //obj.setProperty("UserName", "admin");
		 //obj.setProperty("password", "Test@12345");
		 // FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\CommomData.properties");
		// obj.store(fos, "Write data");
		 
		FileInputStream  fis=new FileInputStream(".\\src\\\\test\\\\resources\\\\CommomData.properties");
		obj.load(fis);
		String Browser=obj.getProperty("browser");
		String URL=obj.getProperty("url");
		String UserName=obj.getProperty("username");
		String Password=obj.getProperty("password");
		 
		
		

	}

}
