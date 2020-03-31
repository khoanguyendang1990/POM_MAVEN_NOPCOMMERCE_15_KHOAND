package pageUIs.frontend;

public class SearchPageUI {
	public static final String SEARCH_RESULT_WARNING_MESSAGE_DIV="//div[@class='search-results']";
	public static final String SEARCH_BUTTON="//div[@class='search-input']//input[@value='Search']";
	public static final String PRODUCT_ITEMS="//div[@class='product-item']";
	public static final String PRODUCT_ITEMS_TITLE="//div[@class='product-item']//h2[@class='product-title']";
	public static final String DYNAMIC_PRODUCT_ITEMS_TITLE="//div[@class='product-item']//h2[@class='product-title']/a[contains(text(),'%s')]";
}
