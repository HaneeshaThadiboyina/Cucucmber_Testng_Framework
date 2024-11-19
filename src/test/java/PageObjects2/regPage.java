package PageObjects2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class regPage extends basePage {

	public regPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtMailId;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtNumber;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassWord;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtCfmpassWord;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkButton;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtMailId.sendKeys(email);
	}

	public void setMobileNumber(String number) {
		txtNumber.sendKeys(number);
	}

	public void setPassword(String password) {
		txtpassWord.sendKeys(password);
	}

	public void setCfmPassword(String password) {
		txtCfmpassWord.sendKeys(password);
	}

	public void setPrivacyPolicy() {
		chkButton.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmation() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}


	
}
