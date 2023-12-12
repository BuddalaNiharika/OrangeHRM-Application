package OrangeHRMApplicationTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.Log;



public class TestngAddEmployee extends BaseTest{

	FileInputStream PropertiesFile;
	Properties properties;
	
	@Test(priority=1,description="Validating OrangeHrm Loginpage using Lginpanel Text")
	public void LoginpanelText() throws IOException 
	{
		
		FileInputStream file=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet TestdataSheet = WorkBook.getSheet("Sheet1");
		
		PropertiesFile = new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\com\\config\\OrangeHRMproperties.properties");
		properties = new Properties();
		properties.load(PropertiesFile);
		
		Row testdatarow = 	TestdataSheet.getRow(1);
		Cell testdatarowofcell = testdatarow.getCell(0);
		
	    String TestDataLoginpanel = testdatarowofcell.getStringCellValue();
		
	    String ExpectedLoginpageText = TestDataLoginpanel;
	    Log.info("The login page should contains text -"+ExpectedLoginpageText);
	    
	  //<div id="logInPanelHeading">LOGIN Panel</div>
		By Loginpanelproperty = By.id(properties.getProperty("logInPanelHeadinglogInPanelHeading"));
		WebElement loginpanel = driver.findElement(Loginpanelproperty);
		
		String ActualLoginpanelText = loginpanel.getText();
		Cell Loginpanel = testdatarow.createCell(1);
		Loginpanel.setCellValue(ActualLoginpanelText);	   

		Log.info("The Actual login panel should cantains - "+ActualLoginpanelText);
		if(ActualLoginpanelText.equals(ExpectedLoginpageText)) 
		{
			
			Log.info(ActualLoginpanelText);
			Cell loginpaneltestresult = testdatarow.createCell(2);
			loginpaneltestresult.setCellValue("Successfully navigated to login page - PASS");	
		}
		else
		{
			Log.info("Failed navigated to login page - FAIL");
			Cell loginpaneltestresult = testdatarow.createCell(2);
			loginpaneltestresult.setCellValue("Successfully navigated to login page - FAIL");	
	
		}
		
		FileOutputStream OHRMLoginTestResult = new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
    	WorkBook.write(OHRMLoginTestResult);
	}
	
	
	@Test(priority=2,description="Validating Ohrm Loginpage using LoginpageTitle")
	public void OHRMTitle() throws IOException
	{
	
		FileInputStream file=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet TestdataSheet = WorkBook.getSheet("Sheet1");
		
		Row testdatarow = 	TestdataSheet.getRow(1);
		Cell testdatarowofcell = testdatarow.getCell(3);
		String LoginpageTitletestData = testdatarowofcell.getStringCellValue();
		
		String ExpectedLoginpageTitle = LoginpageTitletestData;
		Log.info("The login page should contains Title -"+ExpectedLoginpageTitle);
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		String ActualLoginpageTitle = driver.getTitle();
		Cell loginpanel = testdatarow.createCell(4);
		loginpanel.setCellValue(ActualLoginpageTitle);
		
		Log.info("The Actual login panel should cantains - "+ActualLoginpageTitle);
		if(ActualLoginpageTitle.equals(ExpectedLoginpageTitle))
		{
		
			Log.info("Successfully navigated to login page - PASS");
			Cell loginPanelTestresult = testdatarow.createCell(5);
			loginPanelTestresult.setCellValue("Successfully navigated to login page - PASS");
		}
		else
		{
			Log.info("Successfully navigated to login page - FAIL");
			Cell loginPanelTestresult = testdatarow.createCell(5);
			loginPanelTestresult.setCellValue("Successfully navigated to login page - FAIL");
		
		}
		
		System.out.println("***********************************************************************************");
		
		FileOutputStream OHRMLoginTestResultFile = new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
    	WorkBook.write(OHRMLoginTestResultFile);
	}
	
