package Scenario5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TShirt {
WebDriver driver;
	
	public TShirt(WebDriver driver){
		this.driver = driver;
	}
	By title = By.xpath("/html/head/title");
	By addtocartBtn = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span");
	By proceedtocheckoutBtn = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	public void clickaddtocartBtn(){
		driver.findElement(addtocartBtn).click();
	}
	public void clickProceedtoCheckoutBtn(){
		driver.findElement(proceedtocheckoutBtn).click();
	}
}