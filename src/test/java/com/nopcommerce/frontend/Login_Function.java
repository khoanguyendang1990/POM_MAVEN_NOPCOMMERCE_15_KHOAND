package com.nopcommerce.frontend;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.frontend.HomePO;
import pageObjects.frontend.LoginPO;
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Login_Function extends BaseTest {

	WebDriver driver;
	private HomePO homePO;
	private LoginPO loginPO;
	private String email = Constants.EMAIL_USERNAME;
	private String invalidEmail = "khoa.nguyen";
	private String notRegistedEmail = "khoa.nguyen" + randomNumber() + "@gmail.com";

	private String password = Constants.PASSWORD;

	@Test
	public void TC_01_Login_with_empty_data() {
		ExtentTestManager.startTest("TC_01_Register_with_empty_data", "Login with empty data");
		log.info("========Start TC_01_Register_with_empty_data========");

		log.info("VP. Login Page is opened");
		verifyEquals(loginPO.getTextPageHeaderTitle(), "Welcome, Please Sign In!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Click Login button with empty data");
		log.info("Step 1: Click Login button with empty data");
		loginPO.clickToDynamicButton("Log in");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at Email fields");
		log.info("VP. Error message show Please enter your email");
		verifyEquals(loginPO.getTextDynamicErrorMessage("Email-error"), "Please enter your email");

		log.info("========End TC_01_Register_with_empty_data========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Login_with_invalid_email() {
		ExtentTestManager.startTest("TC_02_Login_with_invalid_email", "Login with invalid email");
		log.info("========Start TC_02_Login_with_invalid_email========");

		log.info("VP. Login Page is opened");
		verifyEquals(loginPO.getTextPageHeaderTitle(), "Welcome, Please Sign In!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input invalid email then click Login");
		log.info("Step 1: Input invalid email then click Login");
		loginPO.inputToDynamicTextbox("Email", invalidEmail);
		loginPO.clickToDynamicButton("Log in");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at Email fields");
		log.info("VP. Error message show Wrong email");
		verifyEquals(loginPO.getTextDynamicErrorMessage("Email-error"), "Wrong email");

		log.info("========End TC_02_Login_with_invalid_email========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_03_Login_with_email_not_registered() {
		ExtentTestManager.startTest("TC_03_Login_with_email_not_registered", "Login with email is not registered yet");
		log.info("========Start TC_03_Login_with_email_not_registered========");

		log.info("VP. Login Page is opened");
		verifyEquals(loginPO.getTextPageHeaderTitle(), "Welcome, Please Sign In!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input invalid email then click Login");
		log.info("Step 1: Input invalid email then click Login");
		loginPO.inputToDynamicTextbox("Email", notRegistedEmail);
		loginPO.clickToDynamicButton("Log in");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at Email fields");
		log.info("VP. Error message show Login was unsuccessful. Please correct the errors and try again. No customer account found");
		verifyEquals(loginPO.getTextValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");

		log.info("========End TC_03_Login_with_email_not_registered========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_04_Login_with_valid_email_and_password_blank() {
		ExtentTestManager.startTest("TC_04_Login_with_valid_email_and_password_blank", "Login with valid email and leave password blank");
		log.info("========Start TC_04_Login_with_valid_email_and_password_blank========");

		log.info("VP. Login Page is opened");
		verifyEquals(loginPO.getTextPageHeaderTitle(), "Welcome, Please Sign In!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input invalid email then click Login");
		log.info("Step 1: Input invalid email then click Login");
		loginPO.inputToDynamicTextbox("Email", email);
		loginPO.clickToDynamicButton("Log in");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at Email fields");
		log.info("VP. Show Error message: Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect");
		verifyEquals(loginPO.getTextValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

		log.info("========End TC_04_Login_with_valid_email_and_password_blank========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_05_Login_with_valid_email_and_wrong_password() {
		ExtentTestManager.startTest("TC_05_Login_with_valid_email_and_wrong_password", "Login with valid email and wrong password");
		log.info("========Start TC_05_Login_with_valid_email_and_wrong_password========");

		log.info("VP. Login Page is opened");
		verifyEquals(loginPO.getTextPageHeaderTitle(), "Welcome, Please Sign In!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input invalid email then click Login");
		log.info("Step 1: Input invalid email then click Login");
		loginPO.inputToDynamicTextbox("Email", email);
		loginPO.inputToDynamicTextbox("Password", "1234aa");
		loginPO.clickToDynamicButton("Log in");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at Email fields");
		log.info("VP. Show Error message: Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect");
		verifyEquals(loginPO.getTextValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

		log.info("========End TC_05_Login_with_valid_email_and_wrong_password========");
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_06_Login_with_valid_email_and_password() {
		ExtentTestManager.startTest("TC_06_Login_with_valid_email_and_password", "Login with valid email and password");
		log.info("========Start TC_06_Login_with_valid_email_and_password========");

		log.info("VP. Login Page is opened");
		verifyEquals(loginPO.getTextPageHeaderTitle(), "Welcome, Please Sign In!");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 1: Input valid email and password then click Login");
		log.info("Step 1: Input valid email and password then click Login");
		loginPO.inputToDynamicTextbox("Email", email);
		loginPO.inputToDynamicTextbox("Password", password);
		loginPO.clickToDynamicButton("Log in");

		ExtentTestManager.getTest().log(LogStatus.INFO, "Verify error message appear at Email fields");
		log.info("VP. Login successfully");
		homePO = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePO.isLinkDisplayed("My account"));
		verifyTrue(homePO.isLinkDisplayed("Log out"));
		
		log.info("========End TC_06_Login_with_valid_email_and_password========");
		ExtentTestManager.endTest();
	}

	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePO = PageGeneratorManager.getHomePage(driver);
		log.info("Pre-condition: Open Log in Page");
		homePO.openUrl(Constants.URL_FRONTEND);
		homePO.clickToDynamicLink("Log in");
		loginPO = PageGeneratorManager.getLoginPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
