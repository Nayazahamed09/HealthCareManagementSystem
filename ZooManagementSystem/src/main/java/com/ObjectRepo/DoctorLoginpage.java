package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginpage {

	@FindBy(xpath = ("//input[@name='username']"))
	private WebElement 	DoctorUserName;
	
	@FindBy(xpath = ("//input[@name='password']"))
	private WebElement DoctorPassword;
	
	@FindBy(xpath = ("//button[@name='submit']"))
	private WebElement DoctorLoginButton;

	
	//initialization
	
	public DoctorLoginpage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	
	
	//utilization
	public WebElement getAdminUserName() {
		return DoctorUserName;
	}


	public WebElement getAdminPassword() {
		return DoctorPassword;
	}


	public WebElement getAdminLogin() {
		return DoctorLoginButton;
	}
	//Business Logic
	
	public void logintoAdminModule(String USERNAME,String PASSWORD)
	{
		DoctorUserName.sendKeys(USERNAME);
		DoctorPassword.sendKeys(PASSWORD);
		DoctorLoginButton.click();
	}

}
