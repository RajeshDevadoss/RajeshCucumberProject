package com.stepdefinitions;

import com.base.BaseClass;
import com.pages.StudentDashboardPage;
import com.pages.StudentLogin;
import com.pages.StudentProductandSolutionPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadCertificateTestClass {

	StudentDashboardPage studentDashboard;
	StudentProductandSolutionPage studentProductPage;
	BaseClass baseclass = new BaseClass();
	static int coulmnNo;

	@Given("Student should login with id and mobile number")
	public void studentShouldLoginWithIdAndMobileNumber() {
		StudentLogin stdlogin = new StudentLogin();
		stdlogin.enterUsername();
		stdlogin.enterMobileNo();
		stdlogin.clickLoginButton();
		stdlogin.enterOtpTextbox();
		studentDashboard = stdlogin.clickSubmit();
	}

	@When("click on co-curricular achievement dropdown and click certifications button")
	public void clickOnCoCurricularAchievementDropdownAndClickCertificationsButton() {
		studentDashboard.clickcoCurricularAchivDropdown();
		studentProductPage =studentDashboard.clickProductPageStudentButton();
	}
	
	@Then("fill the certification {string} , {string} , {string} and upload certificate")
	public void fillTheCertificationDetailsAndUploadCertificate(String Title, String industry, String StatementPurpose) {
	  
		studentProductPage.enterProductTitle(Title);
		studentProductPage.clickIndustrydropdownbox(industry);
		studentProductPage.enterStatementofPurposeText(StatementPurpose);
		studentProductPage.selectYearOfProduct();
		studentProductPage.uploadPhoto();
		studentProductPage.uploadVideo();
		studentProductPage.clickSubmitButton();
		
	}

	@Then("click on logout button")
	public void clickOnLogoutButton() {
		studentDashboard.clickLogout();
	}
}
