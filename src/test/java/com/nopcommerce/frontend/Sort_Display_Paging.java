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
import pageObjects.frontend.ProductListsPO;
import reportConfig.ExtentTestManager;

public class Sort_Display_Paging extends BaseTest {

	WebDriver driver;

	private HomePO homePO;
	private LoginPO loginPO;
	private ProductListsPO productListsPO;

	@Test
	public void TC_01_Sort_Name_A_To_Z() {

		ExtentTestManager.startTest("TC_01_Sort_Name_A_To_Z", "Sort name A to Z");
		log.info("========Start TC_01_Sort_Name_A_To_Z========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select Sort by name A to Z");
		log.info("Step 1: Select Sort by name A to Z");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-orderby", "Name: A to Z");

		productListsPO.waitForPageLoaded();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Products are sorted by name A to Z");
		log.info("VP. Products are sorted by name A to Z");
		verifyTrue(productListsPO.isProductsSortByTitleAsc());
		log.info("========End TC_01_Sort_Name_A_To_Z========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Sort_Name_Z_To_A() {

		ExtentTestManager.startTest("TC_02_Sort_Name_Z_To_A", "Sort name Z to A");
		log.info("========Start TC_02_Sort_Name_Z_To_A========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select Sort by name Z to A");
		log.info("Step 1: Select Sort by name Z to A");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-orderby", "Name: Z to A");

		productListsPO.waitForPageLoaded();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Products are sorted by name Z to A");
		log.info("VP. Products are sorted by name Z to A");
		verifyTrue(productListsPO.isProductsSortByTitleDesc());
		log.info("========End TC_02_Sort_Name_Z_To_A========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Sort_Price_Low_to_High() {

		ExtentTestManager.startTest("TC_03_Sort_Price_Low_to_High", "Sort by Price Low to High");
		log.info("========Start TC_03_Sort_Price_Low_to_High========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select Sort by Price: Low to High");
		log.info("Step 1: Select Sort by Price: Low to High");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-orderby", "Price: Low to High");

		productListsPO.waitForPageLoaded();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Products are sorted by Price: Low to High");
		log.info("VP. Products are sorted by Price: Low to High");
		verifyTrue(productListsPO.isProductsSortByPriceAsc());
		log.info("========End TC_03_Sort_Price_Low_to_High========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Sort_Price_High_to_Low() {

		ExtentTestManager.startTest("TC_04_Sort_Price_High_to_Low", "Sort by Price High to Low");
		log.info("========Start TC_04_Sort_Price_High_to_Low========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select Sort by Price High to Low");
		log.info("Step 1: Select Sort by Price High to Low");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-orderby", "Price: High to Low");

		productListsPO.waitForPageLoaded();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Products are sorted by Price High to Low");
		log.info("VP. Products are sorted by Price High to Low");
		verifyTrue(productListsPO.isProductsSortByPriceDesc());
		log.info("========End TC_04_Sort_Price_High_to_Low========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Verify_Display_3_product_per_page() {

		ExtentTestManager.startTest("TC_05_Verify_Display_3_product_per_page", "Verify display 3 product per page");
		log.info("========Start TC_05_Verify_Display_3_product_per_page========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select display 3 product per page");
		log.info("Step 1: Select display 3 product per page");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-pagesize", "3");

		productListsPO.waitForPageLoaded();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Datagrid are displayed 3 product per page");
		log.info("VP. Datagrid are displayed 3 product per page");
		verifyTrue(productListsPO.getProductsShowedInOnePage() <= 3);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Next icon appear when stay at page 1");
		log.info("VP. Next icon appear when stay at page 1");
		productListsPO.clickToPageNumber("1");
		verifyTrue(productListsPO.isPageIconDisplayed("Next"));
		verifyTrue(productListsPO.isPageIconNotDisplayed("Previous"));
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Previous icon appear when stay at page 2");
		log.info("VP. Previous icon appear when stay at page 2");
		productListsPO.clickToPageNumber("2");
		verifyTrue(productListsPO.isPageIconDisplayed("Previous"));
		verifyTrue(productListsPO.isPageIconNotDisplayed("Next"));
		
		log.info("========End TC_05_Verify_Display_3_product_per_page========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_06_Verify_Display_6_product_per_page() {

		ExtentTestManager.startTest("TC_06_Verify_Display_6_product_per_page", "Verify display 6 product per page");
		log.info("========Start TC_06_Verify_Display_6_product_per_page========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select display 6 product per page");
		log.info("Step 1: Select display 6 product per page");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-pagesize", "6");

		productListsPO.waitForPageLoaded();

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Datagrid are displayed less than 6 product per page");
		log.info("VP. Datagrid are displayed less than 6 product per page");
		verifyTrue(productListsPO.getProductsShowedInOnePage() <= 6);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Paging not displayed");
		log.info("VP. Paging not displayed");
		verifyTrue(productListsPO.isPagingNotDisplayed());
		
		log.info("========End TC_06_Verify_Display_6_product_per_page========");
		ExtentTestManager.endTest();
	}
	@Test
	public void TC_07_Verify_Display_9_product_per_page() {
		
		ExtentTestManager.startTest("TC_07_Verify_Display_9_product_per_page", "Verify display 9 product per page");
		log.info("========Start TC_07_Verify_Display_9_product_per_page========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Select display 9 product per page");
		log.info("Step 1: Select display 9 product per page");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		productListsPO.selectDynamicDropdownListByID("products-pagesize", "9");
		
		productListsPO.waitForPageLoaded();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Datagrid are displayed less than 9 product per page");
		log.info("VP. Datagrid are displayed less than 9 product per page");
		verifyTrue(productListsPO.getProductsShowedInOnePage() <= 9);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Paging not displayed");
		log.info("VP. Paging not displayed");
		verifyTrue(productListsPO.isPagingNotDisplayed());
		
		log.info("========End TC_07_Verify_Display_9_product_per_page========");
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

		log.info("Pre-condition: Open Computers > Notebooks Page");
		homePO.hoverMouseToDynamicMainMenuElement("Computers");
		homePO.clickToDynamicLink("Notebooks ");
		log.info("Pre-condition: VP. Notebooks Page is opened");
		verifyEquals(homePO.getTextPageHeaderTitle(), "Notebooks");
		ExtentTestManager.endTest();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
