package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = "src\\test\\resources\\Features\\LoginPageValidation.feature",
		glue = "stepDefinitions",
		dryRun = false,
	    monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json",  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt"}
		)
public class TestloginPageRunner extends AbstractTestNGCucumberTests {

}
