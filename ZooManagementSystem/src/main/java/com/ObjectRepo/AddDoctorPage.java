package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorPage {
	
	//declaration
	
	@FindBy(xpath = ("//input[@name='docname']"))
	private WebElement DoctorNameTextField;
	
	@FindBy(xpath = ("//textarea[@placeholder='Enter Doctor Clinic Address']"))
	private WebElement ClinicAddress;
	
	@FindBy(xpath = ("//input[@placeholder='Enter Doctor Consultancy Fees']"))
	private WebElement DoctorFees;
	
	@FindBy(xpath = ("//input[@placeholder='Enter Doctor Contact no']"))
	private WebElement DoctorContactNo;
	
		@FindBy(xpath = ("//input[@placeholder='Enter Doctor Email id']")) 
	private WebElement DoctorEmailID;
	
	@FindBy(xpath = ("//input[@placeholder='New Password']"))
	private WebElement NewPasswordTextFiled;
	
	@FindBy(xpath = ("//input[@placeholder='Confirm Password']"))
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath = ("//button[@name='submit']"))
	private WebElement AddDoctorSubmitButton;
	
	//initialization
	
	
	public AddDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	
	public WebElement getDoctorNameTextField() {
		return DoctorNameTextField;
	}

	public WebElement getClinicAddress() {
		return ClinicAddress;
	}

	public WebElement getDoctorFees() {
		return DoctorFees;
	}

	public WebElement getDoctorContactNo() {
		return DoctorContactNo;
	}

	public WebElement getDoctorEmailID() {
		return DoctorEmailID;
	}

	public WebElement getNewPasswordTextFiled() {
		return NewPasswordTextFiled;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getAddDoctorSubmitButton() {
		return AddDoctorSubmitButton;
	}

//Business Logic
	
	public void clickonAddDoctorSubmitButton()
	{
		AddDoctorSubmitButton.click();
	}
	
	

}
