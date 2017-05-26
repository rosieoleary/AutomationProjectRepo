package Scenario3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flights {
WebDriver driver;
	
	public Flights(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By body = By.xpath("/html/body");
	By triptype2 = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]");
	By flyto = By.name("fromPort");
	By continueBtn = By.name("findFlights");
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	public WebElement findBody(){
		
		return driver.findElement(body);
	}
	public void selectType2(){
		driver.findElement(triptype2).click();
	}
	public void pickLocation(String letter){
		driver.findElement(flyto).click();
		driver.findElement(flyto).sendKeys(letter);
		driver.findElement(flyto).click();
	}
	public void clickContinue(){
		driver.findElement(continueBtn).click();
	}
	
	
	

}
