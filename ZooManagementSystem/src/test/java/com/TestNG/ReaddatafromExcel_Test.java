package com.TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import comGenericUtilities.IpathConstants;

public class ReaddatafromExcel_Test {
	
	@DataProvider
	public Object[][] readDatafromExcel() throws Throwable
	{
		FileInputStream FI = new FileInputStream(IpathConstants.ExcelData);
		Workbook wb = WorkbookFactory.create(FI);
		Sheet sh = wb.getSheet("Sheet2");
		int Rowcount = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[Rowcount][lastCell];
		for(int i=0;i<Rowcount;i++)//row
		{
			for(int j=0;j<lastCell;j++)//column
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

}
