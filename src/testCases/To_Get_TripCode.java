
package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import TnstcPOM.HomePage;
import TnstcPOM.PageObjectManager;
import TnstcPOM.SearchPage;
import preRequisites.BasicSetUp;

public class To_Get_TripCode extends BasicSetUp {
	PageObjectManager pom = new PageObjectManager();
	static Logger logger = Logger.getLogger(To_Get_TripCode.class);// design pattern

	@Test(priority = 0)
	public void toFillBookingDetails() throws InterruptedException, AWTException {
		PropertyConfigurator.configure("Logger.properties");
		PageFactory.initElements(driver, HomePage.class);
		 //HomePage.clickPrompt.click();
		Thread.sleep(3000);
	    HomePage.fromCity.sendKeys("Chennai");
		logger.info("Entering from city");
		Thread.sleep(2000);
		BaseClass.keyDownAndUp(0, "down");
		Thread.sleep(2000);
		logger.info("Entering to city");

		HomePage.toCity.sendKeys("coim");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		HomePage.dateField.click();
		HomePage.chooseDate.click();
		HomePage.clickFemales.sendKeys("1");
		logger.info("Clicking search button ");

		HomePage.searchButton.click();
		//driver.switchTo().alert().accept();

	}

	@Test(priority = 1)
	public void togetTripCode() {
		PageFactory.initElements(driver, SearchPage.class);

		List<WebElement> tripCode = SearchPage.tripCode;

		String actual = "1930CHECOIAC";
		String text = null;
		logger.info("Getting tripcode");

		for (WebElement webElement : tripCode) {
			text = webElement.getText();
			if (text.equals(actual)) {
				System.out.println(text);
				Assert.assertEquals(actual, text);
				System.out.println("Assertion passed");
			}
		}
		logger.info("Got trip code");
		logger.info("TestCase one succesfully completed");
		System.out.println("tripcode printed");

	/*@Test
	private void headlessBrowser() {
	WebDriver driver=BasicSetUp.driver;
	driver.get("https://www.fb.com");
	String title = driver.getTitle();
	System.out.println("FB title is = "+title);

	}*/
	}
}


