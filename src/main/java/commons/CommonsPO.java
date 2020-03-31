package commons;

import org.openqa.selenium.WebDriver;

import pageUIs.commons.CommonPageUI;
import pageUIs.frontend.HomePageUI;
import pageUIs.frontend.ProductDetailsPageUI;

public class CommonsPO extends ReuseFunctions {

	WebDriver driver;

	public CommonsPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Page
	public void openMultiplePages(String pageName) {
		waitForElementVisible(CommonPageUI.DYNAMIC_LINK, pageName);
		clickToElement(CommonPageUI.DYNAMIC_LINK, pageName);
	}

	public void openMultiplePagesJS(String pageName) {
		waitForElementVisible(CommonPageUI.DYNAMIC_LINK, pageName);
		clickToElementByJS(CommonPageUI.DYNAMIC_LINK, pageName);
	}

	public void inputToDynamicTextbox(String textboxID, String textValue) {
		waitForElementVisible(CommonPageUI.DYNAMIC_TEXTBOX, textboxID);
		sendKeyToElement(CommonPageUI.DYNAMIC_TEXTBOX, textValue, textboxID);
	}

	public void inputToDynamicTextarea(String textareaID, String textValue) {
		waitForElementVisible(CommonPageUI.DYNAMIC_TEXTAREA, textareaID);
		sendKeyToElement(CommonPageUI.DYNAMIC_TEXTAREA, textValue, textareaID);
	}

	public void clickToDynamicButton(String buttonValue) {
		waitForElementVisible(CommonPageUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(CommonPageUI.DYNAMIC_BUTTON, buttonValue);
	}

	public void clickToDynamicRadioButton(String buttonID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_RADIO_BUTTON, buttonID);
		clickToElement(CommonPageUI.DYNAMIC_RADIO_BUTTON, buttonID);
	}

	public void clickToDynamicLink(String linkName) {
		waitForElementVisible(CommonPageUI.DYNAMIC_LINK, linkName);
		clickToElement(CommonPageUI.DYNAMIC_LINK, linkName);
	}

	public void selectDynamicDropdownListByID(String dropdownlistID, String valueItem) {
		waitForElementVisible(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownlistID);
		selectItemInDropdown(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, valueItem, dropdownlistID);
	}
	
	public void selectDynamicDropdownListByName(String dropdownlistName, String valueItem) {
		waitForElementVisible(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_NAME, dropdownlistName);
		selectItemInDropdown(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_NAME, valueItem, dropdownlistName);
	}
	
