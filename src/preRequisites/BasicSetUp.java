package preRequisites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testCases.BaseClass;

public class BasicSetUp {

	public static WebDriver driver=null;
	public static Properties properties = null;
	static String browser;
	public static ExtentReports extentReports;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest testCases;
	Logger logger=Logger.getLogger(BasicSetUp.class);
	public static void extentReport() {
		extentReports=new ExtentReports();
		htmlReporter=new ExtentHtmlReporter("TNSTCReport.html");
		extentReports.attachReporter(htmlReporter);
		
	}
	public static Properties propertyData() throws IOException {
		String s = "D:\\yuvasri_revision\\TnstcAutomation\\src\\propertyFile\\Tnstc.properties";
		FileInputStream f = new FileInputStream(s);
		properties = new Properties();
		properties.load(f);
		return properties;

	}

	@BeforeSuite
	public void browserLaunch() throws IOException {
		PropertyConfigurator.configure("Logger.properties");
		propertyData();
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		String chromeLocation = properties.getProperty("chromeLocation");
		String firefoxLocation = properties.getProperty("firefoxLocation");

		if (browser.equalsIgnoreCase("Chrome")) {
			logger.info("Chrome browser opening");
			//ChromeOptions cp=new ChromeOptions();
			//cp.addArguments("headless");
			driver=new ChromeDriver();
			//driver = new ChromeDriver(cp);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxLocation);
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser Name");
		}
		extentReport();
		testCases=extentReports.createTest("To Get TripCode In TNSTC");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		 extentReports.flush();
		 logger.info("Closing the driver");
		//driver.quit();
		logger.info("DONE");

	}

}
