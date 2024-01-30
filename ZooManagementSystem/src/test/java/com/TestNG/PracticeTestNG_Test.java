package com.TestNG;


import org.testng.annotations.DataProvider;

import comGenericUtilities.ExcelUtils;

public class PracticeTestNG_Test {
	
	@DataProvider
	public Object[][] excuteTestNG()
	{
		Object [][]obj=new Object[3][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Chennai";
		obj[1][0]="Hyderabad";
		obj[1][1]="Vishakapatnam";
		obj[2][0]="Vijayawada";
		obj[2][1]="Srisailam";
		return obj;
	}
	

	@DataProvider
	public Object[][] excuteTest()
	{
		Object [][]obj=new Object[3][2];
		obj[0][0]="APPLE";
		obj[0][1]="Kashmir";
		obj[1][0]="Mango";
		obj[1][1]="AndhraPradesh";
		obj[2][0]="TEA";
		obj[2][1]="CHIKMALGUR";
		return obj;
	}
	/*
	 * 
	 */
	@DataProvider
	public Object[][]execute() throws Throwable
	{
		ExcelUtils eLib=new ExcelUtils();
		Object[][] s = eLib.readMultiplesetofDatafromExcel("Sheet2");
		return s;
	}

}
