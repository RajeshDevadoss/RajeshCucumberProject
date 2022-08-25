package com.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.web_driver_manager.DriverManager;

public class AdminCoCurricularProductApprovalPage {
	
	BaseClass baseclass;

	public AdminCoCurricularProductApprovalPage() {
		baseclass = new BaseClass();
	
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id='basic-datatable'] //div[@class='col-sm-3'][2]")
	private WebElement approvedProductPageButton;

	@FindBy(xpath = "//*[@id='basic-datatable'] //div[@class='col-sm-3'][4]")
	private WebElement declinedProductPageButton;

	@FindBy(xpath = "//*[@id='basic-datatable'] //div[@class='col-sm-3'][3]")
	private WebElement pendingProductPageButton;

//	@FindBy(xpath = "//*[text()='Approved Product Solution']")
//	private WebElement approvedProductPageButton;
//
//	@FindBy(xpath = "//*[text()='Decline Product Solution']")
//	private WebElement declinedProductPageButton;
//
//	@FindBy(xpath = "//*[text()='pending Product Solution']")
//	private WebElement pendingProductPageButton;

	@FindBy(xpath = "//*[@type='search']")
	private WebElement searchTab;

	@FindBy(xpath = "//*[@name='datatable_length']")
	private WebElement showEntries;

	@FindBy(xpath = "//*[@id='datatable']/tbody/tr/td[3]")//*[@id="datatable"]/tbody/tr[1]/td[3]
	private List<WebElement> pendingProductTitles;        //*[@id="datatable"]/tbody/tr[2]/td[3]

	@FindBy(xpath = "(//*[@type='submit'])[2]")
	private WebElement approveProductButton;

	@FindBy(xpath = "(//*[@type='submit'])[1]")
	private WebElement declineProductButton;

	public void selectEntryShowLimit() {
		baseclass.selectByText(showEntries, baseclass.showEntryLimit);
	}

	public void searchForStudent() {
		searchTab.clear();
		searchTab.sendKeys(baseclass.stdId);
	}
	
	public String pendingProductValue() {
		String pending = baseclass.pendingProduct;
		return pending;
	}
	
	public String approveProductValue() {
		String approve = baseclass.approveProduct;
		return approve;
	}
	
	public String declineProductValue() {
		String decline = baseclass.declineProduct;
		return decline;
	}
	
	public String IdValue() {
		String id = baseclass.stdId;
		return id;
	}

	private void findingProductMatch(String productTitle) {
		int index = 1;
		List<WebElement> allPendingTitles = pendingProductTitles;
		for (WebElement titles : allPendingTitles) {//*[@id="datatable"]/tbody/tr[1]/td[5]/a[1]
			String productDetailPage = "//*[@id=\"datatable\"]/tbody/tr["+index+"]/td[5]/a[1]";
			if (titles.getText().equalsIgnoreCase(productTitle)) {
				WebElement product = DriverManager.getDriver().findElement(By.xpath(productDetailPage));
				baseclass.waitForElementClickable(product).click();
				break;
			} else {
				index++;
			}
		}
	}

	public void approveProduct() {
		String productTitle = baseclass.approveProduct;
		try {
			findingProductMatch(productTitle);
			baseclass.waitForElementClickable(approveProductButton).click();
			//approveProductButton.click();
		} catch (Exception e) {
			
		}
	}

	public void declineProduct() {
		String productTitle = baseclass.declineProduct;
		try {
			findingProductMatch(productTitle);
			baseclass.waitForElementClickable(declineProductButton).click();
		//	declineProductButton.click();
		} catch (Exception e) {
			
		}
	}

	public void clickPendingPageButton() {
		baseclass.waitForElementClickable(pendingProductPageButton).click();
	}

	public void clickApprovePageButton() {
		baseclass.waitForElementClickable(approvedProductPageButton).click();
	}

	public void clickDeclinePageButton() {
		baseclass.waitForElementClickable(declinedProductPageButton).click();
	}

	/**
	 * Fetching the certificate title and id from application for title verification
	 * 
	 * @param certifTitle
	 * @return
	 */
	public Map<String, String> productTitleAndStdId(String productTitle) {
		int index = 1;
		Map<String, String> productTitleAndStdId = new HashMap<>();
		List<WebElement> allPendingTitles = pendingProductTitles; // common for all pages
		try {
			for (WebElement titles : allPendingTitles) {
				if (titles.getText().equalsIgnoreCase(productTitle)) {
					String stdIdFetchXpath = "//*[@id='datatable']/tbody/tr[" + index + "]/td[1]";
					String stdIdFetched = baseclass.findElement(By.xpath(stdIdFetchXpath)).getText();
					productTitleAndStdId.put("productTitle", titles.getText());
					productTitleAndStdId.put("stdId", stdIdFetched);
					break;
				} else {
					index++;
				}
			}
		} catch (Exception e) {
		}
		return productTitleAndStdId;
	}
}
