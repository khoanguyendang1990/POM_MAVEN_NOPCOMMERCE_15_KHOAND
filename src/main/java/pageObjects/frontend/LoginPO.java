package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.ReuseFunctions;
import commons.CommonsPO;
import commons.PageGeneratorManager;
import pageUIs.commons.CommonPageUI;
import pageUIs.frontend.LoginPageUI;

public class LoginPO extends CommonsPO {

	WebDriver driver;

	public LoginPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputTextToEmail(String email) {
		waitForElementVisible(CommonPageUI.DYNAMIC_TEXTBOX,"Email");
		sendKeyToElement(CommonPageUI.DYNAMIC_TEXTBOX, email,"Email");
	}

	public void inpurtTextToPassword(String password) {
		waitForElementVisible(CommonPageUI.DYNAMIC_TEXTBOX,"Password");
		sendKeyToElement(CommonPageUI.DYNAMIC_TEXTBOX, password,"Password");
	}

	public void clickOnLogin() {	
		waitForElementClickable(CommonPageUI.DYNAMIC_BUTTON,"Log in");
		clickToElement(CommonPageUI.DYNAMIC_BUTTON,"Log in");
	}

	public HomePO loginSuccessfully(String email, String password) {
		inputTextToEmail(email);
		inpurtTextToPassword(password);
		clickOnLogin();
		return PageGeneratorManager.getHomePage(driver);
	}
}
