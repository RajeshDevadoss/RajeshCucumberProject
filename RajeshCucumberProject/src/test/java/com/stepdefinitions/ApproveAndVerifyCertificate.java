package com.stepdefinitions;

import java.util.Map;

import org.testng.Assert;

import com.pages.AdminCoCurricularProductApprovalPage;
import com.pages.AdminHomePage;
import com.pages.AdminLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApproveAndVerifyCertificate {
	
	static AdminLoginPage adminloginPage;
	AdminHomePage adminHomePage;
	static AdminCoCurricularProductApprovalPage adminProductApprovalPage;
	String expectedProductTitle;

	@Given("login to admin with emailId and password")
	public void loginToAdminWithEmailIdAndPassword() {
		adminloginPage = new AdminLoginPage();
		adminloginPage.enterLoginId();
		adminloginPage.enterLoginPassword();
		adminloginPage.clickLoginButton();
	}

	@When("click on co-curricular drop down button from admin page and click certification button")
	public void clickOnCoCurricularDropDownButtonFromAdminPageAndClickCertificationButton() {
		adminHomePage = new AdminHomePage();
		adminHomePage.clickCocurricularButtonAdmin();
		adminHomePage.clickProductButtonAdmin();
	}

	@Then("click pending button and search for a student with Id")
	public void clickPendingButtonAndSearchForAStudentWithId() {
		adminProductApprovalPage = new AdminCoCurricularProductApprovalPage();
		
		expectedProductTitle = adminProductApprovalPage.pendingProductValue();
		adminProductApprovalPage.clickPendingPageButton();
		adminProductApprovalPage.selectEntryShowLimit();
		adminProductApprovalPage.searchForStudent();
	}

	@When("select certificate and click approve button")
	public void selectCertificateAndClickApproveButton() throws Exception {
		adminProductApprovalPage.approveProduct();
	}

	@Then("click logout button on admin page")
	public void clickLogoutButtonOnAdminPage() {
		adminloginPage.clickAdminLogout();
	}

	/**
	 * decline certificate
	 * @throws Exception 
	 */
	@When("select certificate and click decline button")
	public void selectCertificateAndClickDeclineButton() throws Exception {
		adminProductApprovalPage.declineProduct();
	}

	/**
	 * search for a student in approved certificate page
	 * 
	 * @param string
	 */
	@Then("click approved button and search for a student with Id")
	public void clickApprovedButtonAndSearchForAStudentWithId() {
		expectedProductTitle = adminProductApprovalPage.approveProductValue();
		adminProductApprovalPage.clickApprovePageButton();
		adminProductApprovalPage.selectEntryShowLimit();
		adminProductApprovalPage.searchForStudent();
	}

	/**
	 * search for a student in declined certificate page
	 * 
	 * @param string
	 */
	@Then("click decline button and search for a student with Id")
	public void clickDeclineButtonAndSearchForAStudentWithId() {
		expectedProductTitle = adminProductApprovalPage.declineProductValue();
		adminProductApprovalPage.clickDeclinePageButton();
		adminProductApprovalPage.selectEntryShowLimit();
		adminProductApprovalPage.searchForStudent();
	}

	@Then("verify the certificate title")
	public void verifyTheCertificateTitle() {
		Map<String, String> certificateTitleAndStdId = adminProductApprovalPage
				.productTitleAndStdId(expectedProductTitle);
		
		String stdIDActual = certificateTitleAndStdId.get("stdId");
		String certificateTitleActual = certificateTitleAndStdId.get("productTitle");
		String stdID = adminProductApprovalPage.IdValue();
		Assert.assertEquals(stdIDActual, stdID);
		Assert.assertEquals(certificateTitleActual, expectedProductTitle);
	}
}
