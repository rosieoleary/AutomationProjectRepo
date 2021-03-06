package Scenario5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Order {
WebDriver driver;
	
	public Order(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By deleteitemBtn= By.xpath("//*[@id=\"1_1_0_18425\"]/i");
	By emptyalert = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]");
	By contactBtn = By.id("contact-link");

	public String getTitle(){
		
		return driver.getTitle();
	}
	public void clickDeleteBtn(){
		driver.findElement(deleteitemBtn).click();
	}
	public String getEmptyAlert(){
		
		return driver.findElement(emptyalert).getText();
	}
	public void clickContactBtn(){
		driver.findElement(contactBtn).click();
	}
	

}
