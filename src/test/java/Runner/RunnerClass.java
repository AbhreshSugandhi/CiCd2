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
@CucumberOptions(features = ".\\src\\test\\java\\Features",
		glue = "StepDefinitions",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/reports.html"},
		monochrome = true)

public class RunnerClass {	
	
	@BeforeClass
	public static void readData() throws Exception {
		BaseClass.readTestDataFile(System.getProperty("user.dir")+"\\TestData\\NewToursTestData.xlsx", "1");
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(".\\Config\\config.xml"));	
	}
}
