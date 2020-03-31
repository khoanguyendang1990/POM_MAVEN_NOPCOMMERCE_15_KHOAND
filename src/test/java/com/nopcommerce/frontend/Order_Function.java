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
import pageObjects.frontend.CheckOutPO;
import pageObjects.frontend.HomePO;
import pageObjects.frontend.LoginPO;
import pageObjects.frontend.MyAccountPO;
import pageObjects.frontend.OrdersInformationPO;
import pageObjects.frontend.ProductDetailsPO;
import pageObjects.frontend.ProductListsPO;
import pageObjects.frontend.ShoppingCartPO;
import pageUIs.frontend.MyAccountPageUI;
import reportConfig.ExtentTestManager;

public class Order_Function extends BaseTest {

	WebDriver driver;

	private HomePO homePO;
	private LoginPO loginPO;
	private ProductListsPO productListsPO;
	private ProductDetailsPO productDetailsPO;
	private ShoppingCartPO shoppingCartPO;
	private CheckOutPO checkOutPO;
	private MyAccountPO myAccountPO;
	private OrdersInformationPO ordersInformationPO;
	
	//TC_01
	private String productName="Build your own computer";
	private String processor="2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	private String ram="8GB [+$60.00]";
	private String hdd="400 GB [+$100.00]";
	private String os="Vista Premium [+$60.00]";
	private String software1="Microsoft Office [+$50.00]";
	private String software2="Acrobat Reader [+$10.00]";
	private String software3="Total Commander [+$5.00]";
	private String unitPrice="$1,500.00";
	private String subTotal="$1,500.00";
	private String quantity="1";
	//TC_02
	private String processor_updated="2.2 GHz Intel Pentium Dual-Core E2200";
	private String ram_updated="4GB [+$20.00]";
	private String hdd_updated="320 GB";
	private String os_updated="Vista Home [+$50.00]";
	private String unitPrice_updated="$1,320.00";
	private String subTotal_updated="$2,640.00";
	private String quantity_updated="2";
	
	//TC_05
	private String orderProductName="Apple MacBook Pro 13-inch";
	private String orderUnitPrice="$1,800.00";
	private String orderQuantity="2";
	private String orderTotalPrice="$3,600.00";
	private String orderShippingCost="$0.00";
	private String orderTax="$0.00";
	private String orderTotal="$3,600.00";
	private String orderEarnRewardPoint="360 points";
	
	private String billAddrFirstName = "Khoa";
	private String billAddrLastName = "Nguyen";
	private String billAddrEmail = "khoa.nguyen280590@gmail.com";
	private String billAddrCountryName = "United States";
	private String billAddrState = "Texas";
	private String billAddrCity = "Dallas";
	private String billAddrAddress1 = "54 Tran Quang Co Tan Phu";
	private String billAddrZipCode = "640000";
	private String billAddrPhoneNumber = "0938992805";
	
	private String shipAddrFirstName = "Auto";
	private String shipAddrLastName = "Test";
	private String shipAddrEmail = "test.auto@gmail.com";
	private String shipAddrCountryName = "United States"; 
	private String shipAddrState = "New York";
	private String shipAddrCity = "New York";
	private String shipAddrAddress1 = "SMS Nexcel";
	private String shipAddrZipCode = "740000";
	private String shipAddrPhoneNumber = "0338808365";
	
	private String paymentMethod = "Check / Money Order";
	private String shippingMethod = "Ground";
	
