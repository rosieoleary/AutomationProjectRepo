package Scenario3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInandBookFlightsTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	Register registerPage;
	Flights flightsPage;
	SelectFlight selectFlightPage;
	BookFlight bookFlightPage;
	FlightConfirmation confirmFlightPage;
	
	@Before
	public void setup() {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		
		
	}
	
	@Test
	public void BookFlighttest() {
		
		report =new ExtentReports("C:\\Users\\Administrator\\Documents\\eclipse _java\\AutomationProject\\src\\Scenario3\\scenario3AutomationReport.html",true);
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
		
		registerPage.clickFlightBtn();
		
		test.log(LogStatus.INFO, "The user has pressed the flight button and been directed to a find a flight page.");
		
		flightsPage = new Flights(driver);
		
		String flightsPageTitle = flightsPage.getTitle();
		if (flightsPageTitle.equals("Find a Flight: Mercury Tours:")){
			assertEquals(flightsPageTitle, "Find a Flight: Mercury Tours:");
			test.log(LogStatus.PASS, "Verify title of find a flight page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of find a flight page");
			}
		
		flightsPage = new Flights(driver);
		
		flightsPage.selectType2();
		flightsPage.pickLocation("a");
		flightsPage.clickContinue();
		
		test.log(LogStatus.INFO, "The user has made selections including type of seat and location from which they are travelling, then clicked continue and been directed to a select a flight page.");
		
		selectFlightPage = new SelectFlight(driver);
		
		String selectFlightPageTitle = selectFlightPage.getTitle();
		if (selectFlightPageTitle.equals("Select a Flight: Mercury Tours")){
			assertEquals(selectFlightPageTitle, "Select a Flight: Mercury Tours");
			test.log(LogStatus.PASS, "Verify title of select a flight page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of select a flight page");
			}
		
		selectFlightPage.clickContinueBtn();
		
		test.log(LogStatus.INFO, "The user has clicked continue and been directed to a book flight page.");
		
		bookFlightPage = new BookFlight(driver);
		
		String bookFlightPageTitle = bookFlightPage.getTitle();
		if (bookFlightPageTitle.equals("Book a Flight: Mercury Tours")){
			assertEquals(bookFlightPageTitle, "Book a Flight: Mercury Tours");
			test.log(LogStatus.PASS, "Verify title of book a flight page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of book a flight page");
			}
		
		bookFlightPage.clickSecurePurchaseBtn();
		
		test.log(LogStatus.INFO, "The user has clicked a secure purchase button and been directed to a confirmation page.");
		
		confirmFlightPage = new FlightConfirmation(driver);
		
		String confirmFlightPageTitle = bookFlightPage.getTitle();
		if (confirmFlightPageTitle.equals("Flight Confirmation: Mercury Tours")){
			assertEquals(confirmFlightPageTitle, "Flight Confirmation: Mercury Tours");
			test.log(LogStatus.PASS, "Verify title of confirm a flight page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of confirm a flight page");
			}
		
		confirmFlightPage.clickSignOffBtn();
		
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
