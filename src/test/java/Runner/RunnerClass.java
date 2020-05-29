package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Utilities.BaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\abhre\\Documents\\GSync\\PCSync\\Programs_WorkSpace\\MVNCucumberSelenium\\src\\test\\java\\Features",
		glue = "StepDefinitions",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/reports.html"},
		monochrome = true)

public class RunnerClass {	
	
	@BeforeClass
	public static void readData() throws Exception {
		BaseClass.readTestDataFile("C:\\Users\\abhre\\Documents\\GSync\\PCSync\\Programs_WorkSpace\\MVNCucumberSelenium\\TestData\\NewToursTestData.xlsx", "1");
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("C:\\Users\\abhre\\Documents\\GSync\\PCSync\\Programs_WorkSpace\\MVNCucumberSelenium\\Config\\config.xml"));	
	}
}
