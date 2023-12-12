package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

          
 public class BaseTest {
	
	 WebDriver driver;
     String applicationUrlAdress="https://www.timeanddate.com/worldclock/";


	public void setup()   //LaunchBrowser
	{
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\BrowserDriverfiles\\msedgedriver.exe");
		driver=new EdgeDriver();
		
		System.out.println(" *****Edge Browser Launched Succesfullly ******");
		
		driver.get(applicationUrlAdress);
		System.out.println(" Sucessfully Navigate to Time And Date Application ");

   }
	
	public void tearDown()   //applicationclose
     {
	driver.quit();
	System.out.println(" **** Edge Browser along with application is closed successfully *****");
     }


 }
	class TimeAndData_CapturingFirstRowOfFirstCell_CityName extends BaseTest 
	{
		
		  public void capturingFirstRowOfFirstCellCityName ()   //TimeAndData_CapturingFirstRowOfFirstCell_CityName 
		   {
			   
			   /*
			     /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
			      
			     Locator - xpath
		         Selector - xpath Expression(for the Source Code)

		         any Xpath expression starts with "html" tag - it is called as Absolute Xpath

			 */
			   
			   By cityNameproperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
			   WebElement cityName=driver.findElement(cityNameproperty);
			   String cityNameText=cityName.getText();
			   
			   System.out.println(cityNameText);
			   
			   System.out.println("**************************");
		}
		 
		 
	}
	
 class CapturingFirstcolumncityName extends TimeAndData_CapturingFirstRowOfFirstCell_CityName
 {
    public void capturingfirstcolumncityName() 
    {
    	// First Row of First Cell
    	// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
      
    	
    //LastRowOfFirstCell	
    //	/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
    	/*
    	String xpathExpressionpart1="	/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
        String xpathExpressionpart2= "]/td[1]";
        */
        //To goto every row of the Table
        for(int tableRowIndex=1;tableRowIndex<=36;tableRowIndex++) 
        {
        	
   By cityNameProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+tableRowIndex+"]/td[1]");
        	/*
        	By cityNameProperty=By.xpath(xpathExpressionPart1+tableRowIndex+xpathExpressionPart2);

        	*/
        	WebElement cityName=driver.findElement(cityNameProperty);
        	String cityNameText=cityName.getText();
        	
        	System.out.println(cityNameText);
        	
            System.out.println("***************************");
        	
            System.out.println();
            
        }
    	
    }
 }
 
 class CaputuringCompletewebtable extends CapturingFirstcolumncityName
 {
	 public void capturingCompleteWebTableData()
	 {
		 //First Row of First Row of cell
		 ///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]

		 //First row of last cell
		 // /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[8]

		 
		 
		 //Last of last cell
		  // /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		 
		 //To goto every row all the cell
	for(int rowofindex=1;rowofindex<=36;rowofindex++)
		{
		// To goto Every Row of All the Cells
	for(int rowofcellindex=1;rowofcellindex<=8;rowofcellindex++)
			{
	By tabledataproperty = By.xpath(" /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowofcellindex+"]/td["+rowofcellindex+"]");
	
	WebElement tabledata=driver.findElement(tabledataproperty);
	
	String tabledatatext=tabledata.getText();
	System.out.print(tabledatatext+" | ");
			}
		}
		 
	 }
 }
 
 
 
	
 class BaseTest2
 {

 public static void main(String agrs[])
 {
	 CaputuringCompletewebtable getCityName= new CaputuringCompletewebtable();
	 getCityName.setup();
	 getCityName.capturingFirstRowOfFirstCellCityName();
	 getCityName.capturingfirstcolumncityName();
	 getCityName.capturingCompleteWebTableData();
	 getCityName.tearDown();
 }
}
   

  

	


