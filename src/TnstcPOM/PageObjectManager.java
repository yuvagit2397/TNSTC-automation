package TnstcPOM;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public static WebDriver driver;
	private HomePage hP;

	public HomePage gethP() {
		hP = new HomePage(driver);
		return hP;
	}

	private SearchPage sP;

	public SearchPage getsP() {
		sP = new SearchPage(driver);
		return sP;
	}

}
