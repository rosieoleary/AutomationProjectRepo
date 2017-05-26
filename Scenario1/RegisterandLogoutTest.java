package Scenario1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RegisterandLogoutTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	Register registerPage;
	
	@Before
	public void setup() {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		
		
	}
	
	@Test
	public void RegisterandLogOuttest() {
		
		report =new ExtentReports("C:\\Users\\Administrator\\Documents\\eclipse _java\\AutomationProject\\src\\Scenario1\\scenario1AutomationReport.html",true);
		test = report.startTest("Setup Browser");
		test.log(LogStatus.INFO, "Browser is setup and the driver has been directed to the Mercury Tours Website");
		
		homePage = new Home(driver);
		
		String homePageTitle = homePage.getTitle();
		if (homePageTitle.equals("Welcome: Mercury Tours")){
			assertEquals(homePageTitle, "Welcome: Mercury Tours");
			test.log(LogStatus.PASS, "Verify title of home page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of home page");
		}
		
		homePage.clickRegisterBtn();
		
		test.log(LogStatus.INFO, "The register button has been pressed so the website has been directed to a register page.");
		
		registerPage= new Register(driver);
		
		String registerPageTitle = registerPage.getTitle();
		if (registerPageTitle.equals("Register: Mercury Tours")){
			
			assertEquals(registerPageTitle, "Register: Mercury Tours");
			test.log(LogStatus.PASS, "Verify title of register page");
		}
		else{
			test.log(LogStatus.FAIL, "Verify title of register page");
		}
		
		registerPage.inputToNamebox("John");
		registerPage.inputToPasswordBox("test123");
		registerPage.reinputToPasswordBox("test123");
		registerPage.clickRegisterBtn();
		
		test.log(LogStatus.INFO, "The user has inputted a name, a password and renentered the password and pressed register.");
		
		
		registerPage.clickSignOffBtn();
		
		}
	@After
	public void closeTest(){
		try {
			driver.close();
			test.log(LogStatus.PASS, "The webiste has been logged off and the window has closed. End of test.");
			
		}
		catch(Exception e){
			System.out.println(e.toString());
			test.log(LogStatus.FAIL, "The webiste has been logged off and the window has closed. End of test.");
		}
		
		report.endTest(test);
		report.flush();
	}
	
}
