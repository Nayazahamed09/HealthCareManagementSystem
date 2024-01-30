package comGenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationclass implements ITestListener {
	
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		//Test Script Execution Starts From Here
		
		String MethodName=result.getMethod().getMethodName();
		test=reports.createTest(MethodName);
		Reporter.log(MethodName+"Execution Started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	
	{
		String MethodName=result.getMethod().getMethodName();
		javaUtils j = new javaUtils();
		WebDriver driver;
		String ScreenshotName = result.getMethod().getMethodName();
		 TakesScreenshot Ts=(TakesScreenshot)BaseClass.driver;
		   File SRC=Ts.getScreenshotAs(OutputType.FILE);
		   String path=".\\screenshot\\"+ScreenshotName+j.getSystemdateFormat()+".png";
		   
		   File DST=new File(path);
		  String res= DST.getAbsolutePath();
		   try {
			FileUtils.copyFile(SRC, DST);
			test.addScreenCaptureFromPath( res);
			test.log(Status.FAIL, MethodName+"Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(MethodName+"-----> Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"-----> Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		
		//configure Report
		ExtentSparkReporter htmlReport= new ExtentSparkReporter(".\\Extent Report\\Report.html");
		htmlReport.config().setDocumentTitle("HEALTH_MANAGEMENT_SYSTEM");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Health Management");
		
		 reports=new ExtentReports();
		 reports.attachReporter(htmlReport);
		 reports.setSystemInfo("BASE PLATFORM", "OS");
		 reports.setSystemInfo("BASE BROWSER","chrome" );
		 reports.setSystemInfo("BASE-URL","http://rmgtestingserver/domain/Hospital_Management_System/");
		 reports.setSystemInfo("ReporterName","NayazAhmad" );
			}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
