package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.pageObjectManager1;
import PageObjects2.padeObjectManager2;

public class TextContextSetup {

	public WebDriver driver;
	public pageObjectManager1 pageobjectmanager1;
	public padeObjectManager2 pageobjectmanager2;
	public TestBase testbase;
	
	
	public TextContextSetup() throws IOException
	{
		testbase = new TestBase();
		pageobjectmanager1 = new pageObjectManager1(testbase.webDriverManager());
		pageobjectmanager2 = new padeObjectManager2(testbase.webDriverManager());
	}
}
