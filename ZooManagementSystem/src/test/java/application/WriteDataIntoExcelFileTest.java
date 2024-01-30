package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFileTest {
	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
	          Row row = sh.createRow(2);
	          row.createCell(2).setCellValue("TestYantra");
	          
	          FileOutputStream FO = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	          wb.write(FO);
	          wb.close();
	}
}

