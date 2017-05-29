package Scenario5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {
WebDriver driver;
	
	public Account(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By tshirtBtn = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	public void clicktshirtBtn(){
		driver.findElement(tshirtBtn).click();
	}
}
