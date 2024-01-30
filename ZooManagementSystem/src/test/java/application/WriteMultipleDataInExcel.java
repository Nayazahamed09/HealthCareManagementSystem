package application;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataInExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream FIS=new FileInputStream(".\\src\\test\\resources\\Testdata2.xlsx");
		  Workbook wb = WorkbookFactory.create(FIS);
		  Sheet SH = wb.getSheet("Sheet1");

	}

	
}
