package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LogIn;

public class LogInTC001 {
	 WebDriver driver;
	 HomePage hp;
	 LogIn ln;
	@BeforeMethod
	public void setUp(){
System.setProperty("webdriver.chrome.driver", "C:\\drivermay2020\\chromedriver.exe");
		
	    driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		hp= PageFactory.initElements(driver, HomePage.class);
		ln= PageFactory.initElements(driver, LogIn.class);
		
	}
	@Test
	public void verifyLogin(){
		hp.singnIn();
		ln.doLogin("username", "password");
		
		
		//String ActualTitle = new String();
		String ActualTitle= driver.getTitle();
		String expectedTitle= "Zero - Account Summary";
		Assert.assertEquals(ActualTitle, expectedTitle);
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

}
