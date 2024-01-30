package TestNGclassesSuiteExecution;

import org.testng.annotations.Test;

import comGenericUtilities.BaseClass;

public class ExecutionTest1  extends BaseClass{
	@Test
	public void Execute()
	{
		System.out.println("The Method has Eexcuted");
	}
	@Test
	public void Login()
	{
		System.out.println("The Login Application has Eexcuted");
	} 

}
