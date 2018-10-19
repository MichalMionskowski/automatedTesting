package com.qa.TaskOneCucumber;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CreateUserPage {
	@FindBy(xpath="//*[@id=\"username\"]")
	private WebElement usernameTextbox;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement passwordTextbox2;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullNameTextbox;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//*[@id=\"yui-gen2-button\"]")
	private WebElement sendFormButton;	
	

	//*[@id="people"]/tbody/tr[2]/td[2]/a
	//*[@id="people"]/tbody/tr[3]/td[2]/a
	
	public void fillUserInformation(String uname, String password, String fname, String email) {
		usernameTextbox.click();
		usernameTextbox.sendKeys(uname);
		passwordTextbox.click();
		passwordTextbox.sendKeys(password);
		passwordTextbox2.click();
		passwordTextbox2.sendKeys(password);
		fullNameTextbox.click();
		fullNameTextbox.sendKeys(fname);
		emailTextbox.click();
		email.replaceAll(" ", "");
		email += "@qa.com";
		emailTextbox.sendKeys(email);
	}
	
	public void submitUserInfo() {
		sendFormButton.click();
		
	}
	
	
}
