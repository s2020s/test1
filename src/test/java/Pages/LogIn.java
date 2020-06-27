package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn {
	@FindBy (id = "user_login")
	public WebElement txtlogin;
	
	@FindBy (id = "user_password")
	public WebElement txtpassword;
	
	@FindBy (name = "submit")
	public WebElement btnSignIn;
	/*	@FindBy (xpath = "//a[contains(text(),'Add New Payee')]")
	public WebElement addp;  */
	
	public void doLogin(String myusername, String mypassword) {
		txtlogin.sendKeys(myusername);
		txtpassword.sendKeys(mypassword);
		btnSignIn.click();

}}
