package com.NavigatinToApplication;

import org.openqa.selenium.edge.EdgeDriver;

public class BingApplication {

	public static void main(String[] args) 
	{
		
		EdgeDriver driver;
		
		String applicationUrlAddress="http://facebook.com";
		
		
		
		//automating the chrmebrwser
		System.setProperty("webdriver.edge.driver","C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\BrowserDriverfiles\\msedgedriver.exe");
	
		EdgeDriver edgebrowser=new EdgeDriver();

		   //edgebrowser.get("http://bing.com"); 
		
	    	//edgebrowser.close();                         <--- exception is invalid session id 
		
		   //open / navigation to the facebook application 
		 
	    	//edgebrowser.get("http://facebook.com");  <----     using  Method get()  
	
	      	edgebrowser.navigate().to("http://facebook.com");  // <----- using method .navigate.to()  and get() and  navigate.to() are used for navigate to application
		
	      
		
	
	     //getting the title of the current webPage
		
		String actual_FBHomePageTitle  = edgebrowser.getTitle();
		
		System.out.println("The actual title of facebook Homepage is :- "+actual_FBHomePageTitle);
		
		
		//Navigation to Application url Address
		
		edgebrowser.navigate().to(applicationUrlAddress);
		
		System.out.println(" The Url Adress provide is:-" +applicationUrlAddress);
		
		// getting the Url address of the current webpage
		
		String actual_FBHomepageUrlAddress = edgebrowser.getCurrentUrl();
		System.out.println(" the current url Address of the FB HomePage is:-" + actual_FBHomepageUrlAddress);
		
	 //   edgebrowser.quit();
		
		
		
	}

}
