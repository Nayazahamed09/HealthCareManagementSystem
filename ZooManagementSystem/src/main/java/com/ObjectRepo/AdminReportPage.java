package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminReportPage {
	
	//declaration
	
	@FindBy(xpath = ("//input[@name='fromdate']"))
	private WebElement FromDateTextField;
	
	@FindBy(xpath = ("//input[@id='todate']"))
	private  WebElement TodateTextField;
	
	@FindBy(xpath = ("//button[@id='submit']"))
	private WebElement ReportSubmitButton;
	
	//initialization
	
	public AdminReportPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	// utilization

	public WebElement getFromDateTextField() {
		return FromDateTextField;
	}

	public WebElement getTodateTextField() {
		return TodateTextField;
	}

	public WebElement getReportSubmitButton() {
		return ReportSubmitButton;
	}
	
	

}
