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

public class TC_19Test extends BaseClass{
	
//	Reading data from execl file
	public String statusCancelled= ExcelLibrary.readStringData("sheet1", 2, 3);
	
//	Step:5 Selecting Status As per requirement "Cancelled"
	@Test
	public void PurchaseOrderAndStatusAsCancelled() {
		purchaseOrder= new PurchaseOrderPage(driver);
		purchaseOrder.getCreatePurchaseOrderButton().click();
		WebElement statusListBox = purchaseOrder.getStatusListBoxOption();
		select = new Select(statusListBox);
		select.selectByValue(statusCancelled);
	}
}
