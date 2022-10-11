package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddToCart;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import pageObjects.Submit;

public class Steps_PageObject {

	WebDriver driver;
	
	// Instantiate objects of all the Page object class
	HomePage home;
	ProductListingPage prodPage;
	AddToCart addCart;
	CheckoutPage checkOut;
	Submit submit;
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shbassi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://shop.demoqa.com/");
	   
	}
	@When("^User searches for \"([^\"]*)\"$")
	public void user_searches_for(String product) throws Throwable {
	
		home = new HomePage(driver);
		home.perform_Search(product);
		}

	@When("^chooses to buy first item$")
	public void chooses_to_buy_first_item() throws Throwable {
		prodPage = new ProductListingPage(driver);
		prodPage.select_Product();
		prodPage.select_ColorSize();
	    
	}
	@When("^moves to the checkout from mini cart$")
	public void moves_to_the_checkout_from_mini_cart() throws Throwable {
		addCart = new AddToCart(driver);
		addCart.addToCartAndCheckout();
	   	}
	@When("^enter \"([^\"]*)\",\"([^\"]*)\"as personal details on checkout page$")
	public void enter_firstName_and_lastName_as_personal_details_on_checkout_page(String fName, String lName) throws Throwable {
		checkOut = new CheckoutPage(driver);
		
		checkOut.fill_PersonalDetails(fName, lName);
		
	   	}
	@When("^select \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"  as delivery address$")
	public void select_country_billingAddress_and_city_as_delivery_address(String countryName, String billingAdd,String cityName, String postalCode, String PhoneNumber, String emailAdd ) throws Throwable {
		
		checkOut.slect_Country(countryName);
		checkOut.enter_Address(billingAdd, cityName, postalCode, PhoneNumber, emailAdd);
	}
	@When("^place the order$")
	public void place_the_order() throws Throwable {
		submit = new Submit(driver);
		submit.acceptTCAndPlaceOrder();
	}
	
	@Then("^quits the application$")
	public void quits_the_application() throws Throwable {
		driver.quit();	}
}
