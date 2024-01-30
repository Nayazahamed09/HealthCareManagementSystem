package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashBoardPage {

	@FindBy(xpath = " //span[text()=' Book Appointment ']")
	private WebElement BookAppointmentbutton;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHisrorypage;
	
	@FindBy(xpath = "//span[text()=' Medical History ']")
	private WebElement MedicalHistorypage;
	
	//initialization
	
	public PatientDashBoardPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	 	
	//utilization
	
	public WebElement getBookAppointmentbutton() {
		return BookAppointmentbutton;
	}

	public WebElement getAppointmentHisrorypage() {
		return AppointmentHisrorypage;
	}

	public WebElement getMedicalHistorypage() {
		return MedicalHistorypage;
	}

	
	
}
