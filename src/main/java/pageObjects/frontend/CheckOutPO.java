package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.frontend.CheckOutPageUI;
import pageUIs.frontend.HomePageUI;

public class CheckOutPO extends CommonsPO {

	WebDriver driver;
	public CheckOutPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public void clickToDynamicContinueButtonOfMethod(String methodName) {
		waitForElementVisible(CheckOutPageUI.DYNAMIC_CONTINUE_BUTTON, methodName);
		clickToElement(CheckOutPageUI.DYNAMIC_CONTINUE_BUTTON, methodName);
	}
	
	public String getTextDynamicCheckOutInfo(String title,String infoClass) {
		waitForElementVisible(CheckOutPageUI.DYNAMIC_CHECKOUT_INFO, title,infoClass);
		return getTextElement(CheckOutPageUI.DYNAMIC_CHECKOUT_INFO, title,infoClass);
	}
	public String getTextDynamicShoppingCartInfo(String productName,String columnClass) {
		waitForElementVisible(CheckOutPageUI.DYNAMIC_SHOPPING_CART_INFO, productName,columnClass);
		return getTextElement(CheckOutPageUI.DYNAMIC_SHOPPING_CART_INFO, productName,columnClass);
	}
	
	public String getTextTotalInfoSubTotal() {
		waitForElementVisible(CheckOutPageUI.TOTAL_INFO_SUB_TOTAL);
		return getTextElement(CheckOutPageUI.TOTAL_INFO_SUB_TOTAL);
	}
	public String getTextTotalInfoShippingCost() {
		waitForElementVisible(CheckOutPageUI.TOTAL_INFO_SHIPPING_COST);
		return getTextElement(CheckOutPageUI.TOTAL_INFO_SHIPPING_COST);
	}
	public String getTextTotalInfoTax() {
		waitForElementVisible(CheckOutPageUI.TOTAL_INFO_TAX);
		return getTextElement(CheckOutPageUI.TOTAL_INFO_TAX);
	}
	public String getTextTotalInfoTotal() {
		waitForElementVisible(CheckOutPageUI.TOTAL_INFO_SUB_TOTAL);
		return getTextElement(CheckOutPageUI.TOTAL_INFO_SUB_TOTAL);
	}
	public String getTextTotalInfoEarnRewardPoint() {
		waitForElementVisible(CheckOutPageUI.TOTAL_INFO_EARN_REWARD_POINT);
		return getTextElement(CheckOutPageUI.TOTAL_INFO_EARN_REWARD_POINT);
	}
	public String getTextOrderCompleteTitle() {
		waitForElementVisible(CheckOutPageUI.ORDER_COMPLETED_TITLE);
		return getTextElement(CheckOutPageUI.ORDER_COMPLETED_TITLE);
	}
	public String getTextOrderNumber() {
		waitForElementVisible(CheckOutPageUI.ORDER_COMPLETED_DETAILS);
		return getTextElement(CheckOutPageUI.ORDER_COMPLETED_DETAILS).replace("ORDER NUMBER: ", "").trim();
	}
}
