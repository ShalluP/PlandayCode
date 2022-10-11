package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {
	WebDriver driver;
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shbassi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://shop.demoqa.com/");
	   
	}

	@When("^User searches for \"([^\"]*)\"$")
	public void user_searches_for(String arg1) throws Throwable {
		driver.navigate().to("https://shop.demoqa.com/?s=" + arg1 + "&post_type=product"); 
	 //   throw new PendingException();
	}

	/*
	 * @When("^User searches for dress$") public void user_searches_for_dress()
	 * throws Throwable { driver.findElement(By.
	 * xpath("//div[@class='navbar navbar-default']//*[@class='icon_search']")).
	 * click(); //driver.navigate().to("https://shop.demoqa.com/?s=" + "dress" +
	 * "&post_type=product"); throw new PendingException(); }
	 */
	  
	  
	  @When("^chooses to buy first item$")
	  public void chooses_to_buy_first_item()
	  throws Throwable 
	  { List<WebElement> items =
	  driver.findElements(By.cssSelector(".noo-product-inner"));
	  items.get(0).click();
	  
	  WebElement selColorDropDown=
	  driver.findElement(By.xpath("(//select[@id='pa_color'])[1]"));
	  selColorDropDown.click();
	  
	  Thread.sleep(1000); WebElement selWhiteColor = driver.findElement(By.xpath(
	  "(//select[@id='pa_color'])[1]//*[text()='White']")); 
	  selWhiteColor.click();
	  
	  WebElement selSizeDropDown =
	  driver.findElement(By.xpath("(//select[@id='pa_size'])[1]"));
	  selSizeDropDown.click(); Thread.sleep(1000);
	  
	  
	  WebElement selSmallSize=
	  driver.findElement(By.xpath("(//select[@id='pa_size'])[1]//*[text()='Small']"
	  )); selSmallSize.click();
	  
	  WebElement addToCart =
	  driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
	  addToCart.click();
	  
	  
	  WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
	  cart.click();
	  
	 }
	  
	  @When("^moves to the checkout from mini cart$") public void
	  moves_to_the_checkout_from_mini_cart() throws Throwable { WebElement
	  continueToCheckout =
	  driver.findElement(By.cssSelector(".checkout-button.alt"));
	  continueToCheckout.click();
	  Thread.sleep(5000);
	  
	  }
	  
		/*
		 * @When("enter \"([^\"]*)\" and \"([^\"]*)\" as personal details on checkout page"
		 * ) public void enter_and_as_personal_details_on_checkout_page(String fName,
		 * String lName) throws Throwable { WebElement firstName =
		 * driver.findElement(By.cssSelector("#billing_first_name"));
		 * firstName.sendKeys(fName);
		 * 
		 * WebElement lastName =
		 * driver.findElement(By.cssSelector("#billing_last_name"));
		 * lastName.sendKeys(lName);
		 * 
		 * throw new PendingException(); }
		 * 
		 * @When("select \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" as delivery address"
		 * ) public void select_and_as_delivery_address(String country, String
		 * billingAddress, String city) throws Throwable { WebElement countryDropDown =
		 * driver.findElement(By.xpath("(//*[@class='select2-selection__arrow'])[1]"));
		 * countryDropDown.click(); Thread.sleep(2000);
		 * 
		 * //ul[@id='select2-billing_country-results']
		 * 
		 * List<WebElement> countryList =
		 * driver.findElements(By.cssSelector("#select2-billing_country-container"));
		 * 
		 * int size = countryList.size(); System.out.println(size);
		 * 
		 * 
		 * for(WebElement selCountry : countryList)
		 * 
		 * { if(selCountry.getText().equals("country"))
		 * 
		 * { Thread.sleep(1000); selCountry.click(); Thread.sleep(2000); break; } }
		 * 
		 * 
		 * WebElement address =
		 * driver.findElement(By.xpath("//*[@id='billing_address_1']"));
		 * address.sendKeys(billingAddress);
		 * 
		 * WebElement selCity = driver.findElement(By.xpath("//*[@id='billing_city']"));
		 * selCity.sendKeys(city);
		 * 
		 * 
		 * WebElement postcode =
		 * driver.findElement(By.cssSelector("#billing_postcode"));
		 * postcode.sendKeys("110088"); WebElement phone =
		 * driver.findElement(By.cssSelector("#billing_phone"));
		 * phone.sendKeys("07438862327");
		 * 
		 * 
		 * WebElement emailAddress =
		 * driver.findElement(By.cssSelector("#billing_email"));
		 * emailAddress.sendKeys("test@gmail.com");
		 * 
		 * 
		 * 
		 * throw new PendingException(); }
		 * 
		 * @When("place the order") public void place_the_order() throws Throwable {
		 * WebElement acceptTC = driver.findElement(By.xpath("//*[@id='terms']"));
		 * acceptTC.click();
		 * 
		 * WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		 * placeOrder.submit(); throw new PendingException(); }
		 * 
		 * @Then("^quits the application$") public void quits_the_application() throws
		 * Throwable { driver.quit(); throw new PendingException(); }
		 */
	  @When("^enter firstName and lastName as personal details on checkout page$")
	  public void enter_firstName_and_lastName_as_personal_details_on_checkout_page() throws Throwable {
		  WebElement firstName =
				  driver.findElement(By.cssSelector("#billing_first_name"));
				  firstName.sendKeys("Lakshay");
				  
				  WebElement lastName =
						  driver.findElement(By.cssSelector("#billing_last_name"));
						  lastName.sendKeys("Sharma");
						  
							
							  
	     
	  }

	  @When("^select country, billingAddress and city as delivery address$")
	  public void select_country_billingAddress_and_city_as_delivery_address() throws Throwable {
		  WebElement countryDropDown =
				  driver.findElement(By.xpath("(//*[@class='select2-selection__arrow'])[1]"));
				  countryDropDown.click(); Thread.sleep(2000);
				  
				  //ul[@id='select2-billing_country-results']
				  
				  List<WebElement> countryList =
				  driver.findElements(By.cssSelector("#select2-billing_country-container"));
				  
				  int size = countryList.size();
				  System.out.println(size);
				  
				//ul[@id='select2-billing_country-results']#select2-billing_country-results
				  
				  for(WebElement country : countryList) 
				
				  { if(country.getText().equals("India"))
				  
					  { Thread.sleep(1000); 
					  country.click(); 
					  Thread.sleep(2000);
					  break; 
					  } 
				  }
				 
					
					  WebElement address =
					  driver.findElement(By.xpath("//*[@id='billing_address_1']"));
					  address.sendKeys("Shalimar Bagh");
					  
					  WebElement city = driver.findElement(By.xpath("//*[@id='billing_city']"));
					  city.sendKeys("Delhi");
					  
					  
					  WebElement postcode =
					  driver.findElement(By.cssSelector("#billing_postcode"));
					  postcode.sendKeys("110088"); WebElement phone =
					  driver.findElement(By.cssSelector("#billing_phone"));
					  phone.sendKeys("07438862327");
					  
					  
					  WebElement emailAddress =
					  driver.findElement(By.cssSelector("#billing_email"));
					  emailAddress.sendKeys("test@gmail.com");
					  
	     
	  }

	  @When("^place the order$")
	  public void place_the_order() throws Throwable {
		  JavascriptExecutor j = (JavascriptExecutor)driver;
		  j.executeScript("window.scrollBy(0,-500)");
		  
		  Thread.sleep(2000);
  WebElement acceptTC =
  driver.findElement(By.xpath("//*[@id='terms']"));
  acceptTC.click();
  
  WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
  placeOrder.submit();
	      
	  }

	  @Then("^quits the application$")
	  public void quits_the_application() throws Throwable {
		  driver.quit();
	      
	  }

	 

}
