package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashBoard {
	
	//declaration
	
	@FindBy(xpath = (" //span[text()='Appointment History']"))
	private WebElement patientAppointmentHistory;
	
	@FindBy(xpath = (" //span[text()=' Patients '] "))
	private WebElement PatientLink;
	
	@FindBy(xpath = (" //span[text()=' Add Patient']"))
	private WebElement AddPatientLink;
	
	@FindBy(xpath = (" //span[text()=' Manage Patient ']"))
	private WebElement ManagePatientLink;
	
	//initialization
	
	public DoctorDashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		//utilization
	public WebElement getPatientAppointmentHistory() {
		return patientAppointmentHistory;
	}

	public WebElement getPatientLink() {
		return PatientLink;
	}

	public WebElement getAddPatientLink() {
		return AddPatientLink;
	}

	public WebElement getManagePatientLink() {
		return ManagePatientLink;
	}
	
	
	

}
