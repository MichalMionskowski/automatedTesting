package com.qa.TaskOneCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage {
	@FindBy(xpath="//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserButton;
	
	private WebElement current;
	
	public void clickCreate() {
		createUserButton.click();
	}
	
	public String checkForUsers(WebDriver driver, String user) {
		boolean end = false;
		int cur =2;
		do{
			String currentPath = "//*[@id=\"people\"]/tbody/tr["+ cur + "]/td[2]/a";
			current = driver.findElement(By.xpath(currentPath));
			if(!current.isDisplayed()) {
				end = true;
				break;
			}
			if(current.getText().equals(user)) {
				return current.getText();
			}	
			cur++;
	
		}while(!end);
		
		return "";
	}
	
	public void displayDetails(){
		current.click();
	}
}
