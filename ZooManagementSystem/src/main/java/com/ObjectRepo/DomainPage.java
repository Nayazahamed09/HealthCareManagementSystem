package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DomainPage {
	
	//deceleration
	
	@FindBy(xpath = "(//a[text()='Click Here'])[3]")
	private WebElement AdminClickHereLink;
	
	@FindBy(xpath =("(//a[text()='Click Here'])[2]"))
	private WebElement DoctorClickLink;
	
	@FindBy(xpath = ("(//a[text()='Click Here'])[1]"))
			private WebElement PatientclickLink;
	
	
	
	
	
	
	
	
	//initialization
	
	
	public DomainPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public WebElement getAdminClickHereLink() {
		return AdminClickHereLink;
	}

	public WebElement getDoctorClickLink() {
		return DoctorClickLink;
	}

	public WebElement getPatientclickLink() {
		return PatientclickLink;
	}




}
