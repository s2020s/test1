package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummary {
	@FindBy (xpath = "//a[contains(text(),'Pay Bills')]")
	public WebElement paybills;
	
	@FindBy (xpath = "//a[contains(text(),'Add New Payee')]")
	public WebElement addpayee;

	@FindBy (id = "np_new_payee_name")
	public WebElement addnewpayee;
	
	@FindBy (id = "np_new_payee_address")
	public WebElement payeeAddress;
	
	@FindBy (id = "np_new_payee_account")
	public WebElement payeeAccount;
 
	@FindBy (id = "np_new_payee_details")
	public WebElement payeeDetails;
	
	@FindBy (id = "add_new_payee")
	public WebElement addBtn;
	 
	//@FindBy (id = "alert_content")
	//public WebElement alertContent;
	
	public void addPayee(){
		paybills.click();
		addpayee.click();
		addnewpayee.sendKeys("TD");
		payeeAddress.sendKeys("1 Apartment Mississauga");
		payeeAccount.sendKeys("Chequeing");
		payeeDetails.sendKeys("Chequeing account transfer");
		addBtn.click();
		
		
		
		
		
	}
	
}
