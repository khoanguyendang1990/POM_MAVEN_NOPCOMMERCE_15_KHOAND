package pageObjects.frontend;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.CommonsPO;
import pageUIs.frontend.SearchPageUI;

public class SearchPO extends CommonsPO {

	WebDriver driver;
	List<WebElement> elements;
	public SearchPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public String getTextSearchResultMessage() {
		waitForElementVisible(SearchPageUI.SEARCH_RESULT_WARNING_MESSAGE_DIV);
		return getTextElement(SearchPageUI.SEARCH_RESULT_WARNING_MESSAGE_DIV);
	}
	
	public void clickToSearchButton() {
		waitForElementVisible(SearchPageUI.SEARCH_BUTTON);
		clickToElement(SearchPageUI.SEARCH_BUTTON);
	}
	
	public int getNumberOfProductItems(){
		return finds(SearchPageUI.PRODUCT_ITEMS).size();
	}
	
	public boolean isProductPresenceByName(String productName) {
		return isElementDisplay(SearchPageUI.DYNAMIC_PRODUCT_ITEMS_TITLE, productName);
	}
	
	public List<WebElement> getListProductItemsTitle(){
		return finds(SearchPageUI.PRODUCT_ITEMS_TITLE);
	}
	
	public boolean isProductListContainsSearchText(String searchText) {
		boolean flag=true;
		elements = getListProductItemsTitle();
		for (WebElement webElement : elements) {
			if(webElement.getText().contains(searchText)) {
				continue;
			}
			flag=false;
		}
		return flag;
	}
}
