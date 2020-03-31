package pageObjects.frontend;

import org.openqa.selenium.WebDriver;

import commons.CommonsPO;

public class ProductReviewsPO extends CommonsPO {

	WebDriver driver;
	public ProductReviewsPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
}
