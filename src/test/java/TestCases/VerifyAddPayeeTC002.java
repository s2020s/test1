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

public class VerifyAddPayeeTC002 {
	WebDriver driver;
	 HomePage hp;
	 LogIn ln;
	 AccountSummary as;
	@BeforeMethod
	public void setUp(){
System.setProperty("webdriver.chrome.driver", "C:\\drivermay2020\\chromedriver.exe");
		
	    driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		hp= PageFactory.initElements(driver, HomePage.class);
		ln= PageFactory.initElements(driver, LogIn.class);
		as= PageFactory.initElements(driver, AccountSummary.class);
		
	}
	@Test
	public void verifyLogin(){
		hp.singnIn();
		ln.doLogin("username", "password");
		as.addPayee();
		
		
		//String ActualTitle = new String();
		String ActualTitle= driver.getTitle();
		String expectedTitle= "Zero - Pay Bills";
		Assert.assertEquals(ActualTitle, expectedTitle);
		
		String Actualtext= driver.findElement(By.id("alert_content")).getText();
		String expectedtext= "The new payee TD was successfully created.";
		
		Assert.assertEquals(Actualtext, expectedtext);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

}



