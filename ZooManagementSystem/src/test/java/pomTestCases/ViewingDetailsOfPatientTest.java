package pomTestCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepo.AdminLoginPage;
import com.ObjectRepo.AdminViewPatientPage;
import com.ObjectRepo.DomainPage;

import comGenericUtilities.BaseClass;
import comGenericUtilities.ExcelUtils;
import comGenericUtilities.Fileutils;
import comGenericUtilities.WebdriverUtils;
import comGenericUtilities.javaUtils;

public class ViewingDetailsOfPatientTest extends BaseClass {

	// Create the object for General Utility classes
	@Test(groups = "smoke")

	public void ViewingDetailsOfPatientTest() throws Throwable {
		Fileutils Fu = new Fileutils();
		ExcelUtils Eu = new ExcelUtils();
		javaUtils ju = new javaUtils();
		WebdriverUtils wu = new WebdriverUtils();

		// LOAD THE DATA FROM PROPERTYFILES

		String UserName = Fu.readdata("UserName");
		String Password = Fu.readdata("password");
		String URL = Fu.readdata("url");
		String Browser = Fu.readdata("browser");

		// Launch the browser

		WebDriver driver = new ChromeDriver();

		// launch the URL

		driver.get(URL);

		// Scroll the window (By java script Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i <= 4; i++) {
			js.executeScript("window.scrollBy(0,40)");
		}

		DomainPage D = new DomainPage(driver);
		D.getAdminClickHereLink().click();

		AdminLoginPage AL = new AdminLoginPage(driver);
		AL.getAdminUserName();
		AL.getAdminPassword();
		AL.getAdminLogin();
		AL.logintoAdminModule(UserName, Password);
		AdminViewPatientPage AVP = new AdminViewPatientPage(driver);
		Thread.sleep(4000);
		AVP.getPatientLink();
		AVP.getAdminPatientLink();
		WebElement Manage = AVP.getManagePatientLink();
		Thread.sleep(5000);
		Actions A= new Actions(driver);
		A.click(Manage).perform();
	
		/*Actions A = new Actions(driver);
		A.click(Manage);*/
		List<WebElement> Details = driver.findElements(By.xpath("//td[@class='hidden-xs']"));

		boolean Flag = false;
		for (WebElement Detail : Details) {
			
			
			Assert.assertEquals(Detail.getText(),"John");
			System.out.println("Data has been Verified");
			
			Assert.assertNotEquals(Detail.getText(),"John");
			System.out.println("Data has  not been Verified");
			
			

			/*if (Detail.getText().contains("John")) {
				Flag = true;
				System.out.println("Data has been Verified");
				break;
			}

		}
	
		if (Flag == false) {
			System.out.println("Data has not been  Verified in the list");
		}*/

		driver.quit();
	}
}
}
