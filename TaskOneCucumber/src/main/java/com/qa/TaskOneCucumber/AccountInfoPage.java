package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInfoPage {
	@FindBy(xpath="//*[@id=\"main-panel\"]/div[2]")
	private WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configureButton;
	
	public String checkName(){
		return userName.getText().substring(17);
	}

	public void clickConfigure() {
		configureButton.click();
	}
	
}
