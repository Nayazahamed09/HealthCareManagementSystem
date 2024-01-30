package com.Assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert_Test {
	
	@Test
	public void executeHardAssert() {
		
		//Launch the Browser
		String Expected="Hospital_Management_System";
		WebDriver driver=new EdgeDriver();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), Expected, "Expected Condition is not Matching");
	}
	
	@Test
	public void soft()
	
	
	{
		int X=0;
		SoftAssert SA=new SoftAssert();
		System.out.println("----Line 1----");
		System.out.println("----Line 2----");
		
		SA.assertNull(X);
		
		System.out.println("----Line 3----");
		System.out.println("----Line 4----");
		SA.assertAll();
	}

}
