package KsrtcPackage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinkTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://indianarmy.nic.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	List<WebElement>	AllLinks=driver.findElements(By.xpath("//a"));
 
	int statuscode = 0;
	for(WebElement Link:AllLinks)
	{
		String EachLink=Link.getAttribute("href");
		URL url=new URL(EachLink);
		try
		{
			HttpsURLConnection httpconn=(HttpsURLConnection)url.openConnection();
			 statuscode=httpconn.getResponseCode();
			if(statuscode>=400)
			{
				System.out.println(EachLink+" ----->"+statuscode);
			}
		}
		catch(IOException e)
		{
			System.out.println(EachLink+" --->"+statuscode);
		}
	}
	}

}
