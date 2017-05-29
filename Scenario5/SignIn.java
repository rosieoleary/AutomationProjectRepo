package Scenario5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
	WebDriver driver;
	
	public SignIn(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By emailbox = By.name("email");
	By passwordbox = By.name("passwd");
	By signinBtn = By.xpath("//*[@id=\"SubmitLogin\"]/span");
	
	public String getTitle(){
		return driver.getTitle();
	}
	public void inputToEmailbox(String email){
		driver.findElement(emailbox).sendKeys(email);
	}
	public void inputToPasswordBox(String password){
		driver.findElement(passwordbox).sendKeys(password);
	}
	public void clickSignInBtn(){
		driver.findElement(signinBtn).click();
	}
}
