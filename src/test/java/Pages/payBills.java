package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class payBills {
	@FindBy (xpath = "//a[contains(text(),'Pay Bills')]")
	public WebElement paybills;
	
	@FindBy (id = "sp_payee")
	public WebElement payee;
	
	@FindBy (id = "sp_account")
	public WebElement account;
	
	@FindBy (id = "sp_amount")
	public WebElement amount;
	
	@FindBy (id = "sp_date")
	public WebElement date;
	
	@FindBy (xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/span[1]")
	public WebElement mn;
	
	@FindBy (xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e'][contains(text(), 'Next')]")
	public WebElement nxtbtn;
	
	@FindBy (xpath = "//div[3]//table[1]//tbody[1]//tr//td//a[contains(text(),'31')]")
	public WebElement choosemonth;
	
	@FindBy (id = "sp_description")
	public WebElement description;
	
	@FindBy (id = "pay_saved_payees")
	public WebElement payButton;
	
	public void paybill(String amount1, String description1) throws InterruptedException{
		paybills.click();
		Select payee1= new Select(payee);
		payee1.selectByIndex(2);
		
		Select account1= new Select(account);
		account1.selectByValue("1");
		amount.sendKeys(amount1);
	
		String month= "December";
		String year= "2020";
		String date1= "31";
		date.click();
		while(true){
			
			Thread.sleep(1000);
			String mon= mn.getText();

			if(mon.equals(month)){	
			break;
			
		}
			else {
				Thread.sleep(1000);
			nxtbtn.click();
			Thread.sleep(1000);
		}
			
			
		}
		
		
		choosemonth.click();
		
		
		description.sendKeys(description1);
		payButton.click();
		
		
		
	}
	
	

}
