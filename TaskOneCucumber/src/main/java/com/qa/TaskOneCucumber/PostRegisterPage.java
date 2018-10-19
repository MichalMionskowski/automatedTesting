package com.qa.TaskOneCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostRegisterPage {

	@FindBy(xpath="//*[@id=\"people\"]/tbody/tr[2]/td[2]/a")
	private WebElement userCheck;
	
	
	public String checkUser() {
		return userCheck.getText();
	}

	
}
