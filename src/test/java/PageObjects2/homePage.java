package PageObjects2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{
	public homePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegiger;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	public void clickMyAccount() throws Throwable
	{
		//uc.waitForElementToBeVisible(driver, lnkMyAccount, 50);
		Thread.sleep(3000);
		//uc.DoubleClick(driver, lnkMyAccount);
		//driver.navigate().refresh();
		//uc.waitForElementToBeVisible(driver, lnkDropDown, 50);
		lnkMyAccount.click();
		
	}
	
	public void clickRegister()
	{
		lnkRegiger.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}


}
