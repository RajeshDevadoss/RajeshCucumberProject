package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;
import com.web_driver_manager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class HookClass extends BaseClass {

	@BeforeAll
	public static void launchBrowser() {
		DriverManager.launchBrowser();
	}

	@Before(order = 0, value = "@studentLogin")
	public void studentLoginPage() {
		
		stdLoginUrl();
	}

	@Before(order = 1, value = "@adminLogin")
	public void adminLoginPage() {

		adminLogin();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String scName = scenario.getName();
			byte[] sourceSc = ((TakesScreenshot) (DriverManager.getDriver())).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceSc, "image/png", scName);
		}
	}

	@AfterAll
	public static void closeBrowse() {
		tearDown();
	}

}
