package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

//import utilities.WaitHelper;

public class logInPage {

	WebDriver ldriver;
	waitHelper wh;
	public logInPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new waitHelper(ldriver);
	}
	
	@FindBy(xpath = "//input[@name='username']") WebElement txtuserName;
	@FindBy(xpath = "//input[@name='password']") WebElement txtpassword;
	@FindBy(xpath = "//button[@type='submit']") WebElement loginbtn;
	@FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logoutbtn;
	
	public void setUsername(String un) throws InterruptedException
	{
		txtuserName.clear();
		//Thread.sleep(3000);
		txtuserName.sendKeys(un);
	}
	
	public void setPassword(String pass) throws InterruptedException
	{
		txtpassword.clear();
		//Thread.sleep(3000);
		wh.waitForElement(txtpassword, 20);
		txtpassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	


	
}
