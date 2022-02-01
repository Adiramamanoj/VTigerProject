package genericLibrary;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.PurchaseOrderPage;

/***
 * 
 * @author Adi rama venkata manoj
 *
 */

public class BaseClass {
	
	public ExcelLibrary excelLib= new ExcelLibrary();

	
	
//	Step1: Test Data From ExcelLibrary
	String testURL = ExcelLibrary.readStringData("sheet1", 1, 0);
	String userName=ExcelLibrary.readStringData("sheet1",1,1);
	String userPassword= ExcelLibrary.readStringData("sheet1", 1, 2);
	String homePageTitle= ExcelLibrary.readStringData("sheet1", 1, 3);
	String purchaseOrderTitle= ExcelLibrary.readStringData("sheet1", 1, 4);
	String loginPageTitle= ExcelLibrary.readStringData("sheet1", 1, 5);	
	
	

	public WebDriver driver;
	public WebDriverWait explicit;
	public Actions actions;
	public HomePage homepage;
	public Select select;
	public LoginPage loginpage;
	public PurchaseOrderPage purchaseOrder;

	
//	Step:2 launching The Chrome Browser 
	@BeforeTest
	public void launchingBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver= new ChromeDriver();
		Reporter.log("Browser is Launched Successfully", true);
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicit= new WebDriverWait(driver, 10);
	}


//	Step:3 Login Into Application 
	@BeforeClass
	public void loginToVtiger() {
		driver.get(testURL);
		loginpage= new LoginPage(driver);
		loginpage.getUsernameTextField().sendKeys(userName);
		loginpage.getPasswordTextField().sendKeys(userPassword);
		loginpage.getLoginButton().click();
		
		String expectedHomePageTitle=homePageTitle;
		String actualHomePageTitle = driver.getTitle();
		if(expectedHomePageTitle.equalsIgnoreCase(actualHomePageTitle)) {
			Reporter.log("Login is successfully to application",true);
		}
		else {
			Reporter.log("Login has Failed",true);
		}

	}


//	Step:4 Creating Purchase Order 
	@BeforeMethod
	public void HomePageVtiger() {
		 homepage= new HomePage(driver);
		WebElement moreModuleLink = homepage.getMoremodulelink();
		actions= new Actions(driver);
		Actions moreModuleoption = actions.moveToElement(moreModuleLink);
		moreModuleoption.click().perform();
		WebElement purchaseModuleOption = homepage.getPurchaseOrdermoduleLink();
		moreModuleoption.moveToElement(purchaseModuleOption).click().perform();
		
		String expectedPurchaseOrderPageTitle=purchaseOrderTitle;
		String actualPurchaseOrderPageTitle= driver.getTitle();
		if(actualPurchaseOrderPageTitle.equalsIgnoreCase(expectedPurchaseOrderPageTitle)) {
			Reporter.log("Purchase Order Page is displayed successfully", true);
		}else {
			Reporter.log("Purchase Order page is not displayed properly ", true);
		}
	}
	
//	Step:6 Logout From The Application
	@AfterMethod
	public void LogoutFromVtiger() {
		WebElement myAccountModule = purchaseOrder.getMyAccountModuleLink();
		actions= new Actions(driver);
		Actions adminsterButton = actions.moveToElement(myAccountModule);
		adminsterButton.click().perform();
		purchaseOrder.getUserLogoutButton().click();
		
		String expectedLoginPageTitle=loginPageTitle;
		String actualLoginPageTitle= driver.getTitle();
		if(actualLoginPageTitle.equalsIgnoreCase(expectedLoginPageTitle)) {
			Reporter.log("Successfully Logged out from application", true);
		}else {
			Reporter.log("logOut has been Failed", true);
		}
	}
	
	
//	Step:7 Closing The Chrome Browser
	@AfterClass
	public void ClosingBrowser() {
		driver.quit();
		Reporter.log("Successfully Closed The browser", true);
	}
	
	
	
	
	
	
	
	
}
