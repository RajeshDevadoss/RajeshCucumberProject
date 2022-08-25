package com.web_driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManager {
	
	private static WebDriver driver = null;
	
	public static void launchBrowser() {
		try {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}
	

}
