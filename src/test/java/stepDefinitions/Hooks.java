package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.ExtentReportManagers;
import utilities.TextContextSetup;

public class Hooks {
	TextContextSetup textcontextsetup;
	public Hooks(TextContextSetup textcontextsetup)
	{
		this.textcontextsetup = textcontextsetup;
	}
	
	@After
	public void tearDown() throws IOException, InterruptedException
	{
		//Thread.sleep(1000);
		textcontextsetup.testbase.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException 
	{
		if(scenario.isFailed())
		{
			TakesScreenshot takesScreenshot = (TakesScreenshot)textcontextsetup.testbase.webDriverManager();
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			byte[] filecontent =  FileUtils.readFileToByteArray(sourceFile);
			scenario.attach(filecontent, "image/png", "image");
		}
	}	

}
