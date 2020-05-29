package Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BaseClass.class);
	public static Map<String, String> testData = new HashMap<String, String>();
	public static Map<String, String> testDataValue = new HashMap<String, String>();

	public static void openBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
				driver = new ChromeDriver();
				log.info(browserName + "browser is up and running");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.info(browserName + "browser is up and running");
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			log.fatal("Unable to launch" + browserName + "browser");
		}
	}

	public static void openUrl(String url) {
		try {
			driver.get(url);
			log.info("Opened URl:- " + url);
		} catch (Exception e) {
			log.fatal("Unable to open URL" + e.getMessage());
		}
	}

	public static void enterTxt(By loc, String data) {
		try {
			driver.findElement(loc).clear();
			driver.findElement(loc).sendKeys(data);
			log.info("Entered the - " + data + " - into the textbox having locator:- " + loc);
		} catch (Exception e) {
			log.fatal("Unable to Entered the value into the textbox having locator:-" + loc);
		}
	}

	public static void click(By loc) {
		try {
			driver.findElement(loc).click();
			log.info("Clicked on the element having locator:- " + loc);
		} catch (Exception e) {
			log.fatal("Unable to click on the element having locator:- " + loc);
		}

	}

	public static void clickLink(By loc) {
		try {
			driver.findElement(loc).click();
			log.info("Clicked on the Link having locator:- " + loc);
		} catch (Exception e) {
			log.fatal("Unable to click on the link having locator:- " + loc);
		}
	}

	public static void select(By loc, String data) {
		try {
			new Select(driver.findElement(loc)).selectByVisibleText(data);
			log.info("Select the " + data + " using:- " + loc);
		} catch (Exception e) {
			log.fatal("Unable to select the " + data + " using:- " + loc);
		}
	}

	public static void select(By loc, int no) {
		try {
			new Select(driver.findElement(loc)).selectByIndex(no);
			log.info("Select the option having index position" + no + " using:- " + loc);
		} catch (Exception e) {
			log.fatal("Unable to select the option having index position" + no + " using:- " + loc);
		}
	}

	public void displayOfElement(By loc) {
		try {
			driver.findElement(loc).isDisplayed();
			log.info("Element is displayed on the page:- " + loc);
		} catch (Exception e) {
			log.fatal("Element is not displayed on the page");
			driver.quit();
		}
	}

	public static void readTestDataFile(String filePath, String tcID) throws Exception {
		int s = 0;
		try {
			FileInputStream testRunReport = new FileInputStream(filePath);
			Workbook workbook;
			Sheet worksheet;
			int n = filePath.indexOf(".");
			String extension = filePath.substring(n);
			if (extension.equalsIgnoreCase(".xlsx")) {
				workbook = new XSSFWorkbook(testRunReport);
			} else {
				workbook = new HSSFWorkbook(testRunReport);

			}
			int sheets = workbook.getNumberOfSheets();
			System.out.println("sheets " + sheets);
			int j = 0;
			List<String> arrayOfString = new ArrayList<String>();
			String str = workbook.getSheetName(0);
			System.out.println(str);
			worksheet = workbook.getSheet(str);
			Row Headertrow = worksheet.getRow(0);
			int startValue = Integer.parseInt(tcID);
			int endValue = startValue;
			for (int i = startValue; i <= endValue; i++) {
				Row currentrow = worksheet.getRow(i);
				int columns = currentrow.getLastCellNum();
				for (int k = 0; k < columns; k++) {
					if (currentrow != null) {
						Cell cellkey = Headertrow.getCell(k);
						System.out.println("cellkey " + cellkey);
						Cell cellValue = currentrow.getCell(k);
						System.out.println("cellValue " + cellValue);
						System.out.println("-----------------------------");
						if (cellkey.toString() != "") {
							if (!arrayOfString.contains(cellkey.toString())) {
								arrayOfString.add(cellkey.toString());
								testData.put(cellkey.toString(), cellValue.toString());
								testDataValue.put(cellkey.toString(), cellValue.toString());
							} else {
								System.out.println("Duplicate Key In Test Data File : " + cellkey.toString());
							}
						} else {
							System.out.println("Row is empty in Test Data file : " + (i + 1));
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Unable to read test data file : " + s);
		}
	}
}
