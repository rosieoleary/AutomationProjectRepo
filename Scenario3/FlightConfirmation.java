package Scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightConfirmation {
WebDriver driver;
	
	public FlightConfirmation(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By signOffBtn =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a");
	
public String getTitle(){
		
	return driver.getTitle();
	}
public void clickSignOffBtn(){
	driver.findElement(signOffBtn).click();
}

	
}
