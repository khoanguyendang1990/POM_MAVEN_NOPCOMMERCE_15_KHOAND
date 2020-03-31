package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;

public class RegisterPO extends CommonsPO {

	WebDriver driver;
	public RegisterPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
}
