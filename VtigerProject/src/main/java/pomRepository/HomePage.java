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
public class HomePage {
	   
	
//	    Constructor
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
//		Properties or Webelements
		@FindBy(xpath =  "//a[text()='More']") private WebElement moremodulelink;
		
		@FindBy(linkText = "Purchase Order") private WebElement purchaseOrdermoduleLink;
		
		
//      Getters Methods
		public WebElement getMoremodulelink() {
			return moremodulelink;
		}


		public WebElement getPurchaseOrdermoduleLink() {
			return purchaseOrdermoduleLink;
		}
		
}