package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkinsButton;
	
	public void userCreation() {
		manageJenkinsButton.click();
	}
	

}
