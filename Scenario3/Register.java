package Scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
	WebDriver driver;
	
	public Register(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By namebox = By.name("email");
	By passwordbox = By.name("password");
	By repasswordbox=By.name("confirmPassword");
	By registerBtn = By.name("register");
	By confirmation = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font");
	By flightBtn = By.xpath("/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
	
	
	public String getTitle(){
		return driver.getTitle();
	}
	public void inputToNamebox(String username){
		driver.findElement(namebox).sendKeys(username);
	}
	public void inputToPasswordBox(String password){
		driver.findElement(passwordbox).sendKeys(password);
	}
	public void reinputToPasswordBox(String password){
		driver.findElement(repasswordbox).sendKeys(password);
	}
	public void clickRegisterBtn(){
		driver.findElement(registerBtn).click();
	}
	public String getConfirmation(){
		return driver.findElement(confirmation).getText();
	}
	
	public void clickFlightBtn(){
		driver.findElement(flightBtn).click();
	}
	
	
	

}
