package com.OHRMRevision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OHRMApplication {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// Identifying the Browser in the System - Chrome Browser
	//  Automating Chrome Browser

		System.setProperty("webdriver.edge.driver",
	"C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\BrowserDriverfiles\\msedgedriver.exe");
	// ChromeDriver - its a class of Selenium
	// class cannot be directly interacted with
	// To interact with the Class - we should create an Object to the Class
		WebDriver driver;
		
        driver=new EdgeDriver();
        String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
		//driver.get(url);
	
		driver.navigate().to(url);
	
		String expected_ohrmTitle="orangeHRM";
		System.out.println(" The Expected title of Bing Home Page is :- "+expected_ohrmTitle);
	
		String actual_ohrmTitle = driver.getTitle();
		System.out.println(" The actal title of Bing Home Page is :- "+actual_ohrmTitle);
		
		if(actual_ohrmTitle.equalsIgnoreCase(expected_ohrmTitle))
		{
			System.out.println(" The Tite of the Bing HomePage Matched - PASS ");
		}
		else
		{
			System.out.println(" The Tite of the Bing HomePage not Matched - FAIL");
		}
		
		
	
	Thread.sleep(5000);
	
	
	//driver.close();
	driver.quit();
	}

}
