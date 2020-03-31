package pageUIs.commons;

public class CommonPageUI {

	//Header
	public static final String PAGE_HEADER_TITLE="//div[@class='page-title']/h1";
	public static final String HOME_PAGE_HEADER_LOGO="//div[@class='header-logo']";
	
	public static final String VALIDATION_ERROR_MESSAGE="//div[@class='message-error validation-summary-errors']";
	public static final String RESULT_MESSAGE_DIV="//div[@class='result']";
	
	public static final String NOTIFICATION_MESSAGE="//div[@id='bar-notification']//p[@class='content']";
	public static final String NOTIFICATION_CLOSE_BUTTON="//div[@id='bar-notification']//span[@class='close']";
	public static final String MINI_SHOPPING_CART_COUNT_MESSAGE="//div[@id='flyout-cart']//div[@class='mini-shopping-cart']//div[@class='count']";
	public static final String MINI_SHOPPING_CART_PRODUCT_NAME="//div[@id='flyout-cart']//div[@class='mini-shopping-cart']//div[@class='name']";
	public static final String MINI_SHOPPING_CART_PRODUCT_ATTRIBUTES="//div[@id='flyout-cart']//div[@class='mini-shopping-cart']//div[@class='attributes']";
	public static final String MINI_SHOPPING_CART_PRODUCT_PRICE="//div[@id='flyout-cart']//div[@class='mini-shopping-cart']//div[@class='price']";
	public static final String MINI_SHOPPING_CART_PRODUCT_QUANTITY="//div[@id='flyout-cart']//div[@class='mini-shopping-cart']//div[@class='quantity']";
	public static final String MINI_SHOPPING_CART_TOTALS="//div[@id='flyout-cart']//div[@class='mini-shopping-cart']//div[@class='totals']";
	
	
	// Dynamic Element Component
	public static final String DYNAMIC_LINK="//a[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXTBOX="//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX="//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BUTTON="//input[@id='%s']";
	public static final String DYNAMIC_ERROR_MESSSAGE_SPAN="//span[@id='%s']";
	public static final String DYNAMIC_TEXTAREA="//textarea[@id='%s']";
	public static final String DYNAMIC_BUTTON="//input[@value='%s']";
	public static final String DYNAMIC_PAGE_HEADING="//h1";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_ID="//select[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_NAME="//select[@name='%s']";

	public static final String LOADING_PROGRESS_ICON = "//span[contains(@id,'loading-progress')]";
}
