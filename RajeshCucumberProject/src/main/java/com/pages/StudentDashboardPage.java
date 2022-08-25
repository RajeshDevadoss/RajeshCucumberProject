package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.web_driver_manager.DriverManager;

public class StudentDashboardPage {
	
	BaseClass baseclass;

	public StudentDashboardPage() {
		baseclass = new BaseClass();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Co Curricular Achievements']")
	private WebElement coCurricularAchivDropdown;
	
	@FindBy(xpath = "//*[text()='Product / Solution Development']")
	private WebElement productPageStudentButton;
	
	@FindBy(xpath = "//*[@href='http://maplogik.com/index.php/student/logout']")
	private WebElement logOut;
	

	public StudentProductandSolutionPage goToProductPage() {
		baseclass.waitForElementClickable(coCurricularAchivDropdown).click();
		baseclass.waitForElementClickable(productPageStudentButton).click();
		return new StudentProductandSolutionPage();
	}

	public void clickcoCurricularAchivDropdown() {
		baseclass.waitForElementClickable(coCurricularAchivDropdown).click();
	}
	
	public StudentProductandSolutionPage clickProductPageStudentButton() {
		baseclass.waitForElementClickable(productPageStudentButton).click();
		return new StudentProductandSolutionPage();
	}
	
	public void clickLogout() {
		logOut.click();
	}
}
