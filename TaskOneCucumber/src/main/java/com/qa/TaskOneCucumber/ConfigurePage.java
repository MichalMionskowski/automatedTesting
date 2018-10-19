package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurePage {

	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement fullNameTextbox;

	@FindBy(xpath = "//*[@id=\"yui-gen3-button\"]")
	private WebElement saveButton;
	
	
	public void changeName(String name) {
		fullNameTextbox.clear();
		fullNameTextbox.sendKeys(name);
	}
	public void saveChanges() {
		saveButton.click();
	}
	
}
