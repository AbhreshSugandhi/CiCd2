package ObjectRepo;

import org.openqa.selenium.By;

public class LoggedInPage_OR {

	public By logout = By.linkText("SIGN-OFF");
	public By flightFinderheading = By.xpath("//img[contains(@src,'flightfinder')]");
	public By onewayFlight  = By.xpath("//*[@value='oneway']");
	public By passanger = By.xpath("//*[@name='passCount']");
	public By deprtFrom = By.xpath("//*[@name='fromPort']");
	public By fromMonth = By.xpath("//*[@name='fromMonth']");
	public By fromDay = By.xpath("//*[@name='fromDay']");
	public By arivingTo = By.xpath("//*[@name='toPort']");
	public By toMonth = By.xpath("//*[@name='toMonth']");
	public By toDay = By.xpath("//*[@name='toDay']");
	public By businessClass = By.xpath("//*[@value='Business']");
	public By ContinueSearch = By.xpath("//*[@name='findFlights']");
	public By selectFlightHeading = By.xpath("//*[contains(@src,'selectflight')]"); 
	public By continueBooking = By.xpath("//*[@name=\"reserveFlights\"]");
	
}
