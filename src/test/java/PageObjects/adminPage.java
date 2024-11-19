package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

//import utilities.WaitHelper;

public class adminPage {
	
	WebDriver ldriver;
	waitHelper wh;
	public Properties P;

	public adminPage(WebDriver rdriver) throws IOException {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new waitHelper(ldriver);

	}

	@FindBy(xpath = "//span[normalize-space()='Admin']")
	WebElement adminbtn;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement addbtn;
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement roledropdown;
	@FindBy(xpath = "//div[@role='listbox']/div[@class='oxd-select-option']")
	List<WebElement> seladminoptions;
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	WebElement statusdropdownbtn;
	@FindBy(xpath = "//div[@role='listbox']/div[@class='oxd-select-option']")
	List<WebElement> setstatusoptions;
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement txtname;
	@FindBy(xpath = "//div[@role='listbox']/div[@class='oxd-autocomplete-option']")
	List<WebElement> empoptions;
	@FindBy(xpath = "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
	WebElement txtusername;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input[@type='password']")
	WebElement txtpassword;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']/div//input[@type='password']")
	WebElement txtcfrpassword;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement savebtn;

	public void clickAdmin() {
		adminbtn.click();
	}

	public void clickAdd() {
		addbtn.click();
	}

	public void clickroledropdown() {
		wh.waitForElement(roledropdown, 10);
		roledropdown.click();
	}

	public void clickstatusdropdownbtn() {
		wh.waitForElement(statusdropdownbtn, 10);
		statusdropdownbtn.click();
	}

	public void seladminoptions(String op) {
		wh.waitForElements(seladminoptions, 20);
		for (WebElement option : seladminoptions) {
			try {
				String data = option.getText();
				System.out.println(data);
				if (data.equals(op)) {
					option.click();
					System.out.println("option is" + data);
					break;
				}
			} catch (Exception e) {
				String data = option.getText();
				System.out.println(data);
				if (data.equals(op)) {
					option.click();
					System.out.println("option is" + data);
				}
			}
		}

	}

	public void setstatusoptions(String status) {
		wh.waitForElements(setstatusoptions, 20);
		for (WebElement option : setstatusoptions) {
			try {
				String data = option.getText();
				System.out.println("status option is" + data);
				if (data.equals(status)) {
					System.out.println("status option is" + data);
					option.click();
					break;
				}
			} catch (Exception e) {
				String data = option.getText();
				if (data.equals(status)) {
					option.click();
				}
			}
		}
	}

	public void setempname(String empname) throws InterruptedException, IOException
	{
		txtname.sendKeys(empname);
		Thread.sleep(3000);
		wh.waitForElements(empoptions,30);
		//loading cofig.properties file
				FileInputStream propfile = new FileInputStream("src\\test\\resources\\config.Properties");
				//FileReader file = new FileReader("Opencart_Hybrid_Framework\\src\\test\\resources\\config.properties");
				P = new Properties();
				P.load(propfile);
		String validemp = P.getProperty("EMP");
		
		int size = empoptions.size();
		for(int i=0;i<size;i++)
		{
			String name = empoptions.get(i).getText();
			System.out.println("emp name is :"+name);
			if(name.equals(validemp))
			{
				empoptions.get(i).click();
				break;
			}
		}
//		for (WebElement emp : empoptions) 
//		{
//			try{
//				String data = emp.getText();
//				System.out.println("emp name is"+data);
//				if(data.equals(empname))
//				{
//					System.out.println("emp name is"+data);
//					emp.click();
//					break;
//				}
//			}catch(Exception e)
//			{
//				String data = emp.getText();
//				System.out.println("emp name is"+data);
//				if(data.equals(empname))
//				{
//					System.out.println("emp name is"+data);
//					emp.click();
//				}
//			}
//		}
	}

	public void setusername(String username) {
		txtusername.sendKeys(username);
	}

	public void setpassword(String pass) {
		txtpassword.sendKeys(pass);
		txtcfrpassword.sendKeys(pass);
	}

	public void Clicksave() {
		savebtn.click();
	}
}



