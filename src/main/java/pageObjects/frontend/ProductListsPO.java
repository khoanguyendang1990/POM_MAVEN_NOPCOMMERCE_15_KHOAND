package pageObjects.frontend;

import org.apache.velocity.runtime.parser.node.GetExecutor;
import org.openqa.selenium.WebDriver;

import commons.CommonsPO;
import pageUIs.frontend.ProductDetailsPageUI;
import pageUIs.frontend.ProductListsPageUI;

public class ProductListsPO extends CommonsPO {

	WebDriver driver;
	public ProductListsPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean isProductsSortByTitleAsc() {
		waitForElementVisible(ProductListsPageUI.PRODUCT_TITLE);
		return isDataSortedAsc(ProductListsPageUI.PRODUCT_TITLE);
	}
	
	public boolean isProductsSortByTitleDesc() {
		waitForElementVisible(ProductListsPageUI.PRODUCT_TITLE);
		return isDataSortedDesc(ProductListsPageUI.PRODUCT_TITLE);
	}
	
	public boolean isProductsSortByPriceAsc() {
		waitForElementVisible(ProductListsPageUI.PRODUCT_PRICE);
		return isPriceSortedAsc((ProductListsPageUI.PRODUCT_PRICE),"$");
	}
	
	public boolean isProductsSortByPriceDesc() {
		waitForElementVisible(ProductListsPageUI.PRODUCT_PRICE);
		return isPriceSortedDesc((ProductListsPageUI.PRODUCT_PRICE),"$");
	}

	public int getProductsShowedInOnePage() {
		waitForElementVisible(ProductListsPageUI.PRODUCT_TITLE);
		return countElementNumber(ProductListsPageUI.PRODUCT_TITLE);
	}

	public void clickToPageNumber(String pageNumber) {
		waitForElementVisible(ProductListsPageUI.DYNAMIC_PAGE_NUMBER,pageNumber);
		clickToElement(ProductListsPageUI.DYNAMIC_PAGE_NUMBER,pageNumber);
		
	}
	
	public void clickToPageIcon(String iconName) {
		waitForElementVisible(ProductListsPageUI.DYNAMIC_PAGE_ICON,iconName);
		clickToElement(ProductListsPageUI.DYNAMIC_PAGE_ICON,iconName);
		
	}

	public boolean isPageIconDisplayed(String iconName) {
		return isElementDisplay(ProductListsPageUI.DYNAMIC_PAGE_ICON,iconName);
	}

	public boolean isPageIconNotDisplayed(String iconName) {
		return isControlUndisplay(ProductListsPageUI.DYNAMIC_PAGE_ICON,iconName);
	}

	public boolean isPagingNotDisplayed() {
		return isControlUndisplay(ProductListsPageUI.PAGING_DIV);
	}

	
}
