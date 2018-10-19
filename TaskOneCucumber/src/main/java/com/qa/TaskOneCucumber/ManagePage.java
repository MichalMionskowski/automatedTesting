package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagePage {
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div[17]/a")
	private WebElement manageUsersButton;
	
	public void clickUsers() {
		manageUsersButton.click();
	}
	
}
