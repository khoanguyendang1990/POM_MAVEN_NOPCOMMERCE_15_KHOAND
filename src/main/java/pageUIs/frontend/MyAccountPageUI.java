package pageUIs.frontend;

public class MyAccountPageUI {
	
	public static final String ORDER_LIST_TITLE_NUMBER="//div[@class='order-list']//div[@class='title']/strong[contains(text(),'%s')]";
	public static final String DETAILS_BUTTON_OF_ORDER_NUMBER="//strong[contains(text(),'%s')]//ancestor::div[@class='section order-item']//input[@value='Details']";
	
	//Dynamic
	public static final String DYNAMIC_ADDRESS_LI="//div[@class='address-list']//li[@class='%s']";
	public static final String DYNAMIC_REVIEW_DIV="//div[@class='product-review-item']//div[@class='%s']";
	
}
