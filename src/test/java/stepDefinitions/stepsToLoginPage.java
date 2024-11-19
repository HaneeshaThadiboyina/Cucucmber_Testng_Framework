package stepDefinitions;

import static org.testng.Assert.fail;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.adminPage;
import PageObjects.logInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TextContextSetup;


public class stepsToLoginPage {

	public WebDriver driver;
    TextContextSetup textcontextsetup;
	public logInPage lp;
	public adminPage ap;
	
	public stepsToLoginPage(TextContextSetup textcontextsetup)
	{
		this.textcontextsetup = textcontextsetup;
		
	}
	
	public void GetClasses() throws IOException
	{
		lp = textcontextsetup.pageobjectmanager1.getloginpage1();
		ap = textcontextsetup.pageobjectmanager1.getadminPage1();
	}
	
	@Given("User invoke chrome browser")
	public void user_invoke_chrome_browser() throws IOException {
		GetClasses();
	}
	
	@When("user opens url  {string}")
	public void user_opens_url(String url) throws IOException {
		textcontextsetup.testbase.webDriverManager().get(url);
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) throws InterruptedException {
	    lp.setUsername(username);
	    lp.setPassword(password);
	}

	@When("User click on the ligin button")
	public void user_click_on_the_ligin_button() throws InterruptedException {
	   lp.clickLogin();
	   Thread.sleep(3000);
	}

	
	@Then("validate the title {string}")
	public void validate_the_title(String title) throws IOException {
		String Title = textcontextsetup.testbase.webDriverManager().getTitle();
		if(Title.equals(title))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			Assert.fail();
		}
	}

	@Then("close the browser using quit")
	public void close_browser() {
	}
	
	
	
	//******************************************************************************************************//
	
	
	@Then("click on admin button")
	public void click_on_admin_button() {
	   ap.clickAdmin();
	}

	@Then("click on the add button")
	public void click_on_the_add_button() throws InterruptedException {
		Thread.sleep(5000);
	    ap.clickAdd();
	}

	@Then("click on the dropdown of the role and select role as {string}")
	public void click_on_the_dropdown_of_the_role_and_select_role_as(String adminop) throws InterruptedException {
		Thread.sleep(5000);
	   ap.clickroledropdown();
	   ap.seladminoptions(adminop);
	}

	@Then("click on the dropdown of the status and select status as {string}")
	public void click_on_the_dropdown_of_the_status_and_select_status_as(String statusop) throws InterruptedException {
		Thread.sleep(5000);
	   ap.clickstatusdropdownbtn();
	   ap.setstatusoptions(statusop);
	}

	@Then("enter on the empname as {string}")
	public void enter_on_the_empname_as(String emn) throws InterruptedException, IOException {
		Thread.sleep(3000);
	   ap.setempname(emn);
	}

	@Then("enter the username as {string}")
	public void enter_the_username_as(String usn) throws InterruptedException {
		Thread.sleep(3000);
	    ap.setusername(usn);
	}

	@Then("enter the password and confirm password as {string}")
	public void enter_the_password_and_confirm_password_as(String password) {
	   ap.setpassword(password);
	}

	@Then("click on save button")
	public void click_on_save_button() {
	    ap.Clicksave();
	}


	
}
