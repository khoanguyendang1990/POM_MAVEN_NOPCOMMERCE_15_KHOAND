package pageUIs.frontend;

public class ProductListsPageUI {
	public static final String PRODUCT_TITLE="//div[@class='product-grid']//div[@class='product-item']//h2[@class='product-title']";
	public static final String PRODUCT_PRICE="//div[@class='product-grid']//div[@class='product-item']//div[@class='prices']";
	public static final String PAGING_DIV="//div[@class='pager']";
	
	
	//Dynamic element
	public static final String DYNAMIC_PAGE_ICON="//div[@class='pager']//li[contains(@class,'page')]/a[text()='%s']";
	public static final String DYNAMIC_PAGE_NUMBER="//div[@class='pager']//li[contains(@class,'page')]//*[text()='%s']";
	
}
