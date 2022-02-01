package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * 
 * @author Adi rama venkata manoj
 *
 */


public class PurchaseOrderPage {
	
	
	
//	 Constructor
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	Properties
	
	@FindBy(xpath = "//img[@title='Create Purchase Order...']") private WebElement createPurchaseOrderButton;
	
	@FindBy(name = "postatus") private WebElement statusListBoxOption;
	
	@FindBy(xpath = "(//span[text()=' Administrator']/../..//td[@class='small'])[1]") private WebElement myAccountModuleLink;
	
	@FindBy(linkText = "Sign Out") private WebElement userLogoutButton;

	
//	Getters Method
	public WebElement getCreatePurchaseOrderButton() {
		return createPurchaseOrderButton;
	}

	public WebElement getStatusListBoxOption() {
		return statusListBoxOption;
	}
	
	public WebElement getMyAccountModuleLink() {
		return myAccountModuleLink;
	}


	public WebElement getUserLogoutButton() {
	return userLogoutButton;
	}
	
	
}
