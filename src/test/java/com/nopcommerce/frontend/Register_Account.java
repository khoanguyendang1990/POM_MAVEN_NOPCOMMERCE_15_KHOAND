package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.frontend.HomePO;
import pageObjects.frontend.RegisterPO;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_Account extends BaseTest {

	WebDriver driver;
	private HomePO homePO;
	private RegisterPO registerPO;
	
	private String invalidEmail="khoa.nguyen";
	private String email="khoa.nguyen"+randomNumber()+"@gmail.com";
	private String existingEmail="khoa.nguyen280590@gmail.com";
	private String firstName="Khoa";
	private String lastName="Nguyen";
	private String companyName="Nexcel";
	private String password="1234aaAA";
	private String confirmPassword="1234aaAA";
	
	@Test
	public void TC_01_Register_with_empty_data() {
		ExtentTestManager.startTest("TC_01_Register_with_empty_data", "Register with empty data");
		log.info("========Start TC_01_Register_with_empty_data========");
		
		log.info("VP. Register Page is opened");
		verifyEquals(registerPO.getTextPageHeaderTitle(),"Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Click Register button with empty data");
		log.info("Step 1: Click Register button with empty data");
		registerPO.clickToDynamicButton("Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at mandatory fields");
		log.info("Verify First name error message");
		verifyEquals(registerPO.getTextDynamicErrorMessage("FirstName-error"), "First name is required.");
		
		log.info("Verify Last name error message");
		verifyEquals(registerPO.getTextDynamicErrorMessage("LastName-error"), "Last name is required.");
		
		log.info("Verify Email error message");
		verifyEquals(registerPO.getTextDynamicErrorMessage("Email-error"), "Email is required.");
		
		log.info("Verify Last name error message");
		verifyEquals(registerPO.getTextDynamicErrorMessage("Password-error"), "Password is required.");
		
		log.info("Verify Last name error message");
		verifyEquals(registerPO.getTextDynamicErrorMessage("ConfirmPassword-error"), "Password is required.");
		log.info("========End TC_01_Register_with_empty_data========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_02_Register_with_invalid_email() {
		ExtentTestManager.startTest("TC_02_Register_with_invalid_email", "Register with invalid email");
		log.info("========Start TC_02_Register_with_invalid_email========");
		
		log.info("VP. Register Page is opened");
		verifyEquals(registerPO.getTextPageHeaderTitle(),"Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input invalid email");
		log.info("Step 1: Input invalid email");
		registerPO.inputToDynamicTextbox("Email", invalidEmail);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Register button");
		log.info("Step 2: Click Register button");
		registerPO.clickToDynamicButton("Register");
		
		log.info("Verify Email error message show Wrong email");
		verifyEquals(registerPO.getTextDynamicErrorMessage("Email-error"), "Wrong email");
		log.info("========End TC_02_Register_with_invalid_email========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_03_Register_with_existing_email() {
		ExtentTestManager.startTest("TC_03_Register_with_existing_email", "Register with existing email");
		log.info("========Start TC_03_Register_with_existing_email========");
		
		log.info("VP. Register Page is opened");
		verifyEquals(registerPO.getTextPageHeaderTitle(),"Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input existing email");
		log.info("Step 1: Input existing email");
		registerPO.inputToDynamicTextbox("Email", existingEmail);
		
		log.info("Input First Name");
		registerPO.inputToDynamicTextbox("FirstName", firstName);
		
		log.info("Input Last Name");
		registerPO.inputToDynamicTextbox("LastName", lastName);
		
		log.info("Input Password");
		registerPO.inputToDynamicTextbox("Password", password);
		
		log.info("Input Password");
		registerPO.inputToDynamicTextbox("ConfirmPassword", confirmPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Register button");
		log.info("Step 2: Click Register button");
		registerPO.clickToDynamicButton("Register");
		
		log.info("Verify Email error message show Wrong email");
		verifyEquals(registerPO.getTextValidationErrorMessage(), "The specified email already exists");
		log.info("========End TC_03_Register_with_existing_email========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Register_with_password_less_than_6_character() {
		ExtentTestManager.startTest("TC_04_Register_with_password_less_than_6_character", "Register with password less than 6 character");
		log.info("========Start TC_04_Register_with_password_less_than_6_character========");
		
		log.info("VP. Register Page is opened");
		verifyEquals(registerPO.getTextPageHeaderTitle(),"Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input password less than 6 character");
		log.info("Step 1: Input password less than 6 character");
		registerPO.inputToDynamicTextbox("Password", "1234");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Register button");
		log.info("Step 2: Click Register button");
		registerPO.clickToDynamicButton("Register");
		
		log.info("Verify password error message show Password must meet the following rules: must have at least 6 characters");
		verifyEquals(registerPO.getTextDynamicErrorMessage("Password-error"), "Password must meet the following rules:"+"\n"+"must have at least 6 characters");
		log.info("========End TC_04_Register_with_password_less_than_6_character========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_05_Register_with_confirmpassword_not_same_password() {
		ExtentTestManager.startTest("TC_05_Register_with_confirmpassword_not_same_password", "Register with confirm password doesn't match password");
		log.info("========Start TC_05_Register_with_confirmpassword_not_same_password========");
		
		log.info("VP. Register Page is opened");
		verifyEquals(registerPO.getTextPageHeaderTitle(),"Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input password and confirmation password do not match");
		log.info("Step 1: Input password and confirmation password do not match");
		registerPO.inputToDynamicTextbox("Password", password);
		registerPO.inputToDynamicTextbox("ConfirmPassword", password+"1");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Register button");
		log.info("Step 2: Click Register button");
		registerPO.clickToDynamicButton("Register");
		
		log.info("Verify password error message show The password and confirmation password do not match.");
		verifyEquals(registerPO.getTextDynamicErrorMessage("ConfirmPassword-error"), "The password and confirmation password do not match.");
		log.info("========End TC_05_Register_with_confirmpassword_not_same_password========");
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_06_Register_with_valid_info() {
		ExtentTestManager.startTest("TC_06_Register_with_valid_info", "Register with valid info");
		log.info("========Start TC_06_Register_with_valid_info========");
		
		log.info("VP. Register Page is opened");
		verifyEquals(registerPO.getTextPageHeaderTitle(),"Register");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input existing email");
		log.info("Step 1: Input valid info");
		
		log.info("Click to Gender");
		registerPO.clickToDynamicRadioButton("gender-male");
		
		log.info("Select Date");
		registerPO.selectDynamicDropdownListByName("DateOfBirthDay", "28");
		
		log.info("Select Month");
		registerPO.selectDynamicDropdownListByName("DateOfBirthMonth", "May");
		
		log.info("Select Years");
		registerPO.selectDynamicDropdownListByName("DateOfBirthYear", "1990");
		
		log.info("Input First Name: " +firstName);
		registerPO.inputToDynamicTextbox("FirstName", firstName);
		
		log.info("Input Last Name: "+ lastName);
		registerPO.inputToDynamicTextbox("LastName", lastName);
		
		log.info("Input email: " + email);
		registerPO.inputToDynamicTextbox("Email", email);
		
		log.info("Input Company: "+ companyName);
		registerPO.inputToDynamicTextbox("Company", companyName);
		
		log.info("Uncheck Checkbox Newsletter");
		registerPO.uncheckToDynamicCheckbox("Newsletter");
		
		log.info("Input Password: " + password);
		registerPO.inputToDynamicTextbox("Password", password);
		
		log.info("Input Password: " + confirmPassword);
		registerPO.inputToDynamicTextbox("ConfirmPassword", confirmPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 2: Click Register button");
		log.info("Step 2: Click Register button");
		registerPO.clickToDynamicButton("Register");
		
		log.info("Verify register successfully message");
		verifyEquals(registerPO.getTextResultMessage(), "Your registration completed");
		log.info("========End TC_06_Register_with_valid_info========");
		ExtentTestManager.endTest();
	}
	
	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePO = PageGeneratorManager.getHomePage(driver);
		homePO.openUrl(Constants.URL_FRONTEND);
		homePO.clickToDynamicLink("Register");
		registerPO= PageGeneratorManager.getRegisterPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
