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
public class LoginPage {

	
	//Constructor
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Data members or properties
		@FindBy(name="user_name") 
		private WebElement usernameTextField;
		
		@FindBy(name="user_password") 
		private WebElement passwordTextField;
		
		@FindBy(id="submitButton") 
		private WebElement loginButton;

		//getter methods
		public WebElement getUsernameTextField() {
			return usernameTextField;
		}

		public WebElement getPasswordTextField() {
			return passwordTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
}
