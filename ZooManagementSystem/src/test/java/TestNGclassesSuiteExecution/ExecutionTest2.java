package TestNGclassesSuiteExecution;

import org.testng.annotations.Test;

import comGenericUtilities.BaseClass;

public class ExecutionTest2 extends BaseClass {
	
	@Test
	public void excuteMethod()
	{
		System.out.println("Browser is launched");
	}
	@Test
	public void Browser()
	{
		System.out.println("Browser is loading");

	}
	@Test
	public void BrowserFail()
	{
		System.out.println("Browser is executing");

	}

}