	public String getTextDynamicDropdownListByID(String dropdownlistID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownlistID);
		return getItemInDropdown(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownlistID);
	}
	
	public String getTextDynamicDropdownListByName(String dropdownlistName) {
		waitForElementVisible(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_NAME, dropdownlistName);
		return getItemInDropdown(CommonPageUI.DYNAMIC_DROPDOWN_LIST_BY_NAME, dropdownlistName);
	}
	
	public String getTextDynamicErrorMessage(String messageSpanID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_ERROR_MESSSAGE_SPAN, messageSpanID);
		return getTextElement(CommonPageUI.DYNAMIC_ERROR_MESSSAGE_SPAN, messageSpanID);
	}
	
	public String getTextValidationErrorMessage() {
		waitForElementVisible(CommonPageUI.VALIDATION_ERROR_MESSAGE);
		return getTextElement(CommonPageUI.VALIDATION_ERROR_MESSAGE);
	}

	public String getTextPageHeaderTitle() {
		waitForElementVisible(CommonPageUI.PAGE_HEADER_TITLE);
		return getTextElement(CommonPageUI.PAGE_HEADER_TITLE);
	}

	public String getDynamicTextbox(String textboxID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_TEXTBOX, textboxID);
		return getTextElement(CommonPageUI.DYNAMIC_TEXTBOX, textboxID);
	}

	public void checkToDynamicCheckbox(String checkboxID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_CHECKBOX, checkboxID);
		checkToCheckbox(CommonPageUI.DYNAMIC_CHECKBOX, checkboxID);
	}
	
	public boolean isCheckboxChecked(String checkboxID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_CHECKBOX, checkboxID);
		return isElementSelected(CommonPageUI.DYNAMIC_CHECKBOX, checkboxID);
	}
	
	public void uncheckToDynamicCheckbox(String checkboxID) {
		waitForElementVisible(CommonPageUI.DYNAMIC_CHECKBOX, checkboxID);
		uncheckToCheckbox(CommonPageUI.DYNAMIC_CHECKBOX, checkboxID);
	}
	
	public boolean isLinkDisplayed(String linkName) {
		waitForElementVisible(CommonPageUI.DYNAMIC_LINK,linkName);
		return isElementDisplay(CommonPageUI.DYNAMIC_LINK,linkName);
	}

	public String getDynamicTextboxAttributeValue(String textboxID, String AttrValue) {
		waitForElementVisible(CommonPageUI.DYNAMIC_TEXTBOX, textboxID);
		return getAttributeValue(CommonPageUI.DYNAMIC_TEXTBOX, AttrValue, textboxID);
	}
	
	public void waitForLoadingIconDisappear() {
		waitForElementInvisible(CommonPageUI.LOADING_PROGRESS_ICON);
	}
	
	public String getTextResultMessage() {
		waitForElementVisible(CommonPageUI.RESULT_MESSAGE_DIV);
		return getTextElement(CommonPageUI.RESULT_MESSAGE_DIV);
	}
	
	public void openHomePage() {
		waitForElementVisible(CommonPageUI.HOME_PAGE_HEADER_LOGO);
		clickToElement(CommonPageUI.HOME_PAGE_HEADER_LOGO);
	}
	
	public void hoverMouseToDynamicMainMenuElement(String textMenu) {
		waitForElementVisible(HomePageUI.DYNAMIC_MAIN_MENU_SPAN,textMenu);
		hoverMouseToElement(HomePageUI.DYNAMIC_MAIN_MENU_SPAN,textMenu);
	}
	
	public void hoverMouseToDynamicHeaderUpperElement(String textMenu) {
		waitForElementVisible(HomePageUI.DYNAMIC_HEADER_UPPER_SPAN,textMenu);
		hoverMouseToElement(HomePageUI.DYNAMIC_HEADER_UPPER_SPAN,textMenu);
	}
	
	public String getNotificationMessage() {
		waitForElementVisible(CommonPageUI.NOTIFICATION_MESSAGE);
		return getTextElement(CommonPageUI.NOTIFICATION_MESSAGE);
	}
	public String getTextMiniShoppingCartProductAttributes() {
		waitForElementVisible(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_ATTRIBUTES);
		return getTextElement(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_ATTRIBUTES);
	}
	public String getTextMiniShoppingCartProductName() {
		waitForElementVisible(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_NAME);
		return getTextElement(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_NAME);
	}
	public String getTextMiniShoppingCartProductCounted() {
		waitForElementVisible(CommonPageUI.MINI_SHOPPING_CART_COUNT_MESSAGE);
		return getTextElement(CommonPageUI.MINI_SHOPPING_CART_COUNT_MESSAGE);
	}
	public String getTextMiniShoppingCartProductPrice() {
		waitForElementVisible(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_PRICE);
		return getTextElement(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_PRICE);
	}
	public String getTextMiniShoppingCartProductQuantity() {
		waitForElementVisible(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_QUANTITY);
		return getTextElement(CommonPageUI.MINI_SHOPPING_CART_PRODUCT_QUANTITY);
	}
	public String getTextMiniShoppingCartProductSubTotal() {
		waitForElementVisible(CommonPageUI.MINI_SHOPPING_CART_TOTALS);
		return getTextElement(CommonPageUI.MINI_SHOPPING_CART_TOTALS);
	}
	public void closeNotificationBar() {
		waitForElementVisible(CommonPageUI.NOTIFICATION_CLOSE_BUTTON);
		clickToElement(CommonPageUI.NOTIFICATION_CLOSE_BUTTON);
	}
}
