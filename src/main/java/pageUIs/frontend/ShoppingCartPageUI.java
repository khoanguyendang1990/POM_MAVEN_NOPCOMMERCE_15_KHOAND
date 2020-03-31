package pageUIs.frontend;

public class ShoppingCartPageUI {
	public static final String DYNAMIC_REMOVE_CHECKBOX="//a[@class='product-name' and contains(text(),'%s')]//ancestor::tr/td[@class='remove-from-cart']//input[@name='removefromcart']";
	public static final String ORDER_SUMMARY_CONTENT="//div[@class='order-summary-content']";
	public static final String CHECKOUT_BUTTON="//button[@id='checkout']";
}
