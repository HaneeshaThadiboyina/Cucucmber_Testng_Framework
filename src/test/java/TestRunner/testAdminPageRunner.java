package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = "src\\test\\resources\\Features\\AdminPage.feature",
		glue = "stepDefinitions",
		dryRun = false,
	    monochrome = true,
		plugin = {"pretty","html:test-output/index.html"}
		)

public class testAdminPageRunner extends AbstractTestNGCucumberTests{

}
