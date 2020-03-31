package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.frontend.HomePO;
import pageObjects.frontend.LoginPO;
import pageObjects.frontend.SearchPO;
import reportConfig.ExtentTestManager;

public class Search_AdvanceSearch extends BaseTest {
	WebDriver driver;

	private HomePO homePO;
	private LoginPO loginPO;
	private SearchPO searchPO;

	private String relativeProductName = "Lenovo";
	private String absoluteProductName = "Thinkpad X1 Carbon";
	private String advanceSearchProductName = "Apple MacBook Pro";
	private String catalogyName = "Computers";
	private String wrongManufacturerName = "HP";
	private String rightManufacturerName = "Apple";

	@Test
	public void TC_01_Search_with_empty_data() {
		ExtentTestManager.startTest("TC_01_Search_with_empty_data", "Search with empty data");
		log.info("========Start TC_01_Search_with_empty_data========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Click button Search with empty data");
		log.info("Step 1: Click button Search with empty data");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		log.info("Click Search button");
		searchPO.clickToSearchButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show error message");
		log.info("VP. Show error message");
		verifyEquals(searchPO.getTextSearchResultMessage(), "Search term minimum length is 3 characters");

		log.info("========End TC_01_Search_with_empty_data========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Search_with_data_not_existing() {
		ExtentTestManager.startTest("TC_02_Search_with_data_not_existing", "Search with data not existing");
		log.info("========Start TC_02_Search_with_data_not_existing========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input data not existing");
		log.info("Step 1: Input data not existing");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", "Macbook Pro 2050");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Search Button");
		log.info("Step 2: Click Search Button");
		searchPO.clickToSearchButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show error message");
		log.info("VP. Show error message");
		verifyEquals(searchPO.getTextSearchResultMessage(), "No products were found that matched your criteria.");

		log.info("========End TC_02_Search_with_data_not_existing========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Search_with_relative_product_name() {
		ExtentTestManager.startTest("TC_03_Search_with_relative_product_name", "Search with relative product name");
		log.info("========Start TC_03_Search_with_relative_product_name========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", relativeProductName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Search Button");
		log.info("Step 2: Click Search Button");
		searchPO.clickToSearchButton();
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show 2 product contains " + relativeProductName);

		log.info("VP. Show 2 product");
		verifyEquals(searchPO.getNumberOfProductItems(), 2);

		log.info("VP. Show 2 product contains " + relativeProductName);
		verifyTrue(searchPO.isProductListContainsSearchText(relativeProductName));

		log.info("VP. Show product Lenovo IdeaCentre 600 All-in-One PC");
		verifyTrue(searchPO.isProductPresenceByName("Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("VP. Show product Lenovo Thinkpad X1 Carbon Laptop");
		verifyTrue(searchPO.isProductPresenceByName("Lenovo Thinkpad X1 Carbon Laptop"));
		log.info("========End TC_03_Search_with_relative_product_name========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Search_with_absolute_product_name() {
		ExtentTestManager.startTest("TC_04_Search_with_absolute_product_name", "Search with absolute product name");
		log.info("========Start TC_04_Search_with_absolute_product_name========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", absoluteProductName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Search Button");
		log.info("Step 2: Click Search Button");
		searchPO.clickToSearchButton();
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show 2 product contains " + absoluteProductName);

		log.info("VP. Show 1 product");
		verifyEquals(searchPO.getNumberOfProductItems(), 1);

		log.info("VP. Show 1 product contains " + absoluteProductName);
		verifyTrue(searchPO.isProductListContainsSearchText(absoluteProductName));

		log.info("VP. Show product Lenovo Thinkpad X1 Carbon Laptop");
		verifyTrue(searchPO.isProductPresenceByName("Lenovo Thinkpad X1 Carbon Laptop"));
		log.info("========End TC_04_Search_with_absolute_product_name========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Advance_Search_with_Parent_Catalogies() {
		ExtentTestManager.startTest("TC_05_Advance_Search_with_Parent_Catlogies", "Advance Search with Parent Catalogies");
		log.info("========Start TC_05_Advance_Search_with_Parent_Catlogies========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Click Search Button");
		log.info("Step 4: Click Search Button");
		searchPO.clickToSearchButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show error message");
		log.info("VP. Show error message");
		verifyEquals(searchPO.getTextSearchResultMessage(), "No products were found that matched your criteria.");

		log.info("========End TC_05_Advance_Search_with_Parent_Catlogies========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Advance_Search_with_Sub_Catalogies() {
		ExtentTestManager.startTest("TC_06_Advance_Search_with_Sub_Catalogies", "Advance Search with Sub Catalogies");
		log.info("========Start TC_06_Advance_Search_with_Sub_Catalogies========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Check on checkbox Automatically search sub categories");
		log.info("Step 5: Check on checkbox Automatically search sub categories");
		searchPO.checkToDynamicCheckbox("isc");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Click Search Button");
		log.info("Step 6: Click Search Button");
		searchPO.clickToSearchButton();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show 2 product contains " + advanceSearchProductName);

		log.info("VP. Show 1 product");
		verifyEquals(searchPO.getNumberOfProductItems(), 1);

		log.info("VP. Show 1 product contains " + advanceSearchProductName);
		verifyTrue(searchPO.isProductListContainsSearchText(advanceSearchProductName));

		log.info("VP. Show product Apple MacBook Pro 13-inch");
		verifyTrue(searchPO.isProductPresenceByName(advanceSearchProductName));
		
		log.info("========End TC_06_Advance_Search_with_Sub_Catalogies========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_07_Advance_Search_with_Sub_Catalogies_Wrong_Manufacturer() {
		ExtentTestManager.startTest("TC_07_Advance_Search_with_Sub_Catalogies_Wrong_Manufacturer", "Advance Search with Sub Catalogies wrong Manufacturer");
		log.info("========Start TC_07_Advance_Search_with_Sub_Catalogies_Wrong_Manufacturer========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Check on checkbox Automatically search sub categories");
		log.info("Step 5: Check on checkbox Automatically search sub categories");
		searchPO.checkToDynamicCheckbox("isc");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Select Manufacturer dropdownlist");
		log.info("Step 6: Select Manufacturer dropdownlist");
		searchPO.selectDynamicDropdownListByID("mid", wrongManufacturerName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Click Search Button");
		log.info("Step 7: Click Search Button");
		searchPO.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show error message");
		log.info("VP. Show error message");
		verifyEquals(searchPO.getTextSearchResultMessage(), "No products were found that matched your criteria.");
		
		log.info("========End TC_07_Advance_Search_with_Sub_Catalogies_Wrong_Manufacturer========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_08_Advance_Search_with_Sub_Catalogies_Right_Manufacturer() {
		ExtentTestManager.startTest("TC_08_Advance_Search_with_Sub_Catalogies_Right_Manufacturer", "Advance Search with Sub Catalogies and right Manufacturer");
		log.info("========Start TC_08_Advance_Search_with_Sub_Catalogies_Right_Manufacturer========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Check on checkbox Automatically search sub categories");
		log.info("Step 5: Check on checkbox Automatically search sub categories");
		searchPO.checkToDynamicCheckbox("isc");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Select Manufacturer dropdownlist");
		log.info("Step 6: Select Manufacturer dropdownlist");
		searchPO.selectDynamicDropdownListByID("mid", rightManufacturerName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Click Search Button");
		log.info("Step 7: Click Search Button");
		searchPO.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show 2 product contains " + advanceSearchProductName);
		
		log.info("VP. Show 1 product");
		verifyEquals(searchPO.getNumberOfProductItems(), 1);
		
		log.info("VP. Show 1 product contains " + advanceSearchProductName);
		verifyTrue(searchPO.isProductListContainsSearchText(advanceSearchProductName));
		
		log.info("VP. Show product Apple MacBook Pro 13-inch");
		verifyTrue(searchPO.isProductPresenceByName(advanceSearchProductName));
		log.info("========End TC_08_Advance_Search_with_Sub_Catalogies_Right_Manufacturer========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_09_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_In_Range() {
		ExtentTestManager.startTest("TC_09_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_In_Range", "Advance Search with Sub Catalogies, right Manufacturer, Price in Range");
		log.info("========Start TC_09_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_In_Range========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Check on checkbox Automatically search sub categories");
		log.info("Step 5: Check on checkbox Automatically search sub categories");
		searchPO.checkToDynamicCheckbox("isc");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Select Manufacturer dropdownlist");
		log.info("Step 6: Select Manufacturer dropdownlist");
		searchPO.selectDynamicDropdownListByID("mid", rightManufacturerName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Input Price");
		log.info("Step 7: Input Price");
		searchPO.inputToDynamicTextbox("pf", "1000");
		searchPO.inputToDynamicTextbox("pt", "2000");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Click Search Button");
		log.info("Step 7: Click Search Button");
		searchPO.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show 2 product contains " + advanceSearchProductName);
		
		log.info("VP. Show 1 product");
		verifyEquals(searchPO.getNumberOfProductItems(), 1);
		
		log.info("VP. Show 1 product contains " + advanceSearchProductName);
		verifyTrue(searchPO.isProductListContainsSearchText(advanceSearchProductName));
		
		log.info("VP. Show product Apple MacBook Pro 13-inch");
		verifyTrue(searchPO.isProductPresenceByName(advanceSearchProductName));
		log.info("========End TC_09_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_In_Range========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_10_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Less_Than_Range() {
		ExtentTestManager.startTest("TC_10_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Less_Than_Range", "Advance Search with Sub Catalogies, right Manufacturer, Price less than Range");
		log.info("========Start TC_10_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Less_Than_Range========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Check on checkbox Automatically search sub categories");
		log.info("Step 5: Check on checkbox Automatically search sub categories");
		searchPO.checkToDynamicCheckbox("isc");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Select Manufacturer dropdownlist");
		log.info("Step 6: Select Manufacturer dropdownlist");
		searchPO.selectDynamicDropdownListByID("mid", rightManufacturerName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Input Price");
		log.info("Step 7: Input Price");
		searchPO.inputToDynamicTextbox("pf", "1000");
		searchPO.inputToDynamicTextbox("pt", "1700");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 8: Click Search Button");
		log.info("Step 8: Click Search Button");
		searchPO.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show error message");
		log.info("VP. Show error message");
		verifyEquals(searchPO.getTextSearchResultMessage(), "No products were found that matched your criteria.");
		
		log.info("========End TC_10_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Less_Than_Range========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_11_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Greater_Than_Range() {
		ExtentTestManager.startTest("TC_11_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Greater_Than_Range", "Advance Search with Sub Catalogies, right Manufacturer, Price greater than Range");
		log.info("========Start TC_11_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Greater_Than_Range========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input product name");
		log.info("Step 1: Input product name");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		searchPO.inputToDynamicTextbox("q", advanceSearchProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Check Advance Search Checkbox");
		log.info("Step 2: Check Advance Search Checkbox");
		searchPO.checkToDynamicCheckbox("adv");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Select Catalogies dropdownlist");
		log.info("Step 3: Select Catalogies dropdownlist");
		searchPO.selectDynamicDropdownListByID("cid", catalogyName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Check on checkbox Automatically search sub categories");
		log.info("Step 5: Check on checkbox Automatically search sub categories");
		searchPO.checkToDynamicCheckbox("isc");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 6: Select Manufacturer dropdownlist");
		log.info("Step 6: Select Manufacturer dropdownlist");
		searchPO.selectDynamicDropdownListByID("mid", rightManufacturerName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 7: Input Price");
		log.info("Step 7: Input Price");
		searchPO.inputToDynamicTextbox("pf", "1900");
		searchPO.inputToDynamicTextbox("pt", "5000");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 8: Click Search Button");
		log.info("Step 8: Click Search Button");
		searchPO.clickToSearchButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Show error message");
		log.info("VP. Show error message");
		verifyEquals(searchPO.getTextSearchResultMessage(), "No products were found that matched your criteria.");
		
		log.info("========End TC_11_Advance_Search_with_Sub_Catalogies_Right_Manufacturer_Price_Greater_Than_Range========");
		ExtentTestManager.endTest();
	}
	
	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePO = PageGeneratorManager.getHomePage(driver);
		ExtentTestManager.startTest("Pre-condition: Login successfully", "Pre-condition: Login successfully");
		log.info("Pre-condition: Login successfully");
		homePO.openUrl(Constants.URL_FRONTEND);
		homePO.clickToDynamicLink("Log in");
		loginPO = PageGeneratorManager.getLoginPage(driver);
		loginPO.loginSuccessfully(Constants.EMAIL_USERNAME, Constants.PASSWORD);

		log.info("Pre-condition: VP. Login successfully");
		homePO = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePO.isLinkDisplayed("My account"));
		verifyTrue(homePO.isLinkDisplayed("Log out"));

		log.info("Pre-condition: Open Search Page");
		homePO.clickToDynamicLink("Search");
		log.info("Pre-condition: VP. Search Page is opened");
		verifyEquals(homePO.getTextPageHeaderTitle(), "Search");
		ExtentTestManager.endTest();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
