package com.Exceloperation;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_writeOperation
{
public static void main(String[] args) throws IOException	
{
	//identify the file(excel)in the system
	  FileInputStream testdatafile = new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\src\\com\\writeExcelfiles\\singlewriteexcelfile.xlsx");
    
	  //identify the workbook in the file(excel.file)
	  XSSFWorkbook workbook=new XSSFWorkbook(testdatafile);
	  
	  //identify a particular sheet in the workbook
	  XSSFSheet testdatasheet = workbook.getSheet("testdata1");
	  
	  //create a particular row in the sheet
	  Row sheetofnewrowCreated = testdatasheet.createRow(4);
	 	  
	  //create a particular row of cell
	  Cell newrowofcellcreated = sheetofnewrowCreated.createCell(3);
	  
	  //setting the value into the new row f cell created
	  newrowofcellcreated.setCellValue("Functional Testing");
	  
	  //saving the file with the path of the application f the system with a Name workbook
	  FileOutputStream testResultfile= new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\src\\com\\writeExcelfiles\\singlewriteexcelfile.xlsx");
      workbook.write(testResultfile); 

}

}
