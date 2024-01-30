package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	//deceleration
	
	@FindBy(xpath = ("//input[@name='username']"))
	private WebElement AdminUserName;
	
	@FindBy(xpath = ("//input[@name='password']"))
	private WebElement AdminPassword;
	
	@FindBy(xpath = ("//button[@name='submit']"))
	private WebElement AdminLogin;

	
	//initialization
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	
	
	//utilization
	public WebElement getAdminUserName() {
		return AdminUserName;
	}


	public WebElement getAdminPassword() {
		return AdminPassword;
	}


	public WebElement getAdminLogin() {
		return AdminLogin;
	}
	//Business Logic
	
	public void logintoAdminModule(String USERNAME,String PASSWORD)
	{
		AdminUserName.sendKeys(USERNAME);
		AdminPassword.sendKeys(PASSWORD);
		AdminLogin.click();
	}
}
