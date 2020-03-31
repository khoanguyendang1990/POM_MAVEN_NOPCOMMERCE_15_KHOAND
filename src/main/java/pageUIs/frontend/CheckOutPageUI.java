package pageUIs.frontend;

public class CheckOutPageUI {
	public static final String TOTAL_INFO_SUB_TOTAL="//div[@class='total-info']//tr[@class='order-subtotal']//span[@class='value-summary']";
	public static final String TOTAL_INFO_SHIPPING_COST="//div[@class='total-info']//tr[@class='shipping-cost']//span[@class='value-summary']";
	public static final String TOTAL_INFO_TAX="//div[@class='total-info']//tr[@class='tax-value']//span[@class='value-summary']";
	public static final String TOTAL_INFO_TOTAL="//div[@class='total-info']//tr[@class='order-total']//span[@class='value-summary']";
	public static final String TOTAL_INFO_EARN_REWARD_POINT="//div[@class='total-info']//tr[@class='earn-reward-points']//span[@class='value-summary']";
	
	public static final String ORDER_COMPLETED_TITLE="//div[@class='section order-completed']//div[@class='title']";
	public static final String ORDER_COMPLETED_DETAILS="//div[@class='section order-completed']//div[@class='details']//div[@class='order-number']/strong";
	
	
	public static final String DYNAMIC_CONTINUE_BUTTON="//div[@id='%s']//input[@value='Continue']";
	public static final String DYNAMIC_CHECKOUT_INFO="//div[@class='title']/strong[text()='%s']//parent::div//following-sibling::ul//li[@class='%s']";
	public static final String DYNAMIC_SHOPPING_CART_INFO="//form[@id='shopping-cart-form']//a[text()='%s']//ancestor::tr//span[@class='%s']";
}
