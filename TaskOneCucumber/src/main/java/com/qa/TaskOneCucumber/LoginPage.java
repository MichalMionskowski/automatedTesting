package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//*[@id=\"j_username\"]")
	private WebElement uname;
	
	@FindBy(xpath = "/html/body/div/div/form/div[2]/input")
	private WebElement pass;
	
	@FindBy(xpath = "/html/body/div/div/form/div[3]/input")
	private WebElement loginButton;
	
	public void login() { 
		uname.click();
		uname.sendKeys("meek95");
		pass.click();
		pass.sendKeys("pluszak12");
		loginButton.click();
	
	}
}
