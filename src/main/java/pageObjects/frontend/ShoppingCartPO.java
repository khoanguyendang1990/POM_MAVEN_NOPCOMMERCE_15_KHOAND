package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.frontend.ShoppingCartPageUI;

public class ShoppingCartPO extends CommonsPO {

	WebDriver driver;
	public ShoppingCartPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public void checkToRemoveCheckboxOfProduct(String productName) {
		waitForElementVisible(ShoppingCartPageUI.DYNAMIC_REMOVE_CHECKBOX, productName);
		checkToCheckbox(ShoppingCartPageUI.DYNAMIC_REMOVE_CHECKBOX, productName);
	}
	public String getShoppingCartOrderSummaryContent() {
		waitForElementVisible(ShoppingCartPageUI.ORDER_SUMMARY_CONTENT);
		return getTextElement(ShoppingCartPageUI.ORDER_SUMMARY_CONTENT);
	}
	
	public void clickToCheckOutButton() {
		waitForElementVisible(ShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(ShoppingCartPageUI.CHECKOUT_BUTTON);
	}
}
