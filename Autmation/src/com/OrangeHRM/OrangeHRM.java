package com.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OrangeHRM {

	public static void main(String[] args) {
	
		
		String applicationurlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
        System.setProperty("webdriver.edge.driver","C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\BrowserDriverfiles\\msedgedriver.exe");
        EdgeDriver driver=new EdgeDriver();
       // driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
	
       // driver.get(applicationurlAddress);
        
        driver.navigate().to(applicationurlAddress);
        
        /*
        
		String expected_OHRMpagetitle="orangehrm";
		System.out.println("th expected title of ohrm:"+expected_OHRMpagetitle);
		*/
			
		String actual_OHRMpagetitle=driver.getTitle(); 
		System.out.println("th actual title of ohrm:"+actual_OHRMpagetitle);
		
		System.out.println("the urlAddres provided is:"+applicationurlAddress);
		
		// getting the url address of the curent web page
		
				String actual_urladdress=driver.getCurrentUrl();
				System.out.println(" the current url adress:"+actual_urladdress);
		
	/*	if(actual_OHRMpagetitle.equals(expected_OHRMpagetitle))
		{
		System.out.println("The title of ohrm-pass");
		}
		else
		{
			System.out.println("The title of ohrm-fail");
		}
		*/
		
	}

}
