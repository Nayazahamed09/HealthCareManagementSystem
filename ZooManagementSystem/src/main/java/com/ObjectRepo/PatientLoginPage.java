package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	
	@FindBy(xpath = ("//input[@name='username']"))
	private WebElement 	PatientUserName;
	
	@FindBy(xpath = ("//input[@name='password']"))
	private WebElement PatientPassword;
	
	@FindBy(xpath = ("//button[@name='submit']"))
	private WebElement PatientLoginButton;

	
	//initialization
	
	public PatientLoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	
	
	//utilization
	public WebElement getAdminUserName() {
		return PatientUserName;
	}


	public WebElement getAdminPassword() {
		return PatientPassword;
	}


	public WebElement getAdminLogin() {
		return PatientLoginButton;
	}
	//Business Logic
	
	public void logintoAdminModule(String USERNAME,String PASSWORD)
	{
		PatientUserName.sendKeys(USERNAME);
		PatientPassword.sendKeys(PASSWORD);
		PatientLoginButton.click();
	}

}



