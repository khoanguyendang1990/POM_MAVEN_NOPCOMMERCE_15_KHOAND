package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.commons.CommonPageUI;
import pageUIs.frontend.MyAccountPageUI;

public class MyAccountPO extends CommonsPO {

	WebDriver driver;

	public MyAccountPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTextAddressListByClass(String classValue) {
		waitForElementVisible(MyAccountPageUI.DYNAMIC_ADDRESS_LI, classValue);
		return getTextElement(MyAccountPageUI.DYNAMIC_ADDRESS_LI, classValue);
	}
	
	public String getTextReviewListByClass(String classValue) {
		waitForElementVisible(MyAccountPageUI.DYNAMIC_REVIEW_DIV, classValue);
		return getTextElement(MyAccountPageUI.DYNAMIC_REVIEW_DIV, classValue);
	}
	
	public boolean isOrderNumberDisplayInOrderList(String orderNumber) {
		return isElementDisplay(MyAccountPageUI.ORDER_LIST_TITLE_NUMBER, orderNumber);
	}

	public void clickToDetailsOfOrderNumber(String orderNumber) {
		waitForElementVisible(MyAccountPageUI.DETAILS_BUTTON_OF_ORDER_NUMBER, orderNumber);
		clickToElement(MyAccountPageUI.DETAILS_BUTTON_OF_ORDER_NUMBER, orderNumber);
	}
}
