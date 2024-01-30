package com.TestNG;

import org.testng.annotations.Test;

public class ExecuteDataProviders_Test {
	
	
	
	@Test(dataProviderClass = PracticeTestNG_Test.class,dataProvider = "excuteTest")
	public void initiationTest( String Fruit, String Place)
	{
		System.out.println(Fruit+"----->"+Place);
	}

	@Test(dataProviderClass = ReaddatafromExcel_Test.class,dataProvider = "readDatafromExcel")
	public void executethedatafromExcel(String Identity,String place) {
		
		System.out.println(Identity+"---------->"+place);
		
	}
	@Test(dataProviderClass =PracticeTestNG_Test.class,dataProvider = "execute" )
	public void executetheMethod(String Identity, String Place)
	{
		System.out.println(Identity+"---------->"+Place);
	}
}
