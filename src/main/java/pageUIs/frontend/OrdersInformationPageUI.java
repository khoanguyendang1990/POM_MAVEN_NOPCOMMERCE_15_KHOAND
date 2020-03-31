package pageUIs.frontend;

public class OrdersInformationPageUI {
	public static final String DYNAMIC_TOTAL_INFO_ROW="//div[@class='total-info']//label[text()='%s:']//parent::td//following-sibling::td/span";
	public static final String ORDER_INFO_TITLE_NUMBER="//div[@class='order-overview']//div[@class='order-number']/strong[contains(text(),'%s')]";
	//Dynamic Element
	public static final String DYNAMIC_ORDERS_INFO="//div[@class='section products']//a[text()='%s']//ancestor::tr//span[@class='%s']";
}
