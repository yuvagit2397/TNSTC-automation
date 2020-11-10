package TnstcPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//button[text()='close']")
public static WebElement clickPrompt;
	
	@FindBy(id="matchStartPlace")
	public static WebElement fromCity;
	
	

	@FindBy(id="matchEndPlace")
	public static WebElement toCity;
	
	
	@FindBy(id="txtdeptDateRtrip")
	public static WebElement dateField;
	
	@FindBy(xpath="//a[text()='29']")
	public static WebElement chooseDate;
	
	@FindBy(id="txtAdultFemales")
	public static WebElement clickFemales;
	
	@FindBy(xpath="//a[text()='SEARCH']")
	public static WebElement searchButton;
	
	public static WebElement getClickPrompt() {
		return clickPrompt;
	}

	public static WebElement getFromCity() {
		return fromCity;
	}

	public static WebElement getToCity() {
		return toCity;
	}

	public static WebElement getDateField() {
		return dateField;
	}

	public static WebElement getChooseDate() {
		return chooseDate; 
	}

	public static WebElement getClickFemales() {
		return clickFemales;
	}

	public static WebElement getSearchButton() {
		return searchButton;
	}
	public HomePage(WebDriver logindriver) {
		this.driver=logindriver;
		PageFactory.initElements(driver, this);
	}
	
	
}
