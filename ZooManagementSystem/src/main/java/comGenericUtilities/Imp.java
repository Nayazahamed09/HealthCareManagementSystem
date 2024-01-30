package comGenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Imp implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		TakesScreenshot tss = (TakesScreenshot) BaseClass.driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(".//screenshot//"+MethodName+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
