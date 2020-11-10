 package TnstcPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public static WebDriver driver;
	@FindBy(xpath = "//*[@id=\"table-1\"]/tbody/tr[1]/td[2]/table/tbody/tr/td[1]")
	public static List<WebElement> tripCode;
	
	public static List<WebElement> getTripCode() {
		
		return tripCode;
	}
	
	public SearchPage(WebDriver logindriver) {
		this.driver=logindriver;
		PageFactory.initElements(driver, this);
	}
	
}
