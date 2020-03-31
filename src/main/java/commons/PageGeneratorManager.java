package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.frontend.CheckOutPO;
import pageObjects.frontend.HomePO;
import pageObjects.frontend.LoginPO;
import pageObjects.frontend.MyAccountPO;
import pageObjects.frontend.OrdersInformationPO;
import pageObjects.frontend.ProductDetailsPO;
import pageObjects.frontend.ProductListsPO;
import pageObjects.frontend.ProductReviewsPO;
import pageObjects.frontend.RegisterPO;
import pageObjects.frontend.SearchPO;
import pageObjects.frontend.ShoppingCartPO;

public class PageGeneratorManager {

	//Front End
	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	
	public static MyAccountPO getMyAccountPage(WebDriver driver) {
		return new MyAccountPO(driver);
	}
	
	public static ProductDetailsPO getProductDetailsPage(WebDriver driver) {
		return new ProductDetailsPO(driver);
	}
	
	public static ProductReviewsPO getProductReviewsPage(WebDriver driver) {
		return new ProductReviewsPO(driver);
	}
	
	public static SearchPO getSearchPage(WebDriver driver) {
		return new SearchPO(driver);
	}
	
	public static ProductListsPO getProductListsPage(WebDriver driver) {
		return new ProductListsPO(driver);
	}
	
	public static ShoppingCartPO getShippingCartPage(WebDriver driver) {
		return new ShoppingCartPO(driver);
	}
	
	public static CheckOutPO getCheckOutPage(WebDriver driver) {
		return new CheckOutPO(driver);
	}
	
	public static OrdersInformationPO getOrdersInformationPage(WebDriver driver) {
		return new OrdersInformationPO(driver);
	}
}
