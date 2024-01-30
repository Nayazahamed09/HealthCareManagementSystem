package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecialization {
	
	//declaration

	
	@FindBy(xpath = ("//input[@name='doctorspecilization']"))
	private WebElement DoctorSpecializationTextField;
	
	@FindBy(xpath = ("//button[@name='submit']"))
	private WebElement SubmitButton;
	
	//Initialization
	
	


	public AddDoctorSpecialization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization

	public WebElement getDoctorSpecializationTextField() {
		return DoctorSpecializationTextField;
	}
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	//Business Logic
	
	public void clickonSubmitButton()
	{
		SubmitButton.click();
	}
	
}


