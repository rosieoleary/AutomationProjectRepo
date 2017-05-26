package Scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectFlight {
WebDriver driver;
	
	public SelectFlight(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By continueBtn =By.name("reserveFlights");
	
public String getTitle(){
		
	return driver.getTitle();
	}
	
	public void clickContinueBtn(){
		driver.findElement(continueBtn).click();
	}
}
