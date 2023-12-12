package com.Exceloperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_SingleTestdata {

	public static void main(String[] args) throws IOException {
	
		//identify the file(excel)in the system
	  FileInputStream testdatafile = new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\src\\com\\ExcelFiles\\singleTestData.xlsx");
      
	  //identify the workbook in the file(excel.file)
	  XSSFWorkbook workbook=new XSSFWorkbook(testdatafile);
	  
	  //identify a particular sheet in the workbook
	  XSSFSheet testdatasheet = workbook.getSheet("testdata");
	  
	  //identify a particular row in the sheet
	  Row testdatasheetrow=testdatasheet.getRow(0);
	  
	  //identify a particular row of cell
	  Cell testdatarowofcell=testdatasheetrow.getCell(1);
			  
	 //get the test data from the row  of cell
	  String testData = testdatarowofcell.getStringCellValue();
	  System.out.println(testData);
	}

}
