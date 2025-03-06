package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class loginPage extends basePage {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "user-name")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement ErrorMsg;
	@FindBy(id = "login-button")
	WebElement login_btn;

	public void username_txt(String Username) {
		username.sendKeys(Username);
	}

	public void password_txt(String Password) {
		password.sendKeys(Password);
	}

	public void error_Msg() {
		String errormsg = ErrorMsg.getText();
		Assert.assertEquals(errormsg, "Epic sadface: Sorry, this user has been locked out.",
				"Error Message doesnot match!");
		System.out.println("Test Passed : Error Message is as expected ");

	}

	public void login_btn() {
		login_btn.click();
	}

}
