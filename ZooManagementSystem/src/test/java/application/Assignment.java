package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Assignment {

	public static void main(String[] args) throws Throwable {
		FileInputStream FIS=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(FIS);
		Sheet sh =wb.getSheet("Sheet2");
		 
		int Rowcount=sh.getLastRowNum();
		int cellcount=sh.getRow(0).getLastCellNum();
		
		
		for(int i=0;i<=Rowcount;i++)
		{
			String res=sh.getRow(i).getCell(0).getStringCellValue();
			if(res.equals("Samsung"))
			{
				double Res=sh.getRow(i).getCell(1).getNumericCellValue();
				System.out.println(res+"----------->");
				System.out.println(Res+"----------->");
			}
		}
		  

	}

	
	

}
