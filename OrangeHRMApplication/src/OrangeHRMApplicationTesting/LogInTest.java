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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Utility.Log;

public class LogInTest extends BaseTest{
	

	//validating Login page
	
	WebElement welComeAdmin;
	
	FileInputStream propertiesFile;
	Properties properties;
	
	
	@Test(priority=1,description="Validating Login Functinality Test")
	public void logInTest() throws IOException 
	{
		FileInputStream orangeHRMApplicationLogInTestDataFile = new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\OHRMApplicationLoginTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(orangeHRMApplicationLogInTestDataFile);
		XSSFSheet logInTestDataSheet = workBook.getSheet("LogInTestData");

		// Identifying the External file(Properties file) - since the properties of the
//	    elements are stored in the properties file
	//-----------------------------------------------------------------------------------------------------------------------------------------	
		FileInputStream propertiesFile=new FileInputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\com\\config\\OrangeHRMproperties.properties");
		properties = new Properties();
		
		// using the properties class Object - trying to load the identified propeties file
		properties.load(propertiesFile);
	
	//------------------------------------------------------------------------------------------------------------------------------------------	
	
		Row LoginTestDataRow = logInTestDataSheet.getRow(1);
		Cell logInTestDAtaRowofUserNameCell=LoginTestDataRow.getCell(0);
		
		String userNameTestData=logInTestDAtaRowofUserNameCell.getStringCellValue();
		
		// String userNameTestData="srini"
		// Identifying the property of an element

	          //	By userNamePropery= By.id("txtUsername");--------------------------
		// Identifying the property of an element - which is stored in the propeties file
	    By userNamePropery= By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		
		// finding an element with the property in the current webpage
       WebElement UserName=driver.findElement(userNamePropery);
       
    // Operation should be performed on the element - userName
       UserName.sendKeys(userNameTestData);
       
       Log.info("The UserName is:-"+UserName);  // instead of System.out.println();
    //-----------------------------------------------------------   
       
    // Identifying properties of Password Element
    // <input name="txtPassword" autocomplete="off" type="password">

       Cell logInTestDataRowofpasswordCell=LoginTestDataRow.getCell(1);
       String passwordTestData=logInTestDataRowofpasswordCell.getStringCellValue();
       
     //String passwordTestData="Q@Trainer7";
       
    // identify the property of Password Element
   //    By passwordProperty=By.name("txtPassword");
       By passwordProperty=By.name(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
       
    // identifying the element password with its property
    WebElement password=driver.findElement(passwordProperty);
    
 // Performing an operation on the WebElement Password
   password.sendKeys(passwordTestData);
   
   Log.info("The passwrd is :- "+password);

// <input type="submit"  class="button"  value="LOGIN">
//By LogInButtonProperty = By.className("button");
   
   By LogInButtonProperty = By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));   
WebElement logInButton=driver.findElement(LogInButtonProperty);
logInButton.click();


//Validating OrangeHRM Application HomePage
String expected_OrangeHRMApplicationHomePageText="Admin";
//System.out.println(" The Expected Text of OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

Log.info(" The Expected Text of OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);


//id="welcome" - Property of WelCome Admin Element
//By welComeAdminProperty=By.id("welcome");

By welComeAdminProperty=By.id(properties.getProperty("ornagehRMApplicationHomePageWelComAdminProperty"));
welComeAdmin=driver.findElement(welComeAdminProperty);
       
String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
// System.out.println(" The actual Text of OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
 
Log.info("The actual Text of OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

//----------------------------validating the HomePage-----------------------

if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
{
	//System.out.println(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");
    
	Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");
	
	// Row logInTestResultRow=logInTestDataSheet.createRow(1);
	// Cell logInTestResultRowOfCell=logInTestResultRow.createCell(2);
	// of the same first ROw -- only creating a New CEll to save the Test Result

	Cell logInTestResultRowOfCell=LoginTestDataRow.createCell(2);
	logInTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

}
else
{
	//System.out.println(" Failed to Navigat to OrangeHRM Application HomePage - FAIL");
	
	Log.info("Failed to Navigat to OrangeHRM Application HomePage - FAIL");

	// Row logInTestResultRow=logInTestDataSheet.createRow(1);
	// Cell logInTestResultRowOfCell=logInTestResultRow.createCell(2);

	Cell loginTesstResultRowOfCell=LoginTestDataRow.createCell(2);
	loginTesstResultRowOfCell.setCellValue("\"Failed to Navigat to OrangeHRM Application HomePage - FAIL");
	
}
    FileOutputStream orangeHRMApplicationLogInTestResultFile= new FileOutputStream("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\src\\OrangeHRMTestDatafiles\\OHRMApplicationLoginTestData.xlsx");
    workBook.write(orangeHRMApplicationLogInTestResultFile);
    
 }
	
	
@Test(priority=2,description="validating PIM functionality in OrangeHRMApplicatin")
public void pimTest()
{
	// id="menu_pim_viewPimModule"
	By pimproperty=By.id(properties.getProperty("OrangeHRMApplicationPimproperty"));
    WebElement pim=driver.findElement(pimproperty);
    
    Actions pimAction = new Actions(driver);
    pimAction.moveToElement(pim).build().perform();
    
}
@Test(priority=3,description="validating Add employee Functinality test")
public void addEmployeeTest()
	{
	
		// id="menu_pim_addEmployee"
	    By addEmployeeproperty=By.id(properties.getProperty("OrangeHRMApplicationaddEmplooyeeproperty"));
	    WebElement addEmployee=driver.findElement(addEmployeeproperty);
	    addEmployee.click();
	    
	}

//Validating AddEmployee WebPage - expected text "Add Employee --incomplete


@Test(priority=4,description="validating Add New employee functionality Application")
public void newAddNewEmployeeTest() throws InterruptedException, IOException
{
	// Test Data should be updated from external file Excel
	
	By FirstNameProperty=By.id(properties.getProperty("OrangeHRMApplicationaddEmployeeFirstName"));
	WebElement firstName=driver.findElement(FirstNameProperty);
	firstName.sendKeys("Niharika");
	
	Log.info("The firstName is:-"+firstName);
	
	// ACtions Class - is used to perform operations related to both Mouse and KeyBoard
	// Performing the "TAB" key Operation
	
	Actions KeyBoardActions=new Actions(driver);
	KeyBoardActions.sendKeys(Keys.TAB).build().perform();
	
	// withOut identifying the property of the MiddleName Element - directly automating it
//  since the Actions Class Object(keyBoardActions) focus is now at the MiddleName
//    directly using the same Object Performing the Opeation to send the Test Data

	KeyBoardActions.sendKeys("hello").build().perform();
	
	
	// shifting the focus from the Middle Name to LastName
	KeyBoardActions.sendKeys(Keys.TAB).build().perform();
	
	KeyBoardActions.sendKeys("Buddala").build().perform();
	
	KeyBoardActions.sendKeys(Keys.TAB).build().perform();//will move to employee id
	
	KeyBoardActions.sendKeys(Keys.TAB).build().perform();//// will move to Photograph

	KeyBoardActions.sendKeys(Keys.ENTER).build().perform();
	
	Thread.sleep(10000);
	
	java.lang.Runtime.getRuntime().exec("C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\EmployeePhoto\\Empphoto.exe");
	
	
	
	/*
	By middleNameProperty=By.id("middleName");
	WebElement middleName=driver.findElement(middleNameProperty);
	middleName.sendKeys("Hello007");

	By lastNameProperty=By.id("lastName");
	WebElement lastName=driver.findElement(lastNameProperty);
	lastName.sendKeys("Chello007");
	*/
	

/*
<input class="formInputText" maxlength="10" type="text"
name="employeeId" value="0001" id="employeeId">
*/

	By employeeIdproperty=By.id(properties.getProperty("OrnageHRMApplicationAddEmplyeeEmployeeId"));
	WebElement employeeid=driver.findElement(employeeIdproperty);
	String expected_applicationEmployeeId=employeeid.getAttribute("value");
	//System.out.println("The Expected EmployeeId is :- "+ expected_applicationEmployeeId);
	
	Log.info("The Expected EmployeeId is :- "+ expected_applicationEmployeeId);
	
	Thread.sleep(10000);
	
	// id="btnSave"
	By saveButtonPrperty=By.id(properties.getProperty("OrangeHRMaddEmployeesavebutton"));
	WebElement saveButton=driver.findElement(saveButtonPrperty);
	saveButton.click();
}
/*

	
@Test(priority=5,description="Validating welcomeComeAdmin Functionally test")
public void welComeAdmin()
{
	
	//id="welcome" - Property of WelCome Admin Element
	//By welComeAdminProperty=By.id("welcome");

	By welComeAdminProperty=By.id(properties.getProperty("ornagehRMApplicationHomePageWelComAdminProperty"));
	welComeAdmin=driver.findElement(welComeAdminProperty);
	
	welComeAdmin.click();
}


@Test(priority=6,description=" Validating LogOut Functionality Test ")
public void logOutTest()
{
	// By logOutProperty=By.partialLinkText("Log");
	//By logOutProperty=By.linkText("Logout");
	
	By logOutProperty=By.linkText(properties.getProperty("ornagehRMApplicationHomePageLogOutProperty"));
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(logOutProperty));
	
	WebElement logOut=driver.findElement(logOutProperty);
	logOut.click();
	
	Log.info("****** Successfully Logut *********");
	
}

*/
}
