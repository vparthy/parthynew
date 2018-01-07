package com.parthy.util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.parthy.base.TestBase;

public class TestUtils extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TEST_DATA_PATH = "./src/test/resources/data/FreeCRMtestdata.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetname){
		
		try {
			FileInputStream file = new FileInputStream(TEST_DATA_PATH);
			try {
				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		int row1 = sheet.getFirstRowNum();
		int col1 = sheet.getRow(0).getFirstCellNum();
		Object[][] data = new Object[row][col];
		
		System.out.println("1stRow: " + row1 + " 1stCol: " + col1);
		System.out.println("LastRow: " + row + " LastCol: " + col);
		
		for(int i=0; i<row; i++){
			for(int k=0; k<col; k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenShot() throws IOException{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currdir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currdir + "/screenshots/" + System.currentTimeMillis()+".png"));
	}
	
}