	@Test(priority=3,description="Validating OrangeHrm Hmepage Admin Text")
	public void HomePageValidation() throws IOException
	{
		

		FileInputStream file=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet TestdataSheet = WorkBook.getSheet("Sheet1");
	
		Row TestDataRow=TestdataSheet.getRow(1);
		Cell TestDataRowOfCell=TestDataRow.getCell(6);
		
		String UserNameTestData = TestDataRowOfCell.getStringCellValue();
		By Usernameproperty = By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement Username = driver.findElement(Usernameproperty);
		Username.sendKeys(UserNameTestData);
		Log.info("The Test Data for User name - "+UserNameTestData);
		
		TestDataRow = TestdataSheet.getRow(1);
		TestDataRowOfCell=TestDataRow.getCell(7);
		
		String PasswordTestDataValue = TestDataRowOfCell.getStringCellValue();
		By passwordproperty = By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
		WebElement Password = driver.findElement(passwordproperty);
		Password.sendKeys(PasswordTestDataValue);
		Log.info("The Test Data for Password - "+PasswordTestDataValue);
		
		By LoginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();

		By welcomeAdminproperty=By.id(properties.getProperty("ornagehRMApplicationHomePageWelComAdminProperty"));
		WebElement welcomeAdmin = driver.findElement(welcomeAdminproperty);
		
		Cell TestDataRowOfCell1= TestDataRow.getCell(8);
        String  HomePageTestData  = TestDataRowOfCell1.getStringCellValue();

        String Excepted_HomePageElementText = HomePageTestData;
        Log.info("The expected Element Text - "+Excepted_HomePageElementText);
        
        String Actual_HmepageElementPage = welcomeAdmin.getText();
        Log.info("The Actual  is Element Text - "+Actual_HmepageElementPage);
        

        //Validating The text of the Element
        // Validating orangeHrm Home Page

        Cell ActualHomePageTestData = TestDataRow.createCell(9);
        ActualHomePageTestData.setCellValue(Actual_HmepageElementPage);
        
        if(Actual_HmepageElementPage.contains(Excepted_HomePageElementText))
        {
        	Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");
        	
        	Cell HomePageTestResultRowOfCell = TestDataRow.createCell(10);
        	HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");
        	
        }
        
        else
        {
        	
          Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - FAIL");
        	
        	Cell HomePageTestResultRowOfCell = TestDataRow.createCell(10);
        	HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - FAIL");
        	
        }
        
        FileOutputStream orangeHrmLoginTestResultFile = new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
        WorkBook.write(orangeHrmLoginTestResultFile);
      }
	
	

	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
	
	@Test(priority=4,description="Perform peration n pim element in Home page")
	public void PIMElement() throws IOException
	{
		

		FileInputStream file=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet TestdataSheet = WorkBook.getSheet("Sheet1");
	
		By pimProperty = By.id(properties.getProperty("OrangeHRMApplicationPimproperty"));
		WebElement Pim = driver.findElement(pimProperty);

		Log.info("Successfully perform operation on PIM element");
		
	    Actions pimAction = new Actions(driver);
	    pimAction.moveToElement(Pim).build().perform();


		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
		By  AddEmployeeElementProperty = By.id(properties.getProperty("OrangeHRMApplicationaddEmplooyeeproperty"));
		WebElement AddEmployee  = driver.findElement(AddEmployeeElementProperty);
		AddEmployee.click();
		
		Row testdatarow = TestdataSheet.getRow(1);
		Cell testdatarowofCell = testdatarow.getCell(11);
		
		String PimValidation = testdatarowofCell.getStringCellValue();
		String ExpectedPIMValidationText = PimValidation;
		Log.info("The Expected Text that Add Employee page should contains - "+ExpectedPIMValidationText);
		
		   // /html/body/div[1]/div[3]/div/div[1]  -- Add employee   
		 // /html/body/div[1]/div[3]/div/div[2]/div[1]--- persnal
	
	By AddEmployeeHeaderBlockProperty = By.xpath(properties.getProperty("OrangeHRMApplicationHeaderBlockproperty"));
	WebElement AddEmployeepageHeaderBlock =driver.findElement(AddEmployeeHeaderBlockProperty);
	
	//<h1>Add Employee</h1>
	
	By AddEmployeeValidationPagetextPrperty= By.tagName(properties.getProperty("OrangeHRMApplicatinpageztextProperty"));
	WebElement AddEmployeepageValidatinText =driver.findElement(AddEmployeeValidationPagetextPrperty);
	
	String ActualTextOfAddEmployee = AddEmployeepageValidatinText.getText();
	Cell ActualPimValidationText = testdatarow.createCell(12);
	ActualPimValidationText.setCellValue(ActualTextOfAddEmployee);
		
	
  Log.info("The Actual Text that Add Employee page should - "+ActualTextOfAddEmployee);
  
  if(ActualTextOfAddEmployee.contains(ExpectedPIMValidationText))
  {
	  
	  Log.info("Succesfully Navigated to OrangeHRM Application  Addemployee Page - PASS");
	  Cell PimPageTestResltRowofCell = testdatarow.createCell(13);
	  PimPageTestResltRowofCell.setCellValue("Succesfully Navigated to OrangeHRM Application  Addemployee Page - PASS");
 }
  else
  {
	  
	  Log.info("Succesfully Navigated to OrangeHRM Application  Addemployee Page - FAIL");
	  Cell PimPageTestResltRowofCell = testdatarow.createCell(13);
	  PimPageTestResltRowofCell.setCellValue("Succesfully Navigated to OrangeHRM Application  Addemployee Page - FAIL");
  }
  
  FileOutputStream orangeHrmLoginTestResultFile = new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
  WorkBook.write(orangeHrmLoginTestResultFile);	
 }  
	
