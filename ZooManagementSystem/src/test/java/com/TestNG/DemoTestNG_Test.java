package com.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoTestNG_Test {
	
	@Test
	@AfterMethod
	public void config_BS3() {
		System.out.println("-----TS-1-----");
	}
	@Test
	@AfterMethod
	public void config_BS4() {
		System.out.println("-----TS-2-----");
	}

}
