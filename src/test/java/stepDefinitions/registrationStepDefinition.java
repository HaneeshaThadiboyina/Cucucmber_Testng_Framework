package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObjects2.homePage;
import PageObjects2.loginPage;
import PageObjects2.myAccountPage;
import PageObjects2.regPage;
import freemarker.log.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TextContextSetup;

public class registrationStepDefinition {

	public Properties properties;
	public Logger logger;
	TextContextSetup textcontextsetup;
	public homePage hp;
	public regPage rp;
	public loginPage lp;
	public myAccountPage map;

	public registrationStepDefinition(TextContextSetup textcontextsetup) {
		this.textcontextsetup = textcontextsetup;
	}

	public void callingClasses() {
		hp = textcontextsetup.pageobjectmanager2.gethomePage();
		rp = textcontextsetup.pageobjectmanager2.getregPage();
		lp = textcontextsetup.pageobjectmanager2.getloginPage();
		map = textcontextsetup.pageobjectmanager2.getmyAccountPage();
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws IOException {
		callingClasses();
		System.out.println("User launching chrome browser");
	}

	@When("user opens url")
	public void user_opens_url() {
		System.out.println("clicking on the url");
	}

	@Then("click on myaccount")
	public void click_on_myaccount() throws Throwable {

		hp.clickMyAccount();
	}

	@And("click on register")
	public void click_on_register() {
		hp.clickRegister();
	}

	@Then("give the first name as {string}")
	public void give_the_first_name_as(String fname) {

		rp.setFirstName(fname);
	}

	@And("give the last name as {string}")
	public void give_the_last_name_as(String lname) {
		rp.setLastName(lname);
	}

	@Then("give the valid Email as {string}")
	public void give_the_valid_email_as(String email) {
		rp.setEmail(email);
	}

	@And("give the mobile number as {string}")
	public void give_the_mobile_number_as(String num) {
		rp.setMobileNumber(num);
	}

	@Then("give the password and then give the same to confirm pssword as {string}")
	public void give_the_password_and_then_give_the_same_to_confirm_pssword_as(String pass) {
		rp.setPassword(pass);
		rp.setCfmPassword(pass);
	}

	@And("check the check box")
	public void check_the_check_box() {
		rp.setPrivacyPolicy();
	}

	@Then("then click on the continue button")
	public void then_click_on_the_continue_button() {
		rp.clickContinue();
	}

	@And("close the browser")
	public void close_the_browser() {

	}

	/////////////////////////////////// LOGIN PAGE
	/////////////////////////////////// ///////////////////////////////////////////////////

	@And("click on login")
	public void click_on_login() {
		hp.clickLogin();
	}

	@Then("enter the email as {string}")
	public void enter_the_email_as(String mail) {

		lp.setMail(mail);
	}

	@And("then enter the password as {string}")
	public void then_enter_the_password_as(String password) {
		lp.setPassword(password);
	}

	@Then("click on the login button")
	public void click_on_the_login_button() {
		lp.clkLogin();
	}

}
