package StepDefinitions;

import ObjectRepo.LoggedInPage_OR;
import ObjectRepo.Login_OR;
import Utilities.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BaseClass {

	Login_OR login_OR = new Login_OR();
	LoggedInPage_OR LoggedInPage_OR = new LoggedInPage_OR();

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		openBrowser("Chrome");
		openUrl(testDataValue.get("AppURL"));
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		enterTxt(login_OR.userName, testDataValue.get("Username"));
		enterTxt(login_OR.password, testDataValue.get("Password"));
		click(login_OR.signIn);
	}

	@Then("^Success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		displayOfElement(LoggedInPage_OR.logout);
	}
	
	

}
