package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.web_driver_manager.DriverManager;

public class AdminHomePage {
	
	BaseClass baseclass;
	
	public AdminHomePage() {
		baseclass = new BaseClass();

		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()='Co Curricular Achievements']")
	private WebElement AdminCoCurricularAchivDropdownButton;

	@FindBy(xpath = "//*[text()='Product / Solution Development']")
	private WebElement productPageAdminButton;
	
	public void clickCocurricularButtonAdmin() {
		baseclass.waitForElementClickable(AdminCoCurricularAchivDropdownButton).click();
	}
	
	public void clickProductButtonAdmin() {
		baseclass.waitForElementClickable(productPageAdminButton).click();
		
	}
}
