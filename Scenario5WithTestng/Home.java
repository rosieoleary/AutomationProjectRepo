package Scenario5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By signinBtn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	By contactBtn = By.xpath("//*[@id=\"contact-link\"]/a");
	
	public String getTitle(){
		return driver.getTitle();
	}
	public void clickSignInBtn(){
		driver.findElement(signinBtn).click();
	}
	
	
	

}
