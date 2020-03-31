package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.frontend.CheckOutPageUI;
import pageUIs.frontend.MyAccountPageUI;
import pageUIs.frontend.OrdersInformationPageUI;

public class OrdersInformationPO extends CommonsPO {

	WebDriver driver;
	public OrdersInformationPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public String getTextDynamicTotalInfoValueByRowName(String rowName) {
		waitForElementVisible(OrdersInformationPageUI.DYNAMIC_TOTAL_INFO_ROW, rowName);
		return getTextElement(OrdersInformationPageUI.DYNAMIC_TOTAL_INFO_ROW, rowName);
	}
	
	public String getTextDynamicOrderProductInfo(String productName,String columnClass) {
		waitForElementVisible(OrdersInformationPageUI.DYNAMIC_ORDERS_INFO, productName,columnClass);
		return getTextElement(OrdersInformationPageUI.DYNAMIC_ORDERS_INFO, productName,columnClass);
	}
	
	public boolean isOrderNumberDisplayInOrderList(String orderNumber) {
		return isElementDisplay(OrdersInformationPageUI.ORDER_INFO_TITLE_NUMBER, orderNumber);
	}
}
