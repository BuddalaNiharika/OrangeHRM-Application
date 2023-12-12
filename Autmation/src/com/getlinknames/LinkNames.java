package com.getlinknames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LinkNames 
{
public static void main(String[] args)
{

	EdgeDriver driver;
	
	String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
	System.setProperty("webdriver.edge.driver","C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\BrowserDriverfiles\\msedgedriver.exe");
    
	driver=new EdgeDriver();
	driver.get(applicationUrlAddress);
	
	
	
	By Linkscommonproperty=By.tagName("a");

	List<WebElement>arraylist=driver.findElements(Linkscommonproperty);
				
	int tsrtc_homepagelinkscount=arraylist.size();
	System.out.println("The number of links on the TSRTC Applicatin Hmepage are:"+tsrtc_homepagelinkscount);
	
/*	for(int index=0;index<arraylist.size();index++)
	{
		
		System.out.println(arraylist.get(index));
		
	}
	*/
	
	

	// <a class="selectedtabcopy" href="/oprs-web/ticket/waitlist.do" target="_top" title="Enquiry">
	//Enquiry</a>
	
	/*
	By enquiryProperty=By.linkText("Enquiry");
	
	WebElement enquiry=driver.findElement(enquiryProperty);
	
	enquiry.click();
	*/
	
	
/*	By enquiryProperty=By.partialLinkText("Enqui");
    WebElement enquiry=driver.findElement(enquiryProperty);
	
	enquiry.click();
	*/
	
 //	driver.quit();
}


}
