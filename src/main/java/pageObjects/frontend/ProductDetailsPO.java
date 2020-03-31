package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.frontend.ProductDetailsPageUI;

public class ProductDetailsPO extends CommonsPO {

	WebDriver driver;
	public ProductDetailsPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public String getTextProductTitle() {
		waitForElementVisible(ProductDetailsPageUI.PRODUCT_DETAIL_TITLE);
		return getTextElement(ProductDetailsPageUI.PRODUCT_DETAIL_TITLE);
	}
	
	
}
