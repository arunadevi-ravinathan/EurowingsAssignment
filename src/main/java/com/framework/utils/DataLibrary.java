package com.framework.utils;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary {
	static XSSFRow row;
	@SuppressWarnings("incomplete-switch")
	public static Object[][] readExcelData(String excelfileName) {
		XSSFWorkbook wbook;
		Object[][] data = null ;
		
		try {
			wbook = new XSSFWorkbook("./data/"+excelfileName+".xlsx");
		      XSSFSheet spreadsheet = wbook.getSheetAt(0);
		      Iterator < Row >  rowIterator = spreadsheet.iterator();
		      int rowCount = spreadsheet.getLastRowNum();
		      int colCount = spreadsheet.getRow(0).getLastCellNum();
		      data = new Object[rowCount][colCount];
		      if(rowCount > 0) {
		    	  for (int i = 1; i <= rowCount; i++) {
						for (int j = 0; j < colCount; j++) {
							data[i-1][j] =  spreadsheet.getRow(i).getCell(j).getStringCellValue();
						} 
					}	    	  
		      }		    	  
		      
		      wbook.close();
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return data;
	}
}

