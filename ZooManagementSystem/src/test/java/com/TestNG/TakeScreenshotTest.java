package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comGenericUtilities.BaseClass;

@Listeners(comGenericUtilities.Imp.class)

public class TakeScreenshotTest extends BaseClass{

	
	@Test
	public void screen()
	{
		System.out.println("-- print --");
		Assert.fail();
	}
}
