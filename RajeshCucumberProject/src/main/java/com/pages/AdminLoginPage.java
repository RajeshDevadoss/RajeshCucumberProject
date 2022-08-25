package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.web_driver_manager.DriverManager;

public class AdminLoginPage {
	
	BaseClass baseclass;

	public AdminLoginPage() {
		baseclass = new BaseClass();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(id = "login-email")
	private WebElement loginIdTextbox;

	@FindBy(id = "login-password")
	private WebElement loginPasswordTextbox;

	@FindBy(xpath = "//*[text()='Log in']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@href='http://maplogik.com/index.php/admin/logout']")
	private WebElement adminLogoutButton;

	public void enterLoginId() {
		loginIdTextbox.sendKeys(baseclass.adminId);
	}

	public void enterLoginPassword() {
		loginPasswordTextbox.sendKeys(baseclass.adminPassword);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickAdminLogout() {
		adminLogoutButton.click();
	}
}
