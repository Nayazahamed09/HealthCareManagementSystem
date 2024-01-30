package KsrtcPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KsrtcCalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.ksrtc.in/");
driver.findElement(By.id("txtJourneyDate")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//a[text()=\"18\"]"));
driver.quit()
;	}

}
