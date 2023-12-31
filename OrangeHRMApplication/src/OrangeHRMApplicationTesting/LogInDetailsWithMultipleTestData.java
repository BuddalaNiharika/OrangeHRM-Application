package OrangeHRMApplicationTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Utility.Log;

public class LogInDetailsWithMultipleTestData extends BaseTest {
	
	FileInputStream propertiesFile;
	Properties properties;
	
	
	@Test(priority=1,description="Validating Login Functinality Test")
	public void logInTest() throws IOException 
	{
		FileInputStream orangeHRMApplicationLogInTestDataFile = new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\OHRM_LogInTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(orangeHRMApplicationLogInTestDataFile);
		XSSFSheet logInTestDataSheet = workBook.getSheet("Sheet1");

		// Identifying the External file(Properties file) - since the properties of the
//	    elements are stored in the properties file
	//-----------------------------------------------------------------------------------------------------------------------------------------	
		FileInputStream propertiesFile=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\com\\config\\OrangeHRMproperties.properties");
		properties = new Properties();
		
		// using the properties class Object - trying to load the identified propeties file
		properties.load(propertiesFile);
	
	//------------------------------------------------------------------------------------------------------------------------------------------	
	
		Row LoginTestDataRow = logInTestDataSheet.getRow(1);
		Cell logInTestDAtaRowofCell=LoginTestDataRow.getCell(0);
		String TestDataLoginPanel = logInTestDAtaRowofCell.getStringCellValue();
		
		String ExpectedMultipleLoginpanelText=TestDataLoginPanel;
		Log.info("The  Expected login page should contains text -"+ExpectedMultipleLoginpanelText);
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		By Loginpanelproperty = By.id(properties.getProperty("logInPanelHeadinglogInPanelHeading")) ;
		WebElement loginpanel= driver.findElement(Loginpanelproperty);
		
		String ActualloginpanelpageText = loginpanel.getText();
		Log.info("The Actual Login Page should Contains - "+ActualloginpanelpageText);
		
		System.out.println("*****************************************************************************");
		
		LoginTestDataRow = logInTestDataSheet.getRow(1);
		logInTestDAtaRowofCell= LoginTestDataRow.getCell(1);
		String ExpectedInvalidCrendentialsText = logInTestDAtaRowofCell.getStringCellValue();
		
		Log.info("The login page should contains text -"+ExpectedInvalidCrendentialsText);
		
       By UsernameProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
       WebElement Username=driver.findElement(UsernameProperty);
       Username.sendKeys("Admin");
       
       By passWordProperty=By.name(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	   WebElement PassWord=driver.findElement(passWordProperty);
	   PassWord.sendKeys("Niharika123");
	   
	   By LoginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
	   

		//<span id="spanMessage">Invalid credentials</span>
		By InvalidcredentialsProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageInvalidCredentialsProperty"));
		WebElement Invalidcredentials=driver.findElement(InvalidcredentialsProperty);
		String  ActualInvalidCredentialsText = Invalidcredentials.getText();
		
		LoginTestDataRow = logInTestDataSheet.getRow(1);
		Cell Actual =  LoginTestDataRow.createCell(2);
		Actual.setCellValue(ActualloginpanelpageText+","+ActualInvalidCredentialsText);
		Log.info("The actual Login Page should contains "+ActualInvalidCredentialsText);
		
		
		if(ActualloginpanelpageText.equals(ExpectedMultipleLoginpanelText)&&ActualInvalidCredentialsText.equals(ExpectedInvalidCrendentialsText))
			{
				
			Log.info("Successfully navigated to login page - PASS");
			Cell loginpanelTestResult = LoginTestDataRow.createCell(3);
			loginpanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		  }
		else
		{
			Log.info("Failed navigated to login page - FAIL");
			Cell loginpanelTestResult=LoginTestDataRow.createCell(3);
			loginpanelTestResult.setCellValue("Failed navigated to login page - FAIL");
        }
		
		System.out.println("*****************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\OHRM_LogInTestData.xlsx");
		workBook.write(orangeHRMApplicationLogInTestResultFile);
}
	
	
	@Test(priority=2,description="Login to OrangeHRM multipleTestData")
	public void TestData() throws IOException
	{
		FileInputStream MultipleTestdataFile=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\OHRM_LogInTestData.xlsx ");
		XSSFWorkbook WorkBook=new XSSFWorkbook(MultipleTestdataFile);
		XSSFSheet MultipleTestDataSheet = WorkBook.getSheet("Sheet1");
		
		Row multipleTestDataRow = MultipleTestDataSheet.getRow(1);
        Cell multipleTestDataRowofCell  = multipleTestDataRow.getCell(4);
		
		String MultipleTestDataUserName = multipleTestDataRowofCell.getStringCellValue();
		
		By UsernameProperty = By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement Username=driver.findElement(UsernameProperty);
		Username.sendKeys(MultipleTestDataUserName);
		
		String multipletestDataofPassword = multipleTestDataRowofCell.getStringCellValue(); 
		By passwordproperty = By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
		WebElement password = driver.findElement(passwordproperty);
		password.sendKeys(multipletestDataofPassword);
		
		  By LoginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    //Finding the element by using property in the current page
		    WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			Login.click();
			driver.navigate().back();
			driver.navigate().refresh();
			
			int rowCount=MultipleTestDataSheet.getLastRowNum();
			System.out.println("The number of rows -" +rowCount);
			
			for(int rowindex=1;rowindex<=rowCount;rowindex++)
			{
				
				multipleTestDataRow=MultipleTestDataSheet.getRow(rowindex);
				multipleTestDataRowofCell=multipleTestDataRow.getCell(4);
				
				String MultipleTestDatausernameValue = multipleTestDataRowofCell.getStringCellValue();
				
				UsernameProperty = By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			    Username=driver.findElement(UsernameProperty);
				Username.sendKeys(MultipleTestDataUserName);
				
				multipleTestDataRow=MultipleTestDataSheet.getRow(rowindex);
				String MultipleTestDatapasswordvalue = multipleTestDataRowofCell.getStringCellValue();
				
				passwordproperty = By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
			    password = driver.findElement(passwordproperty);
				password.sendKeys(multipletestDataofPassword);
				
				
				LoginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
				    //Finding the element by using property in the current page
				  Login=driver.findElement(LoginProperty);
				    //Operation should be performed on the element - Password
					Login.click();
					Log.info("Username -" +MultipleTestDatausernameValue);
				    Log.info("password -" +MultipleTestDatapasswordvalue);
				
				if(MultipleTestDatausernameValue.equals(MultipleTestDatapasswordvalue))
				{
					
					multipleTestDataRow=MultipleTestDataSheet.getRow(rowindex);
					multipleTestDataRowofCell=multipleTestDataRow.getCell(6);
					
					String ExpectedHomePageText=multipleTestDataRowofCell.getStringCellValue();
					Log.info("The Expected Text Homae page should contains - "+ExpectedHomePageText);
					
					By WelcomeAdminProperty  = By.id(properties.getProperty("ornagehRMApplicationHomePageWelComAdminProperty"));
					WebElement WelcomeAdmin  = driver.findElement(WelcomeAdminProperty);
					
					String Actual_HomepageElementText  = WelcomeAdmin.getText();
					
					Cell ActualHomepageTextElement = multipleTestDataRow.createCell(7);
					ActualHomepageTextElement.setCellValue(Actual_HomepageElementText);
					Log.info("The Actual  is Element Text - "+Actual_HomepageElementText);
					 
					 //Validating The text of the Element
						// Validating orangeHrm Home Page
						 
					 
					 if(Actual_HomepageElementText.contains(ExpectedHomePageText))
					 {
						 
						 Log.info(" Sucessfully Navigate to OrangeHRM Application HomePage-PASS ");
						 
						 Cell HomePageTestResultRowofCell = multipleTestDataRow.createCell(8);
						 HomePageTestResultRowofCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

				     }
					 else
					 {
						 Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
							
						 Cell HomePageTestResultRowofCell = multipleTestDataRow.createCell(8);
						 HomePageTestResultRowofCell.setCellValue("Failed to Navigated to OrangeHRM Application HomePage - FAIL");
				     }
					 
					 System.out.println("******************************************************************************************");
					
			}
				else
				{
					Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");

					Cell LogInTestRowofCell = multipleTestDataRow.createCell(8);
					LogInTestRowofCell.setCellValue("Failed to Navigated to OrangeHRM Application HomePage - FAIL");
					
					File currentWebPageScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(currentWebPageScreenShot,new File("./LoginScreenShot/"+"_"+MultipleTestDatausernameValue+"_"+MultipleTestDatapasswordvalue+"_"+".png"));
					
				}
				
				System.out.println("********************************************************************************************************");
				
				driver.navigate().back();
				driver.navigate().refresh();
			}
			
      }
	
	@Test(priority=3,description="Back to Login page")
	public void LogOut() throws IOException
	{

		FileInputStream MultipleTestdataFile=new FileInputStream("C:\\\\Users\\\\NIHARIKA\\\\Desktop\\\\Neha\\\\OrangeHRMApplication\\\\src\\\\OrangeHRMTestDatafiles\\\\OHRM_LogInTestData.xlsx");
		XSSFWorkbook WorkBook=new XSSFWorkbook(MultipleTestdataFile);
		XSSFSheet MultipleTestDataSheet = WorkBook.getSheet("Sheet1");
		
		Row multipleTestDataRow = MultipleTestDataSheet.getRow(1);
        Cell multipleTestDataRowofCell  = multipleTestDataRow.getCell(4);
		
    	String MultipleTestDatausernameValue = multipleTestDataRowofCell.getStringCellValue();
		
		By UsernameProperty = By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
	    WebElement  Username=driver.findElement(UsernameProperty);
		Username.sendKeys(MultipleTestDatausernameValue);
		
		multipleTestDataRow = MultipleTestDataSheet.getRow(1);
        multipleTestDataRowofCell  = multipleTestDataRow.getCell(5);
		
        String MultipleTestDatapasswordvalue = multipleTestDataRowofCell.getStringCellValue();
		
		By passwordproperty = By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	   WebElement password = driver.findElement(passwordproperty);
		password.sendKeys(MultipleTestDatapasswordvalue);
		
		
		By LoginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
		
		//identify the element by using the property
		By WelcomeAdminProperty=By.id(properties.getProperty("ornagehRMApplicationHomePageWelComAdminProperty"));
	    WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 welcomeAdmin.click();
		
		 
		By logOutProperty=By.linkText(properties.getProperty("ornagehRMApplicationHomePageLogOutProperty"));
		 WebElement logOut=driver.findElement(logOutProperty);
		 logOut.click();
		 
		 multipleTestDataRow = MultipleTestDataSheet.getRow(1);
	     multipleTestDataRowofCell  = multipleTestDataRow.getCell(9);
		 String TestDataLoginPanel = multipleTestDataRowofCell.getStringCellValue();
		 
		 String ExpectedLoginPageText = TestDataLoginPanel;
		 Log.info("The login page should contains text -"+ExpectedLoginPageText);
		 
		//<div id="logInPanelHeading">LOGIN Panel</div>
		 By LoginPanelProperty=By.id(properties.getProperty("logInPanelHeadinglogInPanelHeading"));
		 WebElement LoginPanel=driver.findElement(LoginPanelProperty);
		
		 String ActualLoginPageText = LoginPanel.getText();
		 Cell loginPanel = multipleTestDataRow.createCell(10);
		 loginPanel.setCellValue(ActualLoginPageText);
		 Log.info("The Actual login panel should cantains - "+ActualLoginPageText);
			
		 if(ActualLoginPageText.equals(ExpectedLoginPageText))
		 {
			 Log.info("Successfully navigated to login page - PASS");
			
			 Cell LoginPanelTestResult=multipleTestDataRow.createCell(11);
			 LoginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");
		 }
		 
		 FileOutputStream OrangeHRMApplicationLogInResultFile = new FileOutputStream("C:\\\\Users\\\\NIHARIKA\\\\Desktop\\\\Neha\\\\OrangeHRMApplication\\\\src\\\\OrangeHRMTestDatafiles\\\\OHRM_LogInTestData.xlsx");
		 WorkBook.write(OrangeHRMApplicationLogInResultFile);
		 
   }
	
	
}
