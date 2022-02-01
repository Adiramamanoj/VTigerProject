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


public class TC_17Test extends BaseClass{
	public String statusCreated= ExcelLibrary.readStringData("sheet1", 2, 1);


	@Test
	public void PurchaseOrderAndStatusAsCreated() {
		purchaseOrder= new PurchaseOrderPage(driver);
		purchaseOrder.getCreatePurchaseOrderButton().click();
		WebElement statusListBox = purchaseOrder.getStatusListBoxOption();
		select = new Select(statusListBox);
		select.selectByValue(statusCreated);
	}
}
