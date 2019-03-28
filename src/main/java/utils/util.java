package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.media.sound.InvalidFormatException;

import bases.base;

public class util extends base {
public util() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
static String TESTDATA_SHEET_PATH="C:\\Users\\kris\\Downloads\\workspace\\crmpro\\src\\main\\java\\testdata\\excel.xlsx";

static XSSFWorkbook book;
static XSSFSheet sheet;
static FileInputStream fs;

public void switchtoframe() {
	driver.switchTo().frame("mainpanel");
	
}

//public Object[][] sheetdata(String sheetName){
//	
//	try {
//		fs=new FileInputStream(TESTDATA_SHEET_PATH);
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	try {
//		wb=WorkbookFactory.create(fs);
//	} catch (EncryptedDocumentException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	s1=wb.getSheet(sheetName);
//	
//	Object[][] data=new Object[s1.getLastRowNum()][s1.getRow(0).getLastCellNum()];
//	for(int i=0;i<s1.getLastRowNum();i++) {
//		for(int j=0;j<s1.getRow(0).getLastCellNum();j++) {
//		data[i][j]=s1.getRow(i+1).getCell(j).toString();
//		}
//	}
//	return data;
//}

public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		try {
			book = (XSSFWorkbook) WorkbookFactory.create(file);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}

}
