package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.frontend.HomePO;
import pageObjects.frontend.LoginPO;
import pageObjects.frontend.MyAccountPO;
import pageObjects.frontend.ProductDetailsPO;
import pageObjects.frontend.ProductReviewsPO;
import pageObjects.frontend.RegisterPO;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class My_Account_Function extends BaseTest {

	WebDriver driver;
	private HomePO homePO;
	private RegisterPO registerPO;
	private MyAccountPO myAccountPO;
	private LoginPO loginPO;
	private ProductDetailsPO productDetailsPO;
	private ProductReviewsPO productReviewsPO;
	
	private String email = "khoa.nguyen" + randomNumber() + "@gmail.com";
	private String firstName = "Khoa";
	private String firstName_updated = "Kingsley";
	private String lastName = "Nguyen";
	private String lastName_updated = "Nguyen";
	private String companyName = "Nexcel";
	private String companyName_updated = "Bosch";
	private String dateOfBirth = "28";
	private String monthOfBirth = "May";
	private String yearOfBirth = "1990";
	private String dateOfBirth_updated = "22";
	private String monthOfBirth_updated = "April";
	private String yearOfBirth_updated = "1994";
	private String password = "1234aaAA";
	private String confirmPassword = "1234aaAA";
	private String countryName = "United States";
	private String state = "Texas";
	private String city = "Dallas";
	private String address1 = "54 Tran Quang Co Tan Phu";
	private String address2 = "Binh Thanh";
	private String zipCode = "640000";
	private String phoneNumber = "0938992805";
	private String faxNumber = "0338808365";
	
	//TC_04
	private String productName="Apple MacBook Pro 13-inch";
	private String reviewTitle="Kingsley review title";
	private String reviewText="Kingsley review text "+productName;
	
	
	@Test
	public void TC_01_Update_Customer_Info() {
		ExtentTestManager.startTest("TC_01_Update_Customer_Info", "Update Customer info");
		log.info("========Start TC_01_Update_Customer_Info========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Navigate to My Account Page");
		log.info("Step 1: Navigate to My Account Page");
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.clickToDynamicLink("My account");
		myAccountPO = PageGeneratorManager.getMyAccountPage(driver);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click to Customer Info link");
		log.info("Step 2: Click to Customer Info link");
		myAccountPO.clickToDynamicLink("Customer info");

		log.info("VP. My Account - Customer info Page open successfully");
		verifyEquals(myAccountPO.getTextPageHeaderTitle(), "My account - Customer info");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Update Customer Info");
		log.info("Step 3: Update Customer Info");

		log.info("Click to Gender: Female");
		myAccountPO.clickToDynamicRadioButton("gender-female");

		log.info("Select Date: " + dateOfBirth_updated);
		myAccountPO.selectDynamicDropdownListByName("DateOfBirthDay", dateOfBirth_updated);

		log.info("Select Month: " + monthOfBirth_updated);
		myAccountPO.selectDynamicDropdownListByName("DateOfBirthMonth", monthOfBirth_updated);

		log.info("Select Years: " + yearOfBirth_updated);
		myAccountPO.selectDynamicDropdownListByName("DateOfBirthYear", yearOfBirth_updated);

		log.info("Input First Name: " + firstName_updated);
		myAccountPO.inputToDynamicTextbox("FirstName", firstName_updated);

		log.info("Input Last Name: " + lastName_updated);
		myAccountPO.inputToDynamicTextbox("LastName", lastName_updated);

		log.info("Input email: " + email);
		myAccountPO.inputToDynamicTextbox("Email", email);

		log.info("Input Company: " + companyName_updated);
		myAccountPO.inputToDynamicTextbox("Company", companyName_updated);

		log.info("Click Save button");
		myAccountPO.clickToDynamicButton("Save");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Verify Customer Info are updated successfully");
		log.info("Step 4: Verify Customer Info are updated successfully");

		log.info("VP. Gender updated successfully");
		verifyTrue(myAccountPO.isCheckboxChecked("gender-female"));

		log.info("VP. FirstName updated successfully");
		verifyEquals(myAccountPO.getDynamicTextboxAttributeValue("FirstName", "value"), firstName_updated);

		log.info("VP. LastName updated successfully");
		verifyEquals(myAccountPO.getDynamicTextboxAttributeValue("LastName", "value"), lastName_updated);

		log.info("VP. Email updated successfully");
		verifyEquals(myAccountPO.getDynamicTextboxAttributeValue("Email", "value"), email);

		log.info("VP. Company updated successfully");
		verifyEquals(myAccountPO.getDynamicTextboxAttributeValue("Company", "value"), companyName_updated);

		log.info("VP. Date Of BirthDay updated successfully");
		verifyEquals(myAccountPO.getTextDynamicDropdownListByName("DateOfBirthDay"), dateOfBirth_updated);

		log.info("VP. Month Of BirthDay updated successfully");
		verifyEquals(myAccountPO.getTextDynamicDropdownListByName("DateOfBirthMonth"), monthOfBirth_updated);

		log.info("VP. Year Of BirthDay updated successfully");
		verifyEquals(myAccountPO.getTextDynamicDropdownListByName("DateOfBirthYear"), yearOfBirth_updated);

		log.info("========End TC_01_Update_Customer_Info========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Add_new_address() {
		ExtentTestManager.startTest("TC_02_Add_new_address", "Add new address of Customer info");
		log.info("========Start TC_02_Add_new_address========");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to My Account Page");
		log.info("Step 1: Navigate to My Account Page");
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.clickToDynamicLink("My account");
		myAccountPO = PageGeneratorManager.getMyAccountPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Open Address page");
		log.info("Step 1: Open Address page");
		myAccountPO.clickToDynamicLink("Addresses");

		log.info("VP. Address page open successfully");
		verifyEquals(myAccountPO.getTextPageHeaderTitle(), "My account - Addresses");

		log.info("Click Add new button");
		myAccountPO.clickToDynamicButton("Add new");

		log.info("Input First Name: " + firstName);
		myAccountPO.inputToDynamicTextbox("Address_FirstName", firstName);

		log.info("Input Last Name: " + lastName);
		myAccountPO.inputToDynamicTextbox("Address_LastName", lastName);

		log.info("Input email: " + email);
		myAccountPO.inputToDynamicTextbox("Address_Email", email);

		log.info("Input Company: " + companyName);
		myAccountPO.inputToDynamicTextbox("Address_Company", companyName);

		log.info("Select Country: " + countryName);
		myAccountPO.selectDynamicDropdownListByID("Address_CountryId", countryName);

		log.info("Select State: " + state);
		myAccountPO.waitForLoadingIconDisappear();
		myAccountPO.selectDynamicDropdownListByID("Address_StateProvinceId", state);

		log.info("Input City: " + city);
		myAccountPO.inputToDynamicTextbox("Address_City", city);

		log.info("Input Address 1: " + address1);
		myAccountPO.inputToDynamicTextbox("Address_Address1", address1);

		log.info("Input Address 2: " + address2);
		myAccountPO.inputToDynamicTextbox("Address_Address2", address2);

		log.info("Input Zip: " + zipCode);
		myAccountPO.inputToDynamicTextbox("Address_ZipPostalCode", zipCode);

		log.info("Input Phone Number: " + phoneNumber);
		myAccountPO.inputToDynamicTextbox("Address_PhoneNumber", phoneNumber);

		log.info("Input Fax number: " + faxNumber);
		myAccountPO.inputToDynamicTextbox("Address_FaxNumber", faxNumber);
		myAccountPO.takeScreenshot("TC_02_Add_new_address");
		log.info("Click Save button");
		myAccountPO.clickToDynamicButton("Save");

		ExtentTestManager.getTest().log(LogStatus.INFO, "VP: Verify address updated successfully");
		log.info("VP: Verify address updated successfully");

		log.info("VP: Verify Name");
		System.out.println(myAccountPO.getTextAddressListByClass("name"));
		verifyEquals(myAccountPO.getTextAddressListByClass("name"), firstName + " " + lastName);

		log.info("VP: Verify Email");
		System.out.println(myAccountPO.getTextAddressListByClass("email"));
		verifyEquals(myAccountPO.getTextAddressListByClass("email"), "Email: " + email);

		log.info("VP: Verify Phone");
		verifyEquals(myAccountPO.getTextAddressListByClass("phone"), "Phone number: " + phoneNumber);

		log.info("VP: Verify Fax");
		verifyEquals(myAccountPO.getTextAddressListByClass("fax"), "Fax number: " + faxNumber);

		log.info("VP: Verify Company");
		verifyEquals(myAccountPO.getTextAddressListByClass("company"), companyName);

		log.info("VP: Verify Address 1");
		verifyEquals(myAccountPO.getTextAddressListByClass("address1"), address1);

		log.info("VP: Verify Address 2");
		verifyEquals(myAccountPO.getTextAddressListByClass("address2"), address2);

		log.info("VP: Verify City - State - Zip");
		verifyEquals(myAccountPO.getTextAddressListByClass("city-state-zip"), city + ", " + state + ", " + zipCode);

		log.info("VP: Verify Country");
		verifyEquals(myAccountPO.getTextAddressListByClass("country"), countryName);
		myAccountPO.takeScreenshot("TC_02_Add_new_address");
		log.info("========End TC_02_Add_new_address========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Change_Password() {
		ExtentTestManager.startTest("TC_03_Change_Password", "Verify Change Password successfully");
		log.info("========Start TC_03_Change_Password========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to My Account Page");
		log.info("Step 1: Navigate to My Account Page");
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.clickToDynamicLink("My account");
		myAccountPO = PageGeneratorManager.getMyAccountPage(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Open Change Password page");
		log.info("Step 1: Open Change password page");
		myAccountPO.clickToDynamicLink("Change password");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Update new password");
		log.info("Step 2: Update new password");

		log.info("Input old password");
		myAccountPO.inputToDynamicTextbox("OldPassword", password);

		String newPassword = "1234aaBB";
		log.info("Input new password");
		myAccountPO.inputToDynamicTextbox("NewPassword", newPassword);

		log.info("Input confirm new password");
		myAccountPO.inputToDynamicTextbox("ConfirmNewPassword", newPassword);

		log.info("Click Change password Button");
		myAccountPO.clickToDynamicButton("Change password");

		log.info("VP. Show message update password successfully");
		verifyEquals(myAccountPO.getTextResultMessage(), "Password was changed");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Log out and Re-Login with new password");
		log.info("Step 3: Log out and Re-Login with new password");

		log.info("Log out");
		myAccountPO.clickToDynamicLink("Log out");

		log.info("Re-Login with new password");
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.clickToDynamicLink("Log in");
		loginPO = PageGeneratorManager.getLoginPage(driver);
		loginPO.loginSuccessfully(email, newPassword);
		homePO = PageGeneratorManager.getHomePage(driver);

		log.info("VP. Re-Login with new password successfully");
		verifyTrue(homePO.isLinkDisplayed("My account"));
		verifyTrue(homePO.isLinkDisplayed("Log out"));

		log.info("========End TC_03_Change_Password========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Add_Product_review() {
		ExtentTestManager.startTest("TC_04_Add_Product_review", "Verify Add product review successfully");
		log.info("========Start TC_04_Add_Product_review========");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Open Home page");
		log.info("Step 1: Open Home page");
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.openHomePage();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click on a product");
		log.info("Step 2: Click on a product");
		homePO.clickToDynamicLink(productName);
		
		log.info("VP. Verify Product details page open");
		productDetailsPO = PageGeneratorManager.getProductDetailsPage(driver);
		verifyEquals(productDetailsPO.getTextProductTitle(),productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 3: Click on Add review");
		log.info("Step 3: Click on Add review");
		productDetailsPO.clickToDynamicLink("Add your review");
		
		log.info("VP. Open Product Reviews Page");
		productReviewsPO = PageGeneratorManager.getProductReviewsPage(driver);
		verifyEquals(productReviewsPO.getTextPageHeaderTitle(), "Product reviews for "+productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 4: Fill in review info");
		log.info("Step 4: Fill in review info");
		
		log.info("Input review title");
		productReviewsPO.inputToDynamicTextbox("AddProductReview_Title", reviewTitle);
		
		log.info("Input review text");
		productReviewsPO.inputToDynamicTextarea("AddProductReview_ReviewText", reviewText);
		
		log.info("Click to Rating");
		productReviewsPO.clickToDynamicButton("5");
		
		log.info("Click to Submit Review");
		productReviewsPO.clickToDynamicButton("Submit review");
		
		log.info("VP. Product review added successfully");
		verifyEquals(productReviewsPO.getTextResultMessage(), "Product review is successfully added.");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 5: Verify review show in My Account - Product Review");
		log.info("Step 5: Verify review show in My Account - Product Review");
		
		log.info("Open My Account");
		productReviewsPO.clickToDynamicLink("My account");
		myAccountPO = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("Open My Product Review");
		myAccountPO.clickToDynamicLink("My product reviews");
		
		log.info("VP. My Product review is opened");
		verifyEquals(myAccountPO.getTextPageHeaderTitle(), "My account - My product reviews");
		
		log.info("VP: Verify Review Title");
		System.out.println(myAccountPO.getTextReviewListByClass("review-title"));
		verifyEquals(myAccountPO.getTextReviewListByClass("review-title"), reviewTitle);
		
		log.info("VP: Verify Review Text");
		System.out.println(myAccountPO.getTextReviewListByClass("review-text"));
		verifyEquals(myAccountPO.getTextReviewListByClass("review-text"), reviewText);
		
		log.info("VP: Verify Review Info contains product name: " + productName);
		System.out.println(myAccountPO.getTextReviewListByClass("review-text"));
		verifyTrue(myAccountPO.getTextReviewListByClass("review-info").contains(productName));
		
		log.info("========Start TC_04_Add_Product_review========");
		ExtentTestManager.endTest();
	}

	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.openUrl(Constants.URL_FRONTEND);
		ExtentTestManager.startTest("Pre-condition: Register account", "Pre-condition: Register account");
		log.info("Pre-condition: Register account");
		homePO.clickToDynamicLink("Register");
		registerPO = PageGeneratorManager.getRegisterPage(driver);

		log.info("VP. Register Page open successfully");
		verifyEquals(registerPO.getTextPageHeaderTitle(), "Register");

		log.info("Pre-condition: Input valid info");

		log.info("Pre-condition: Click to Gender");
		registerPO.clickToDynamicRadioButton("gender-male");

		log.info("Pre-condition: Select Date");
		registerPO.selectDynamicDropdownListByName("DateOfBirthDay", dateOfBirth);

		log.info("Pre-condition: Select Month");
		registerPO.selectDynamicDropdownListByName("DateOfBirthMonth", monthOfBirth);

		log.info("Pre-condition: Select Years");
		registerPO.selectDynamicDropdownListByName("DateOfBirthYear", yearOfBirth);

		log.info("Pre-condition: Input First Name: " + firstName);
		registerPO.inputToDynamicTextbox("FirstName", firstName);

		log.info("Pre-condition: Input Last Name: " + lastName);
		registerPO.inputToDynamicTextbox("LastName", lastName);

		log.info("Pre-condition: Input email: " + email);
		registerPO.inputToDynamicTextbox("Email", email);

		log.info("Pre-condition: Input Company: " + companyName);
		registerPO.inputToDynamicTextbox("Company", companyName);

		log.info("Pre-condition: Uncheck Checkbox Newsletter");
		registerPO.uncheckToDynamicCheckbox("Newsletter");

		log.info("Pre-condition: Input Password: " + password);
		registerPO.inputToDynamicTextbox("Password", password);

		log.info("Pre-condition: Input Password: " + confirmPassword);
		registerPO.inputToDynamicTextbox("ConfirmPassword", confirmPassword);

		log.info("Pre-condition: Click Register button");
		registerPO.clickToDynamicButton("Register");

		log.info("Verify register successfully message");
		verifyEquals(registerPO.getTextResultMessage(), "Your registration completed");
		ExtentTestManager.endTest();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
