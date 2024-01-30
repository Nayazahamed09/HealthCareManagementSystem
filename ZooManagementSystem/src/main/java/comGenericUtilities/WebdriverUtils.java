package comGenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;


import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils  {
	
	public void maxmizetheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizetheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	public void Implicitlywait(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public void pageLoadTimeout(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	public void waitAlertisPresent(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitelementtobeSelected(WebDriver driver,int sec, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeSelected(element));
				
	}
	
	public void waitElementtobeClickable(WebDriver driver, int sec,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waittexttobePresentInElement(WebDriver driver, int sec, WebElement element,String Text)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.textToBePresentInElement(element,Text ));
	}
	public void waitinvisibilityofElement(WebDriver driver, int sec, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void dropDownSelectByIndex(WebElement element,int index)
	{
		Select S=new Select(element);
		S.selectByIndex(index);
	}
	public void dropdownSelectByValue(WebElement element,String Value)
	{
		Select S=new Select(element);
		S.selectByValue(Value);
	}
	public void dropdownSelectByVisibleText(WebElement ele , String Text)
	{
		Select S=new Select(ele); 
		S.selectByVisibleText(Text);
	}
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions A=new Actions(driver);
		A.moveToElement(element).perform();
	}
	public void mousehoverMovetoElement(WebDriver driver, WebElement element ,int X,int Y)
	{
		Actions A=new Actions(driver);
		A.moveToElement(element, X, Y).perform();
	}
   public void dragandDrop(WebDriver driver, WebElement src,WebElement Target)
   {
	   Actions A=new Actions(driver);
	   A.dragAndDrop(src, Target).perform();
   }
   public void doubleclickAction(WebDriver driver, WebElement element)
   {
	   Actions A=new Actions(driver);
	   A.doubleClick(element).perform();
   }
   public void doubleclickAction(WebDriver driver)
   {
	   Actions A=new Actions(driver);
	   	A.doubleClick().perform();
   }
   public void rightClick(WebDriver driver)
   {
	   Actions A=new Actions(driver);
	   A.contextClick().perform();
   }
   public void rightClickWebElement(WebDriver driver, WebElement element )
   {
	   Actions A=new Actions(driver);
	   A.contextClick(element).perform();
   }
   public void enterKeyPress(WebDriver driver,WebElement element )
   {
	   Actions A=new Actions(driver);
	   A.sendKeys(Keys.ENTER).perform();
   }
   public void enterKeyRobotclass() throws Throwable {
	   Robot R=new Robot();
	   R.keyPress(KeyEvent.VK_ENTER);
   }
   public void enterReleaseRobotclass() throws Throwable
   {
	   Robot R=new Robot();
	   R.keyRelease(KeyEvent.VK_ENTER);
   }
   public void switchtoFrame(WebDriver driver,int index )
   {
	   driver.switchTo().frame(index);
   }
   public void switchtoFrame(WebDriver driver,String nameOrld)
   {
	   driver.switchTo().frame(nameOrld);
   }
   public void switchtoFrame(WebDriver driver,WebElement address)
   {
	   driver.switchTo().frame(address);
   }
   public void acceptAlert(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   public void cancelAlert(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   public void switchtowindows(WebDriver driver, String partialWinTitle)
   {
	   //Step1:use get Window handles to capture all the windows id's 
	   Set<String>windows=driver.getWindowHandles();
	   
	   //Step2:iterate through the windows
	   Iterator<String>it=windows.iterator();
	   
	   //Step3:check whether there is window
	   
	   while(it.hasNext())
	   {
		   //Step4: capture the current window
		   String WindID=it.next();
		   
		   //step 5: switch to current window and capture the window id
		   String CurrentWindowTitle=driver.switchTo().window(WindID).getTitle();
		   
		   //6: check whether the current window is expected
		   if(CurrentWindowTitle.contains(partialWinTitle))
		   {
			   break;
		   }
	   }
   }
   public static void getScreenShot(WebDriver driver,String ScreenshotName) throws Throwable
   {
	   javaUtils jLib=new javaUtils();
	   TakesScreenshot Ts=(TakesScreenshot)driver;
	   File SRC=Ts.getScreenshotAs(OutputType.FILE);
	   String path=".\\screenshot\\"+ScreenshotName+jLib.getSystemdateFormat()+".png";
	   File DST=new File(path);
	   FileUtils.copyFile(SRC, DST);
	   
	   
   }
   public static void getSwitchtoWindow(WebDriver driver ,String Name)
   {
	   driver.switchTo().window(Name);
   }
   
  
}
