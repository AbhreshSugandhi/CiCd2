package StepDefinitions;


import Utilities.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ObjectRepo.LoggedInPage_OR;

public class searchFlightStepDefinition extends BaseClass{

	LoggedInPage_OR LoggedInPage_OR = new LoggedInPage_OR();
	
	@Given("^User should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Given("^user should be on Flight Finder Page$")
	public void user_should_be_on_Flight_Finder_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    displayOfElement(LoggedInPage_OR.flightFinderheading);
	}

	@When("^User Fills the details$")
	public void user_Fills_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    click(LoggedInPage_OR.onewayFlight);
	    select(LoggedInPage_OR.passanger, "2");
	    select(LoggedInPage_OR.deprtFrom, "London");
	    select(LoggedInPage_OR.fromMonth, "June");
	    select(LoggedInPage_OR.fromDay, "15");
	    select(LoggedInPage_OR.arivingTo, "New York");
	    select(LoggedInPage_OR.toMonth, "July");
	    select(LoggedInPage_OR.toDay, "1");
	    click(LoggedInPage_OR.businessClass); 
	}

	@When("^Clicks on Continue$")
	public void clicks_on_Continue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		click(LoggedInPage_OR.ContinueSearch);
	}

	@Then("^User Should be navigated to Select Flight Page$")
	public void user_Should_be_navigated_to_Select_Flight_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		displayOfElement(LoggedInPage_OR.selectFlightHeading);
		click(LoggedInPage_OR.continueBooking);
	}
}
