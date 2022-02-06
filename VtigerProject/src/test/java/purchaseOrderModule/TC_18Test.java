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

public class TC_18Test extends BaseClass{
	
//	Reading data from execl file
	public String statusDelivered= ExcelLibrary.readStringData("sheet1", 2, 2);
	
//	Step:5 Selecting Status As per requirement "Delivered"
	@Test
	public void PurchaseOrderAndStatusAsDelivered() {
		purchaseOrder= new PurchaseOrderPage(driver);
		purchaseOrder.getCreatePurchaseOrderButton().click();
		WebElement statusListBox = purchaseOrder.getStatusListBoxOption();
		select = new Select(statusListBox);
		select.selectByValue(statusDelivered);
	}
}
