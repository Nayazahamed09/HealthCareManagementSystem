package comGenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	
	public String readDataFromExcel(String SheetName, int rowNo,int cellno) throws Throwable {
		
		FileInputStream Fis=new FileInputStream(IpathConstants.ExcelData);
		Workbook wb=WorkbookFactory.create(Fis);
		Sheet Sh=wb.getSheet(SheetName);
		String Value=wb.getSheet(SheetName).getRow(rowNo).getCell(cellno).getStringCellValue();
		return Value;
		
	}
	
	public int getlastRow(String SheetName) throws Throwable, IOException
	{
		FileInputStream Fis=new FileInputStream(IpathConstants.ExcelData);
		Workbook wb=WorkbookFactory.create(Fis);
		Sheet Sh=wb.getSheet(SheetName);
		int Rowcount=Sh.getLastRowNum();
		return Rowcount;
	}
	
	public HashMap<String, String> hashMapData(String Sheetname,int cell,WebDriver driver) throws EncryptedDocumentException, IOException
	{
		FileInputStream Fis=new FileInputStream(IpathConstants.ExcelData);
		Workbook wb=WorkbookFactory.create(Fis);
		Sheet S=wb.getSheet(Sheetname);
		int Lastrow=S.getLastRowNum();
		
		HashMap<String, String>map=new HashMap<String, String>(); //empty map
		
		for(int i=0;i<=Lastrow;i++)
		{
			String key=S.getRow(i).getCell(cell).getStringCellValue();
			String Value=S.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, Value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			javaUtils javapac=new javaUtils();
			driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+javapac.getRandomNo());
				}
			return map;
	}
	
	public void WritedataintoExcel(String Sheetname, int Row, int cell, String Data) throws Throwable
	{
		FileInputStream Fis=new FileInputStream(IpathConstants.ExcelData);
		Workbook wb=WorkbookFactory.create(Fis);
		Sheet S=wb.getSheet(Sheetname);
		S.createRow(Row).createCell(cell).setCellValue(Data);
		FileOutputStream FOS=new FileOutputStream(IpathConstants.ExcelData);
		wb.write(FOS);
		wb.close();
		
		
	}
	
	public Object[][] readMultiplesetofDatafromExcel(String SheetName) throws Throwable
	{
		FileInputStream FI = new FileInputStream(IpathConstants.ExcelData);
		Workbook wb = WorkbookFactory.create(FI);
		Sheet sh = wb.getSheet(SheetName);
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


