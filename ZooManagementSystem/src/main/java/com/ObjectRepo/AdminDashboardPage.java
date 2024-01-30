package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	
	//Declaration
	
	@FindBy(xpath = ("//i[@class='ti-angle-down']"))
	private  WebElement AdminIcon;
	
	@FindBy(xpath = ("//a[contains(text(),'Log Out')]"))
	private WebElement logoutbutton;
	
	@FindBy(xpath = (" //span[text()=' Doctors ']"))
	private WebElement DoctorLink;
	
	@FindBy(xpath = (" //span[text()=' Doctor Specialization ']"))
	private WebElement DoctorSpecializationLink;
	
	@FindBy(xpath = (" //span[text()=' Add Doctor']"))
	private WebElement AddDoctorLink;
	
	@FindBy(xpath = ("//span[text()=' Manage Doctors ']"))
	private WebElement ManageDoctorsLink;
	
	@FindBy(xpath = ("//span[text()=' Users ']"))
	private WebElement UsersLink;
	
	@FindBy(xpath = ("//span[text()=' Manage Users ']"))
	private WebElement ManageUsersLink;
	
	@FindBy(xpath = ("//span[text()=' Patients ']"))
	private WebElement PatientLink;
	
	@FindBy(xpath = ("//span[text()=' Manage Patients ']"))
	private WebElement ManagePatientLink;
	
	@FindBy(xpath = ("//span[text()=' Appointment History ']"))
	private WebElement AppointmentHistoryLink;
	
	@FindBy(xpath = ("//span[text()=' Doctor Session Logs ']"))
	private WebElement DoctorSessionLogs;
	
	@FindBy(xpath = ("//span[text()=' User Session Logs ']"))
	private WebElement UserSessionLogs;
	
	@FindBy(xpath = ("//span[text()=' Reports ']"))
	private WebElement ReportsLink;
	
	@FindBy(xpath = ("//span[text()=' Patient Search ']"))
	private WebElement PatientSearch;
	
	//initialization
	
	public AdminDashboardPage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);	
	}

		
	//utilization
	
	public WebElement getAdminIcon() {
		return AdminIcon;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}

	public WebElement getDoctorLink() {
		return DoctorLink;
	}

	public WebElement getDoctorSpecializationLink() {
		return DoctorSpecializationLink;
	}

	public WebElement getAddDoctorLink() {
		return AddDoctorLink;
	}

	public WebElement getManageDoctorsLink() {
		return ManageDoctorsLink;
	}

	public WebElement getUsersLink() {
		return UsersLink;
	}

	public WebElement getManageUsersLink() {
		return ManageUsersLink;
	}

	public WebElement getPatientLink() {
		return PatientLink;
	}

	public WebElement getManagePatientLink() {
		return ManagePatientLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return AppointmentHistoryLink;
	}

	public WebElement getDoctorSessionLogs() {
		return DoctorSessionLogs;
	}

	public WebElement getUserSessionLogs() {
		return UserSessionLogs;
	}

	public WebElement getReportsLink() {
		return ReportsLink;
	}

	public WebElement getPatientSearch() {
		return PatientSearch;
	}

	//Business Logic
	
	public void clickonAdminModuleElements()
	{
		AdminIcon.click();
		logoutbutton.click();
		DoctorLink.click();
		DoctorSpecializationLink.click();
		AddDoctorLink.click();
		ManageDoctorsLink.click();
		 UsersLink.click();
		 ManageUsersLink.click();
		 PatientLink.click();
		 ManagePatientLink.click();
		 AppointmentHistoryLink.click();
		 DoctorSessionLogs.click();
		 UserSessionLogs.click();
		 ReportsLink.click();
		 PatientSearch.click();
	}
	
	

}
