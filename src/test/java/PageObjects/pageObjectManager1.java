package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class pageObjectManager1 {
	public WebDriver driver;
	public adminPage ap1;
	public logInPage lp1;
	
	public pageObjectManager1(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public adminPage getadminPage1() throws IOException
	{
		ap1 = new adminPage(driver);
		return ap1;
	}

	public logInPage getloginpage1() throws IOException
	{
		lp1 = new logInPage(driver);
		return lp1;
	}
}
