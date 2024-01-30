package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	
	//declaration
	
	@FindBy(name = "patname")
	private WebElement PatientNameTextField;
	
	@FindBy(name = "patcontact")
	private WebElement PatientContactNoTextField;
	
	@FindBy(name = "patemail")
	private WebElement PatientEmailTxtField;
	
	@FindBy(name = "//label[contains(text(),'Male')]")
	private  WebElement RadioButton;
	
	@FindBy(name = "patage")
	private WebElement PatientAge;
	
		@FindBy(name = "medhis")
	private WebElement MedicalHistorytextField;
	
	//initialization
	
	public AddPatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization
	
	public WebElement getPatientNameTextField() {
		return PatientNameTextField;
	}

	public WebElement getPatientContactNoTextField() {
		return PatientContactNoTextField;
	}

	public WebElement getPatientEmailTxtField() {
		return PatientEmailTxtField;
	}

	public WebElement getRadioButton() {
		return RadioButton;
	}

	public WebElement getPatientAge() {
		return PatientAge;
	}

	public WebElement getMedicalHistorytextField() {
		return MedicalHistorytextField;
	}


	
	


}
