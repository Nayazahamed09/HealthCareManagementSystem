package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewPatientPage {
	
	//declaration
	
	@FindBy(xpath = ("//input[@id='searchdata']"))
			private WebElement SearchDataTextField;
	
	@FindBy(xpath = ("//button[@name='search']"))
	
	private WebElement PatientSearchButton;
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement PatientLink;
	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement ManagePatientLink;

	//initialization
	
	public AdminViewPatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		

	}

	
	
	//utilization
	public WebElement getSearchDataTextField() {
		return SearchDataTextField;
	}

	public WebElement getPatientSearchButton() {
		return PatientSearchButton;
		
	}
	public WebElement getPatientLink() {
		return PatientLink;
	}



	public WebElement getManagePatientLink() {
		return ManagePatientLink;
	}
	
	// Business logic
	
	public void patientSearchButton()
	{
		PatientSearchButton.click();
		
	}
	public void getAdminPatientLink()
	{
		PatientLink.click();
	}
	public void getAdminManagePatientLink()
	{
		ManagePatientLink.click();
	}



	
	
}
