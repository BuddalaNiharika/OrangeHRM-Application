package com.Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BingHomePage_ScreenShot
{

	 WebDriver driver;
	 String applicationUrlAddress="http://flipkart.com";
	
	public void applicationLaunch()
	{
		
	    System.setProperty("webdriver.edge.driver","C:\\Users\\NIHARIKA\\Desktop\\Neha\\Autmation\\msedgeDriverFiles\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get(applicationUrlAddress);
		
	}
	public void Capturingscreenshot() throws IOException
	{
		File bingscreensht=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(bingscreensht,new File("./screenshots/flipkart.png"));
		
	}
	
	public static void main(String[] args) throws IOException
	{
	
		BingHomePage_ScreenShot screenshot=new BingHomePage_ScreenShot();
		screenshot.applicationLaunch();
		screenshot.Capturingscreenshot();	
		

	}
	
}
