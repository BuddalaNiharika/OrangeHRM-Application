package OrangeHRMApplicationTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Utility.Log;

public class BaseTest {

	WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\NIHARIKA\\Desktop\\Neha\\OrangeHRMApplication\\BrowserDriverFiles\\msedgedriver.exe");
		driver = new EdgeDriver();
		//System.out.println(" ***** Successfully launched Chrome Browser ******* ");
		
		Log.info(" ***** Successfully launched Chrome Browser ******* ");
		
		//Navigating to OrangeHRM Application Url Address
		driver.get(applicationUrlAddress);
		//System.out.println(" Sucessfully navigated to OrangeHRM Application ");

		Log.info(" Sucessfully navigated to OrangeHRM Application ");
		
		driver.manage().window().maximize();

		// its a time out related to the Application webpage to be loaded on the Browser
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		// elements to be identified with the given property
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
		 
		@AfterTest
		public void tearDown()
		{
			driver.quit();
			//System.out.println(" ********* Chrome Browser along with OrangeHRM Application Closed Successfully *****");
            Log.info(" ********* Chrome Browser along with OrangeHRM Application Closed Successfully *****");

		}
		
		
		

}
