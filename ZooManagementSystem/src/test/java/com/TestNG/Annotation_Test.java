package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation_Test {
	
	@BeforeSuite
	public void config_BS() {
		System.out.println("-----Connect to DB-----");
	}
	@BeforeTest
	public void config_BTest() {
		System.out.println("-----Before test-----");
	}
	@BeforeClass
	public void config_Class() {
		System.out.println("-----Before Class-----");
	}
	@BeforeMethod
	public void config_BS5() {
		System.out.println("-----Connect to DB 5-----");
	}
	@BeforeMethod
	public void config_Method() {
		System.out.println("-----Before Method-----");
	}
	@Test
	public void config_Test() {
		System.out.println("-----Execution is  in progress-----");
	}
	@AfterMethod
	public void config_AMethod() {
		System.out.println("-----After Method-----");
		
	}
	
	@AfterMethod
	public void config_BS3() {
		System.out.println("-----Connect to DB 2-----");
	}

	@AfterMethod
	public void config_BS4() {
		System.out.println("-----Connect to DB 3-----");
	}
	@AfterClass
	public void config_BS2() {
		System.out.println("-----Afterclass-----");
	}
	@AfterClass
	public void config_AClass() {
		System.out.println("-----After class-----");
	}
	@AfterTest
	public void config_Atest() {
		System.out.println("-----After Test-----");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("-----Close the DB-----");
	}

}
