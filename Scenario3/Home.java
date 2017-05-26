package Scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By registerBtn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	public void clickRegisterBtn(){
		driver.findElement(registerBtn).click();
	}
	


}
