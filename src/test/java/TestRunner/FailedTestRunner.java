package TestRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "@target/failed_scenarios.txt", 
		glue = "stepDefinitions", 
		dryRun = false, 
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt" }
		)
//use this in plugin for extent reports in runner class "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

public class FailedTestRunner extends AbstractTestNGCucumberTests{
	//to run parallel scenarios from runner class
		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
}
}
