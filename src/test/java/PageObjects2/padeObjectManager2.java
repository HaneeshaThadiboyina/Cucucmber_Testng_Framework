package PageObjects2;

import org.openqa.selenium.WebDriver;

public class padeObjectManager2 {
	public WebDriver driver;
	public homePage hp;
	public loginPage lp;
	public regPage rp;
	public myAccountPage map;

	public padeObjectManager2(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public homePage gethomePage()
	{
		 hp = new homePage(driver);
		return hp;
	}
	
	public loginPage getloginPage()
	{
		 lp = new loginPage(driver);
		return lp;
	}
	
	public regPage getregPage()
	{
		 rp = new regPage(driver);
		return rp;
	}
	
	public myAccountPage getmyAccountPage()
	{
		 map = new myAccountPage(driver);
		return map;
	}
	
}
