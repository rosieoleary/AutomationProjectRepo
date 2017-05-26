package Scenario4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BuyShirtTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	SignIn signInPage;
	Account accountPage;
	TShirt tshirtPage;
	Order orderPage;
	@Before
	public void setup() {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		
		
	}
	
	@Test
	public void BuyTShirtTest() {
		
		report =new ExtentReports("C:\\Users\\Administrator\\Documents\\eclipse _java\\AutomationProject\\src\\Scenario4\\scenario4AutomationReport.html",true);
		test = report.startTest("Browser is Setup");
		test.log(LogStatus.INFO, "Browser is setup and the driver has been directed to the My Store Website");
		
		homePage = new Home(driver);
		
		String homePageTitle = homePage.getTitle();
		if (homePageTitle.equals("My Store")){
			assertEquals(homePageTitle, "My Store");
			test.log(LogStatus.PASS, "Verify title of home page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of home page");
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.clickSignInBtn();
		
		test.log(LogStatus.INFO, "The signin button has been pressed so the website has been directed to a signin page.");
		
		signInPage= new SignIn(driver);
		
		String signInPageTitle = signInPage.getTitle();
		if (signInPageTitle.equals("Login - My Store")){
			
			assertEquals(signInPageTitle, "Login - My Store");
			test.log(LogStatus.PASS, "Verify title of signin page");
		}
		else{
			test.log(LogStatus.FAIL, "Verify title of signin page");
		}
		
		signInPage.inputToEmailbox("jsmith@gmail.com");
		signInPage.inputToPasswordBox("test123");
		signInPage.clickSignInBtn();
		
		test.log(LogStatus.INFO, "The user has inputted an email and a password and pressed signin. They have been directed to their account page.");
		
		accountPage = new Account(driver);
		
		String accountPageTitle = accountPage.getTitle();
		if (accountPageTitle.equals("My account - My Store")){
			
			assertEquals(accountPageTitle, "My account - My Store");
			test.log(LogStatus.PASS, "Verify title of account page");
		}
		else{
			test.log(LogStatus.FAIL, "Verify title of account page");
		}
		accountPage.clicktshirtBtn();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, "The user has pressed the tshirt button and been directed to the tshirt page.");
		
		tshirtPage = new TShirt(driver);
		
		String tshirtPageTitle = tshirtPage.getTitle();
		if (tshirtPageTitle.equals("T-shirts - My Store")){
			assertEquals(tshirtPageTitle, "T-shirts - My Store");
			test.log(LogStatus.PASS, "Verify title of tshirt page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of tshirt page");
			}
		
		tshirtPage.clickaddtocartBtn();
		test.log(LogStatus.INFO, "The user has added a tshirt to the cart and will proceed to payment.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tshirtPage.clickProceedtoCheckoutBtn();
		
		orderPage = new Order(driver);
		
		String orderPageTitle = orderPage.getTitle();
		if (orderPageTitle.equals("Order - My Store")){
			assertEquals(orderPageTitle, "Order - My Store");
			test.log(LogStatus.PASS, "Verify title of order page");
			}
		else{
			test.log(LogStatus.FAIL, "Verify title of order page");
			}
		
		test.log(LogStatus.INFO, "The user has decided to delete the item using the trash tool");
		orderPage.clickDeleteBtn();
		
		String orderPageAlert = orderPage.getEmptyAlert();
		System.out.println(orderPageAlert);
		if (orderPageAlert.contains("empty")){
			test.log(LogStatus.PASS, "Verify order has been deleted");
			}
		else{
			test.log(LogStatus.FAIL, "Verify order has been deleted");
			}
		
		
		orderPage.clickSignOut();
		
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

