package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy (id = "signin_button")
	public WebElement signinbtn;
	public void singnIn(){
		signinbtn.click();
	}
}
	


