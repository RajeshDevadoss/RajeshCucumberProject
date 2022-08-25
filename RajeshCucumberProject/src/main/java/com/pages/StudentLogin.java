package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

import com.web_driver_manager.DriverManager;

public class StudentLogin{
	
	BaseClass baseclass;

	public StudentLogin() {
		baseclass = new BaseClass();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(id="login-student-id")
	private WebElement studentIdTextbox;

	@FindBy(id="login-mobile")
	private WebElement mobileNumberTextbox;

	@FindBy(xpath="//button[@tabindex='4']")
	private WebElement login;

	@FindBy(id="test_otp")
	private WebElement otpText;

	@FindBy(id="login-otp")
	private WebElement otpTextBox;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitButton;

	public void enterUsername() {
		baseclass.waitForElementClickable(studentIdTextbox);

		studentIdTextbox.sendKeys(baseclass.stdId);
	}

	public void enterMobileNo() {

		baseclass.waitForElementClickable(mobileNumberTextbox);
		mobileNumberTextbox.sendKeys(baseclass.mobileNumber);
	}

	public void clickLoginButton() {

		login.click();
	}

	
	public void enterOtpTextbox() {
		baseclass.waitForElementClickable(otpText);
		String otpTextValue = otpText.getText();
		baseclass.waitForElementClickable(otpTextBox);
		otpTextBox.sendKeys(otpTextValue);
	}

	public StudentDashboardPage clickSubmit() {
		
		baseclass.waitForElementClickable(submitButton).click();
		return new StudentDashboardPage();
	}

}
