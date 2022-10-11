package Planday;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlandayExeceuteCode {
	
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C://Users//shbassi//eclipse-workspace//CodeTest//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://test1234.planday.com/");
		
		try {
			driver.findElement(By.id("cookie-consent-button")).isDisplayed();
			driver.findElement(By.id("cookie-consent-button")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		driver.findElement(By.id("Username")).isDisplayed();
		Assert.assertTrue(driver.findElement(By.id("Username")).isDisplayed(), "FAIL : the Username Field is not displayed");
		
		Assert.assertTrue(driver.findElement(By.id("Password")).isDisplayed(), "FAIL : the Password Field is not displayed");
		Assert.assertTrue(driver.findElement(By.id("MainLoginButton")).isDisplayed(), "FAIL : the LoginButton is not displayed");
		
		
		
		  driver.findElement(By.id("Username")).sendKeys("shallu@gmail.com");
		  driver.findElement(By.id("Password")).sendKeys("1234");
		  driver.findElement(By.id("MainLoginButton")).click();
		  
		  Assert.assertTrue(driver.findElement(By.xpath(
		  "//div//*[@id='Username-validation-error']")).isDisplayed(),"FAIL : the Error message is not displayed");
		  String errorMsg = driver.findElement(By.id("Password-validation-error")).getText();
		  System.out.println("the error message is :"+errorMsg );
		 
		  Thread.sleep(2000); 
		  driver.findElement(By.id("Username")).clear();
		  driver.findElement(By.id("Username")).sendKeys("plandayqa@outlook.com");
		  driver.findElement(By.id("Password")).sendKeys("APItesting21");
		  driver.findElement(By.id("MainLoginButton")).click();
		  
		  // Home Page
		  driver.findElement(By.xpath("(//*[@title='Schedule'])[1]")).isDisplayed();
		  driver.findElement(By.xpath("(//*[@title='Schedule'])[1]")).click();
		  
		  String urlSchedule = driver.getCurrentUrl();
		  System.out.println("The current title after schedule is : "+ urlSchedule);
		  
		  Assert.assertEquals(urlSchedule, "https://test1234.planday.com/schedule");
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		 
		  WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Page content']"));
		  WebDriverWait wait = new WebDriverWait(driver, 40);
		  wait.until(ExpectedConditions.elementToBeClickable(iframe)); // instead of id you can use cssSelector or xpath of your element.
		 
		  // Switch to iframe
		
		  driver.switchTo().frame(iframe);
		  
		  
		  List<WebElement> empList = driver.findElements(
				  By.xpath("//*[@class='virtualized-board__row']//following::*[@class='row-header3__text__title' and contains(text(),'Employee')]"));
		
		  int size= empList.size();
		  System.out.println("the count of employees is :"+ size);
		 
		//Set date
		 DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy ");
		 Date date = new Date();
		 String dateSet= dateFormat.format(date);
		 System.out.println("Todays' date is :"+ dateSet);
		 WebElement gridCellToday = driver.findElement(By.xpath("//*[@class='board-slot board-slot--clickable' and @aria-label='"+dateSet+"Employee One']"));
		 gridCellToday.click();
		 WebElement fromSchedule = driver.findElement(By.name("shiftStartEnd_start"));
		 fromSchedule.sendKeys("9:00");
		 WebElement toSchedule = driver.findElement(By.name("shiftStartEnd_end"));
		 toSchedule.sendKeys("17:00");
		 driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		 System.out.println("the content of cell after selection is : "+gridCellToday.getText());
			
			driver.close();
			driver.quit();
	}

}
