package Scenario5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contact {
	WebDriver driver;
	
	public Contact(WebDriver driver){
		this.driver = driver;
		
	}
	By title = By.xpath("/html/head/title");
	By subjectHeadingBox = By.id("id_contact");
	By customerServiceOption = By.xpath("//*[@id=\"id_contact\"]/option[2]");
	By messageBox = By.id("message");
	By sendBtn = By.xpath("//*[@id=\"submitMessage\"]/span");
	By messageSent = By.xpath("//*[@id=\"center_column\"]/p");
	By signoutBtn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
	By signInBtn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	public void clickSubjectHeadingBox(){
		
		driver.findElement(subjectHeadingBox).click();
		
	}
	public void clickCustomerServiceOption(){
		driver.findElement(customerServiceOption).click();
	}
	public void inputIntoMessageBox(String input){
		driver.findElement(messageBox).sendKeys(input);
	}
	public void clickSendBtn(){
		driver.findElement(sendBtn).click();
	}
	public String getMessage(){
		return driver.findElement(messageSent).getText();
	}
	public void clickSignOut(){
		driver.findElement(signoutBtn).click();
	}
	public String getSignInBtn(){
		return driver.findElement(signInBtn).getText();
	}

}
