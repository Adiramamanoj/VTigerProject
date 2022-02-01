package purchaseOrderModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.ExcelLibrary;
import pomRepository.PurchaseOrderPage;

/***
 * 
 * @author Adi rama venkata manoj
 *
 */

public class TC_16Test extends BaseClass{
	public String statusApproved= ExcelLibrary.readStringData("sheet1", 2, 0);

	
//	Step:5 Selecting Status As per requirement
	@Test
	public void PurchaseOrderAndStatusAsApproved() {
		
			purchaseOrder= new PurchaseOrderPage(driver);
			purchaseOrder.getCreatePurchaseOrderButton().click();
			WebElement statusListBox = purchaseOrder.getStatusListBoxOption();
			select = new Select(statusListBox);
			select.selectByValue(statusApproved);
		}
		
	}
