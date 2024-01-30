package com.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExecutionClass_Test {
	
	@Test
	@AfterMethod
	public void config_BS3() {
		System.out.println("-----TS-6-----");
	}
	@Test
	@AfterMethod
	public void config_BS4() {
		System.out.println("-----TS-7-----");
	}
	@Test
	@AfterMethod
	public void config_BS5() {
		System.out.println("-----TS-8-----");
	}

}
