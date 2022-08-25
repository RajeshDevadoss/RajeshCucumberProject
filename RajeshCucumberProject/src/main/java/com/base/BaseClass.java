package com.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web_driver_manager.DriverManager;



public class BaseClass{
	
	public BaseClass() {
		loadProperties();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	private WebDriverWait wait;
	public static  String studentUrl;
	public  String waitwaitTimeInSec;
	//public static String product;
	public  String videoLocation;
	public  String photoLocation;
	public  String stdId;
	public  String mobileNumber;
	public static  String adminUrl;
	public  String adminId;
	public  String adminPassword;
	public  String showEntryLimit;
	public  String approveProduct;
	public  String declineProduct;
	public  String pendingProduct;
	
	public void loadProperties() {
		
		Properties properties = new Properties();
		
		try {
			
			properties.load(getClass().getResourceAsStream("/config.properties"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitwaitTimeInSec =  properties.getProperty("waitwaitTimeInSec");
		showEntryLimit = properties.getProperty("showEntryLimit");
		studentUrl = properties.getProperty("studentLoginUrl");
	//	product = properties.getProperty("product");
	//	statementText = properties.getProperty("statementText");
		photoLocation = properties.getProperty("photoLocation");
		videoLocation = properties.getProperty("videoLocation");
		stdId = properties.getProperty("studentId");
		mobileNumber = properties.getProperty("mobileNumber");
		adminUrl = properties.getProperty("adminLoginUrl");
		adminId = properties.getProperty("adminEmailId");
		adminPassword = properties.getProperty("adminPassword");
		approveProduct = properties.getProperty("approveProduct");
		declineProduct = properties.getProperty("declineProduct");
		pendingProduct = properties.getProperty("pendingProduct");
	}
	
	public WebElement waitForElementClickable(WebElement webElement) {
		int waitTime = Integer.parseInt(waitwaitTimeInSec);
		wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public void selectByText(WebElement element, String text) {
		//WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void uploadFile(WebElement element, String directory) {
		element.sendKeys(new File(directory).getAbsolutePath());
	}
	
//	public void jsClick(String cssSelector) {
//		//((JavascriptExecutor) DriverManager.getDriver()).executeScript("document.querySelector("+cssSelector+").click()");
//		
//	}
	
	public WebElement findElement(By locator) {
		return DriverManager.getDriver().findElement(locator);
	}
	
	public static void stdLoginUrl() {
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().get(studentUrl);
	}
	
	public static void adminLogin() {
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().get(adminUrl);
	}

	public static void tearDown() {
		DriverManager.getDriver().quit();
	}

}
