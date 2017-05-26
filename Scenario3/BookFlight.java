package Scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookFlight {
WebDriver driver;
	
	public BookFlight(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By securePurchaseBtn =By.name("buyFlights");
	
public String getTitle(){
		
	return driver.getTitle();
	}
	
	public void clickSecurePurchaseBtn(){
		driver.findElement(securePurchaseBtn).click();
	}
}

