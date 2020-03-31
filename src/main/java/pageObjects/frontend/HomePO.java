package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.frontend.HomePageUI;

public class HomePO extends CommonsPO {

	WebDriver driver;
	public HomePO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
}
