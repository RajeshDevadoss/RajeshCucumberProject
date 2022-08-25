package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.web_driver_manager.DriverManager;

public class StudentProductandSolutionPage {
	
	BaseClass baseclass;

	public StudentProductandSolutionPage() {
		baseclass = new BaseClass();

		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	//'button.picker__button--today'
	private String selectGivenDate = "04-08-2022";

	@FindBy(name = "title")
	private WebElement productTitleTextbox;

	@FindBy(name = "industry")
	private WebElement industryDropdownBox;

	@FindBy(name = "purpose")
	private WebElement statementOfPurposeTextbox;

	@FindBy(name = "year")
	private WebElement yearOfdevelopementButton;

	@FindBy(xpath = "//input[@id='photo']")
	private WebElement productPicUpload;
	
	@FindBy(xpath = "//input[@name ='video']")
	private WebElement productVideoUpload;

	@FindBy(id = "submitbtn")
	private WebElement submitButton;


	public void enterProductTitle(String Title) {
		
		productTitleTextbox.sendKeys(Title);
	}
	
	public void clickIndustrydropdownbox(String industry) {
		
		baseclass.selectByText(industryDropdownBox, industry);
	}

	public void enterStatementofPurposeText(String StatementPurpose) {
		statementOfPurposeTextbox.sendKeys(StatementPurpose);
	}


	public void selectYearOfProduct() {
		yearOfdevelopementButton.click();
		//baseclass.jsClick(selectTodayDateCss);
		//baseclass.selectByText(yearOfdevelopementButton, selectTodayDateCss);
		yearOfdevelopementButton.sendKeys(selectGivenDate);
	}

	public void uploadPhoto() {
		baseclass.uploadFile(productPicUpload, baseclass.photoLocation);
	}
	
	public void uploadVideo() {
		baseclass.uploadFile(productVideoUpload, baseclass.videoLocation);
	}

	public void clickSubmitButton() {
		baseclass.waitForElementClickable(submitButton).click();
		//submitButton.click();
	}
}
