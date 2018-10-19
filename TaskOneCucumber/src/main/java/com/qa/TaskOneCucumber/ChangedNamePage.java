package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangedNamePage {
	@FindBy(xpath="//*[@id=\"main-panel\"]/h1")
	private WebElement name;
	
	
	public String checkName() {
		return name.getText();
	}
}