	@Test(priority=5,description="Adding Employee Details and Validating Emplyee Details")
	public void AddEmployeeDetails() throws IOException, InterruptedException
	{
		

		FileInputStream file=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\AddEmployee.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(file);
		XSSFSheet TestdataSheet = WorkBook.getSheet("Sheet1");
		
		for(int rowofindex=1;rowofindex<=3;rowofindex++)
		{
			Row Exceltestdatarow = TestdataSheet.getRow(rowofindex);
			Cell Exceltestdatarwofcell = Exceltestdatarow.getCell(14);
			
			String TestdataFirstname = Exceltestdatarwofcell.getStringCellValue();
			  //  <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
			
			By FirstNameProperty = By.id(properties.getProperty("OrangeHRMApplicationaddEmployeeFirstName"));
			WebElement firstname = driver.findElement(FirstNameProperty);
			
			firstname.sendKeys(TestdataFirstname);
			Actions KeyBoard = new Actions(driver);
			KeyBoard.sendKeys(Keys.TAB).build().perform();
			
			Exceltestdatarow = TestdataSheet.getRow(rowofindex);
			Exceltestdatarwofcell = Exceltestdatarow.getCell(15);
			String Testdatamiddelename = Exceltestdatarwofcell.getStringCellValue();
			
			KeyBoard.sendKeys(Testdatamiddelename).build().perform();
			
			Exceltestdatarow = TestdataSheet.getRow(rowofindex);
			Exceltestdatarwofcell = Exceltestdatarow.getCell(16);
			String TestdataLastname = Exceltestdatarwofcell.getStringCellValue();
			
			KeyBoard.sendKeys(Keys.TAB).build().perform();
			
			KeyBoard.sendKeys(TestdataLastname).build().perform();
			
			
			KeyBoard.sendKeys(Keys.TAB).build().perform(); //will move to EmployeeId
			
			KeyBoard.sendKeys(Keys.TAB).build().perform(); //will move to photograph
			
			
			KeyBoard.sendKeys(Keys.ENTER).build().perform();
			
			Thread.sleep(10000);
			
			java.lang.Runtime.getRuntime().exec("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\EmployeePhoto\\Empphoto.exe");
			
			Thread.sleep(10000);
	        //<label for="employeeId">Employee Id</label>
	        //<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
	     
			By employeeIdproperty=By.id(properties.getProperty("OrnageHRMApplicationAddEmplyeeEmployeeId"));
			WebElement employeeid=driver.findElement(employeeIdproperty);
			String ExpectedEmployeIDValue =  employeeid.getAttribute("value");
			
			Exceltestdatarow = TestdataSheet.getRow(rowofindex);
			Cell PIMpageEmployeeId = Exceltestdatarow.getCell(17);
			PIMpageEmployeeId.setCellValue(ExpectedEmployeIDValue);
			
			By saveButtonPrperty=By.id(properties.getProperty("OrangeHRMaddEmployeesavebutton"));
			WebElement saveButton=driver.findElement(saveButtonPrperty);
			saveButton.click();
			
		 //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPersonalDetails/empNumber/0020">Personal Details</a>
	        
			Exceltestdatarow = TestdataSheet.getRow(rowofindex);
			Cell ExcellFirstname =  Exceltestdatarow.getCell(18);
			String ExcpectedpersonalDetails = ExcellFirstname.getStringCellValue();
			
			Log.info("The Expected Personal Details Page cantains Text - "+ExcpectedpersonalDetails);
			
		    //<label for="Full_Name" class="hasTopFieldHelp">Full Name</label>
		    ///html/body/div[1]/div[3]/div/div[2]/div[1] ---- personal Details (name)
			
			By personalDetailsProperty = By.xpath(properties.getProperty("orangeHRMEmployeepersonaldetails")) ;
			WebElement personalDetailspagevalidation = driver.findElement(personalDetailsProperty);
			
			By personalDetailspageValidationTextPrperty = By.xpath(properties.getProperty("orangeHRMEmployeepersonaldetails")) ;
			WebElement personalDetailspageValidationText = driver.findElement(personalDetailspageValidationTextPrperty);
			
		    String ActualpersnalDetailspage = personalDetailspagevalidation.getText();
		    Log.info("The Actual Personal Details Page cantains Text - "+ActualpersnalDetailspage);
		    
		    Cell personalDetailspage = Exceltestdatarow.createCell(19);
		    personalDetailspage.setCellValue(ActualpersnalDetailspage);
		    
		    if(ActualpersnalDetailspage.equals(ExcpectedpersonalDetails))
		    {
		    	
		    	Log.info("Successfully navigated to PersonalDetails page - Pass");
		    	Cell personaldetailsvalidationTestResult = Exceltestdatarow.createCell(20);
		    	personaldetailsvalidationTestResult.setCellValue("Successfully Navigated to OrangeHRM Application PersonalDetails Page - PASS");	
		    	
		    }
		    else
		    {
		    	Log.info("Falied navigated to Personal Details page");
		    	Cell personaldetailsvalidationTestResult = Exceltestdatarow.createCell(20);
		    	personaldetailsvalidationTestResult.setCellValue("Falied navigated to Personal Details page - FAIL");	
		    	
		    }
		    
	
		 //   <input value="Harsha" type="text" name="personal[txtEmpFirstName] class="block default editable" maxlength="30" title="First Name"
		    //  id="personal_txtEmpFirstName" disabled="disabled">
		    
			
		  
			

			
			
			
			
		
			
		}
	
		
	}
	
	
	
	
}
