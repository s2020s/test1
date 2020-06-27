package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AccountSummary;
import Pages.HomePage;
import Pages.LogIn;
import Pages.payBills;

public class payBillsTC003 {
	
	WebDriver driver;
	 HomePage hp;
	 LogIn ln;
	 //AccountSummary as;
	 payBills pb;
	@BeforeMethod
	public void setUp(){
System.setProperty("webdriver.chrome.driver", "C:\\drivermay2020\\chromedriver.exe");
		
	    driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		hp= PageFactory.initElements(driver, HomePage.class);
		ln= PageFactory.initElements(driver, LogIn.class);
		//as= PageFactory.initElements(driver, AccountSummary.class);
		pb= PageFactory.initElements(driver, payBills.class);
		
	}
	@Test
	public void verifyPaybills() throws InterruptedException{
		hp.singnIn();
		ln.doLogin("username", "password");
		//as.addPayee();
		pb.paybill("1000", "Money deposited in TD");
		
		
		//String ActualTitle = new String();
		String ActualTitle= driver.getTitle();
		String expectedTitle= "Zero - Pay Bills";
		Assert.assertEquals(ActualTitle, expectedTitle);
		
		String actualtext= driver.findElement(By.id("alert_content")).getText();
		String expectedtext= "The payment was successfully submitted.";
		
		Assert.assertEquals(actualtext, expectedtext);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}


}
