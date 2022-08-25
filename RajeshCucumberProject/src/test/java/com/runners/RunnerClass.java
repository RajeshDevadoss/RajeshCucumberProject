package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"./src/test/java/com/features"},
				glue = {"com.stepdefinitions","com.hooks"}, 
				dryRun = false,
				tags = "@adminLogin",
				snippets = SnippetType.CAMELCASE,
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true)

public class RunnerClass extends AbstractTestNGCucumberTests {

}