	@Test
	public void TC_01_Add_Product_To_Cart() {
		
		ExtentTestManager.startTest("TC_01_Add_Product_To_Cart", "Add Product to Cart");
		log.info("========Start TC_01_Add_Product_To_Cart========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Computers > Desktops page");
		log.info("Navigate to Computers > Desktops page");
		homePO.hoverMouseToDynamicMainMenuElement("Computers");
		homePO.clickToDynamicLink("Desktops");
		
		log.info("Pre-condition: VP. Desktops Page is opened");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		verifyEquals(productListsPO.getTextPageHeaderTitle(), "Desktops");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Build your own computer");
		log.info("Click on Build your own computer");
		productListsPO.clickToDynamicLink(productName);
		
		log.info("VP. Build your own computer is opened");
		productDetailsPO = PageGeneratorManager.getProductDetailsPage(driver);
		verifyEquals(productDetailsPO.getTextProductTitle(), productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Select option for computer");
		log.info("Select option for computer");
		
		log.info("Select Processor");
		productDetailsPO.selectDynamicDropdownListByID("product_attribute_1", processor);
		
		log.info("Select RAM");
		productDetailsPO.selectDynamicDropdownListByID("product_attribute_2", ram);
		
		log.info("Select HDD");
		productDetailsPO.clickToDynamicRadioButton("product_attribute_3_7");
		
		log.info("Select OS");
		productDetailsPO.clickToDynamicRadioButton("product_attribute_4_9");
		
		log.info("Select Software");
		productDetailsPO.checkToDynamicCheckbox("product_attribute_5_10");
		productDetailsPO.checkToDynamicCheckbox("product_attribute_5_11");
		productDetailsPO.checkToDynamicCheckbox("product_attribute_5_12");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click button Add to Cart");
		log.info("Click button Add to Cart");
		productDetailsPO.clickToDynamicButton("Add to cart");
		
		log.info("VP.Show message product has been added to shopping cart successfully");
		verifyEquals(productDetailsPO.getNotificationMessage(),"The product has been added to your shopping cart");
		productDetailsPO.closeNotificationBar();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Verify product has been added to shopping cart");
		log.info("VP. Verify product has been added to shopping cart");
		productDetailsPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		
		log.info("VP. Verify quatity product has been added to shopping cart");
		verifyEquals(productDetailsPO.getTextMiniShoppingCartProductCounted(),"There are "+quantity+" item(s) in your cart.");
		verifyEquals(productDetailsPO.getTextMiniShoppingCartProductName(),productName);
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(processor));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(hdd));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(os));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(software1));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(software2));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(software3));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductPrice().contains(unitPrice));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductQuantity().contains(quantity));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductSubTotal().contains(subTotal));
		
		log.info("========End TC_01_Add_Product_To_Cart========");
		ExtentTestManager.endTest();
	}
	
	@Test(dependsOnMethods = "TC_01_Add_Product_To_Cart")
	public void TC_02_Edit_Product_In_Cart() {
		ExtentTestManager.startTest("TC_02_Edit_Product_In_Cart", "Edit Product In Cart");
		log.info("========Start TC_02_Edit_Product_In_Cart========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Cart");
		log.info("Navigate to Cart");
		productDetailsPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		productDetailsPO.clickToDynamicButton("Go to cart");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Edit Product");
		log.info("Click on Edit Product");
		productDetailsPO.clickToDynamicLink("Edit");
		
		log.info("VP. Build your own computer is opened");
		verifyEquals(productDetailsPO.getTextProductTitle(), productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Select option for computer");
		log.info("Select option for computer");
		
		log.info("Select Processor");
		productDetailsPO.selectDynamicDropdownListByID("product_attribute_1", processor_updated);
		
		log.info("Select RAM");
		productDetailsPO.selectDynamicDropdownListByID("product_attribute_2", ram_updated);
		
		log.info("Select HDD");
		productDetailsPO.clickToDynamicRadioButton("product_attribute_3_6");
		
		log.info("Select OS");
		productDetailsPO.clickToDynamicRadioButton("product_attribute_4_8");
		
		log.info("Select Software");
		productDetailsPO.checkToDynamicCheckbox("product_attribute_5_10");
		productDetailsPO.uncheckToDynamicCheckbox("product_attribute_5_11");
		productDetailsPO.uncheckToDynamicCheckbox("product_attribute_5_12");
		
		log.info("Input quantity");
		productDetailsPO.inputToDynamicTextbox("addtocart_1_EnteredQuantity", quantity_updated);
		
		log.info("Click to Update");
		productDetailsPO.clickToDynamicButton("Update");
		
		log.info("VP.Show message product has been added to shopping cart successfully");
		verifyEquals(productDetailsPO.getNotificationMessage(),"The product has been added to your shopping cart");
		productDetailsPO.closeNotificationBar();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Verify product has been updated to shopping cart");
		log.info("VP. Verify product has been updated to shopping cart");
		productDetailsPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		
		log.info("VP. Verify quatity product has been updated to shopping cart");
		verifyEquals(productDetailsPO.getTextMiniShoppingCartProductCounted(),"There are "+quantity_updated+" item(s) in your cart.");
		verifyEquals(productDetailsPO.getTextMiniShoppingCartProductName(),productName);
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(processor_updated));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(hdd_updated));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(os_updated));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(software1));
		verifyFalse(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(software2));
		verifyFalse(productDetailsPO.getTextMiniShoppingCartProductAttributes().contains(software3));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductPrice().contains(unitPrice_updated));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductQuantity().contains(quantity_updated));
		verifyTrue(productDetailsPO.getTextMiniShoppingCartProductSubTotal().contains(subTotal_updated));

		log.info("========End TC_02_Edit_Product_In_Cart========");
		ExtentTestManager.endTest();
	}
	
	@Test(dependsOnMethods = "TC_02_Edit_Product_In_Cart")
	public void TC_03_Remove_Product_In_Cart() {
		ExtentTestManager.startTest("TC_03_Remove_Product_In_Cart", "Remove Product In Cart");
		log.info("========Start TC_03_Remove_Product_In_Cart========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Cart");
		log.info("Navigate to Cart");
		productDetailsPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		productDetailsPO.clickToDynamicButton("Go to cart");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Check on checkbox remove Product");
		log.info("Check on checkbox remove Product");
		shoppingCartPO = PageGeneratorManager.getShippingCartPage(driver);
		shoppingCartPO.checkToRemoveCheckboxOfProduct(productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click to Update Shopping Cart");
		log.info("Click to Update Shopping Cart");
		shoppingCartPO.clickToDynamicButton("Update shopping cart");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Shopping Cart is empty");
		log.info("VP. Shopping Cart is empty");
		verifyEquals(shoppingCartPO.getShoppingCartOrderSummaryContent(),"Your Shopping Cart is empty!");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Mini Shopping Cart is empty");
		log.info("VP. Mini Shopping Cart is empty");
		shoppingCartPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		verifyEquals(shoppingCartPO.getTextMiniShoppingCartProductCounted(),"You have no items in your shopping cart.");
		
		log.info("========End TC_03_Remove_Product_In_Cart========");
		ExtentTestManager.endTest();
	}
	

	@Test(dependsOnMethods = "TC_03_Remove_Product_In_Cart")
	public void TC_05_Order_And_CheckOut() {
		
		ExtentTestManager.startTest("TC_05_Order_And_CheckOut", "Order and CheckOut");
		log.info("========Start TC_05_Order_And_CheckOut========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Computers > Notebooks page");
		log.info("Navigate to Computers > Desktops page");
		homePO=PageGeneratorManager.getHomePage(driver);
		homePO.openHomePage();
		homePO.hoverMouseToDynamicMainMenuElement("Computers");
		homePO.clickToDynamicLink("Notebooks ");
		
		log.info("VP. Notebooks Page is opened");
		productListsPO = PageGeneratorManager.getProductListsPage(driver);
		verifyEquals(productListsPO.getTextPageHeaderTitle(), "Notebooks");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click on product: "+orderProductName);
		log.info("Click on product: "+orderProductName);
		productListsPO.clickToDynamicLink(orderProductName);
		
		log.info("VP. "+orderProductName+" is opened");
		productDetailsPO = PageGeneratorManager.getProductDetailsPage(driver);
		verifyEquals(productDetailsPO.getTextProductTitle(), orderProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input 2 quantity");
		log.info("Input 2 quantity");
		productDetailsPO.inputToDynamicTextbox("addtocart_4_EnteredQuantity", orderQuantity);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click button Add to Cart");
		log.info("Click button Add to Cart");
		productDetailsPO.clickToDynamicButton("Add to cart");
		
		log.info("VP.Show message product has been added to shopping cart successfully");
		verifyEquals(productDetailsPO.getNotificationMessage(),"The product has been added to your shopping cart");
		productDetailsPO.closeNotificationBar();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Cart");
		log.info("Navigate to Cart");
		productDetailsPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		productDetailsPO.clickToDynamicButton("Go to cart");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input info before Checkout");
		log.info("Input info before Checkout");
		shoppingCartPO = PageGeneratorManager.getShippingCartPage(driver);
		
		log.info("Select Gift Wrapping?");
		shoppingCartPO.selectDynamicDropdownListByID("checkout_attribute_1", "No");
		
		log.info("Select Country");
		shoppingCartPO.selectDynamicDropdownListByID("CountryId", "Viet Nam");
		
		log.info("Input Zip Code");
		shoppingCartPO.inputToDynamicTextbox("ZipPostalCode", "70000");
		
		log.info("Check on checkbox Accept Term");
		shoppingCartPO.checkToDynamicCheckbox("termsofservice");
		
		log.info("Click on Checkout Button");
		shoppingCartPO.clickToCheckOutButton();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Open Checkout Page");
		log.info("Open Checkout Page");
		
		log.info("VP. Checkout Page is opened");
		checkOutPO = PageGeneratorManager.getCheckOutPage(driver);
		verifyEquals(checkOutPO.getTextPageHeaderTitle(), "Checkout");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input Billing Address info");
		log.info("Input Billing Address info");
		checkOutPO.uncheckToDynamicCheckbox("ShipToSameAddress");
		checkOutPO.selectDynamicDropdownListByID("billing-address-select", "New Address");
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_FirstName", billAddrFirstName);
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_LastName", billAddrLastName);
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_Email", billAddrEmail);
		checkOutPO.selectDynamicDropdownListByID("BillingNewAddress_CountryId", billAddrCountryName);
		checkOutPO.waitForLoadingIconDisappear();
		checkOutPO.selectDynamicDropdownListByID("BillingNewAddress_StateProvinceId", billAddrState);
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_City", billAddrCity);
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_Address1", billAddrAddress1);
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_ZipPostalCode", billAddrZipCode);
		checkOutPO.inputToDynamicTextbox("BillingNewAddress_PhoneNumber", billAddrPhoneNumber);

		log.info("Billing Method Page > Click To Continue");
		checkOutPO.clickToDynamicContinueButtonOfMethod("billing-buttons-container");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input Shipping Address info");
		log.info("Input Shipping Address info");
		checkOutPO.selectDynamicDropdownListByID("shipping-address-select", "New Address");
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_FirstName", shipAddrFirstName);
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_LastName", shipAddrLastName);
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_Email", shipAddrEmail);
		checkOutPO.selectDynamicDropdownListByID("ShippingNewAddress_CountryId", shipAddrCountryName);
		checkOutPO.waitForLoadingIconDisappear();
		checkOutPO.sleepInSecond(1);
		checkOutPO.selectDynamicDropdownListByID("ShippingNewAddress_StateProvinceId", shipAddrState);
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_City", shipAddrCity);
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_Address1", shipAddrAddress1);
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_ZipPostalCode", shipAddrZipCode);
		checkOutPO.inputToDynamicTextbox("ShippingNewAddress_PhoneNumber", shipAddrPhoneNumber);

		log.info("Shipping Address Page > Click To Continue");
		checkOutPO.clickToDynamicContinueButtonOfMethod("shipping-buttons-container");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input Shipping Method info");
		log.info("Input Shipping Method info");
		checkOutPO.clickToDynamicRadioButton("shippingoption_0");
		
		log.info("Shipping Method Page > Click To Continue");
		checkOutPO.clickToDynamicContinueButtonOfMethod("shipping-method-buttons-container");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input Payment Method");
		log.info("Input Payment Method");
		checkOutPO.clickToDynamicRadioButton("paymentmethod_0");
		
		log.info("Payment Method Page > Click To Continue");
		checkOutPO.clickToDynamicContinueButtonOfMethod("payment-method-buttons-container");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Input Payment Info");
		log.info("Payment Info Page > Click To Continue");
		checkOutPO.clickToDynamicContinueButtonOfMethod("payment-info-buttons-container");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Verify Confirm Order");
		log.info("VP. Verify Confirm Order");
		
		log.info("VP. Verify Billing Address");
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Billing Address", "name"),billAddrFirstName+" "+billAddrLastName);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Billing Address", "email"),"Email: "+billAddrEmail);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Billing Address", "phone"),"Phone: "+billAddrPhoneNumber);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Billing Address", "address1"),billAddrAddress1);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Billing Address", "city-state-zip"),billAddrCity+", "+billAddrState+", "+billAddrZipCode);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Billing Address", "country"),billAddrCountryName);
		
		log.info("VP. Verify Shipping Address");
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping Address", "name"),shipAddrFirstName+" "+shipAddrLastName);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping Address", "email"),"Email: "+shipAddrEmail);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping Address", "phone"),"Phone: "+shipAddrPhoneNumber);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping Address", "address1"),shipAddrAddress1);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping Address", "city-state-zip"),shipAddrCity+", "+shipAddrState+", "+shipAddrZipCode);
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping Address", "country"),shipAddrCountryName);
		
		log.info("VP. Verify Payment");
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Payment", "payment-method"),"Payment Method: "+paymentMethod);
		
		log.info("VP. Verify Shipping");
		verifyEquals(checkOutPO.getTextDynamicCheckOutInfo("Shipping", "shipping-method"),"Shipping Method: "+shippingMethod);
		
		log.info("VP. Verify Shopping Cart info");
		verifyEquals(checkOutPO.getTextDynamicShoppingCartInfo(orderProductName, "product-unit-price"),orderUnitPrice);
		verifyEquals(checkOutPO.getTextDynamicShoppingCartInfo(orderProductName, "product-quantity"),orderQuantity);
		verifyEquals(checkOutPO.getTextDynamicShoppingCartInfo(orderProductName, "product-subtotal"),orderTotalPrice);
		
		log.info("VP. Verify Shopping Cart - Total info");
		verifyEquals(checkOutPO.getTextTotalInfoSubTotal(),orderTotalPrice);
		verifyEquals(checkOutPO.getTextTotalInfoShippingCost(),orderShippingCost);
		verifyEquals(checkOutPO.getTextTotalInfoTax(),orderTax);
		verifyEquals(checkOutPO.getTextTotalInfoTotal(),orderTotal);
		verifyEquals(checkOutPO.getTextTotalInfoEarnRewardPoint(),orderEarnRewardPoint);
		
		log.info("Click to Confirm button");
		checkOutPO.clickToDynamicButton("Confirm");
		
		log.info("VP. Verify success message display");
		verifyEquals(checkOutPO.getTextOrderCompleteTitle(),"Your order has been successfully processed!");
		
		String orderNumber=checkOutPO.getTextOrderNumber();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Order number: " +orderNumber);
		log.info("Order number: " +orderNumber);
		System.out.println("Order number: " +orderNumber);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to My Account > Order. Verify order info");
		log.info("Navigate to My Account > Order. Verify order info");
		checkOutPO.clickToDynamicLink("My account");
		
		myAccountPO=PageGeneratorManager.getMyAccountPage(driver);
		myAccountPO.clickToDynamicLink("Orders");
		
		log.info("VP. My Account - Orders Page open");
		verifyEquals(myAccountPO.getTextPageHeaderTitle(), "My account - Orders");
		
		log.info("VP. Order Number is displayed in Order List");
		verifyTrue(myAccountPO.isOrderNumberDisplayInOrderList(orderNumber));
		
		log.info("Click To Order Details");
		myAccountPO.clickToDetailsOfOrderNumber(orderNumber);
		
		log.info("VP. Orders Information Page is opened");
		ordersInformationPO=PageGeneratorManager.getOrdersInformationPage(driver);
		verifyEquals(ordersInformationPO.getTextPageHeaderTitle(),"Order information");
		
		log.info("VP. Order Number is displayed in Order List");
		verifyTrue(ordersInformationPO.isOrderNumberDisplayInOrderList(orderNumber));
		
		log.info("VP. Verify Product info");
		verifyEquals(ordersInformationPO.getTextDynamicOrderProductInfo(orderProductName, "product-unit-price"),orderUnitPrice);
		verifyEquals(ordersInformationPO.getTextDynamicOrderProductInfo(orderProductName, "product-quantity"),orderQuantity);
		verifyEquals(ordersInformationPO.getTextDynamicOrderProductInfo(orderProductName, "product-subtotal"),orderTotalPrice);
		
		log.info("VP. Orders Information Page is opened");
		verifyEquals(ordersInformationPO.getTextDynamicTotalInfoValueByRowName("Sub-Total"),orderTotalPrice);
		verifyEquals(ordersInformationPO.getTextDynamicTotalInfoValueByRowName("Shipping"),orderShippingCost);
		verifyEquals(ordersInformationPO.getTextDynamicTotalInfoValueByRowName("Tax"),orderTax);
		verifyEquals(ordersInformationPO.getTextDynamicTotalInfoValueByRowName("Order Total"),orderTotal);
		
		log.info("========End TC_05_Order_And_CheckOut========");
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
		ExtentTestManager.endTest();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	public void Remove_Product_In_Cart() {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Cart");
		log.info("Navigate to Cart");
		productDetailsPO =PageGeneratorManager.getProductDetailsPage(driver);
		productDetailsPO.hoverMouseToDynamicHeaderUpperElement("Shopping cart");
		productDetailsPO.clickToDynamicButton("Go to cart");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Check on checkbox remove Product");
		log.info("Check on checkbox remove Product");
		shoppingCartPO = PageGeneratorManager.getShippingCartPage(driver);
		shoppingCartPO.checkToRemoveCheckboxOfProduct(orderProductName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Click to Update Shopping Cart");
		log.info("Click to Update Shopping Cart");
		shoppingCartPO.clickToDynamicButton("Update shopping cart");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "VP. Shopping Cart is empty");
		log.info("VP. Shopping Cart is empty");
		verifyEquals(shoppingCartPO.getShoppingCartOrderSummaryContent(),"Your Shopping Cart is empty!");
	}
}
