package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutInfoPage extends basePage {
	WebDriver driver;
	homePage homepage;
	loginPage loginpage;

	public checkOutInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "first-name")
	WebElement firstname;
	@FindBy(id = "last-name")
	WebElement lastname;
	@FindBy(id = "postal-code")
	WebElement postal_code;
	@FindBy(xpath = "//input[@class='btn_primary cart_button']")
	WebElement continue_btn;
	@FindBy(xpath = "//a[@class='cart_cancel_link btn_secondary']")
	WebElement cancel_btn;
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement error_message;

	public void first_name(String fname) throws Exception {
		Thread.sleep(2000);
		firstname.sendKeys(fname);
	}

	public void last_name(String lname) {
		lastname.sendKeys(lname);
	}

	public void postal_code(int number) {
		postal_code.sendKeys(String.valueOf(number));
	}

	public void FirstName_error_Message() {
		if (error_message.isDisplayed()) {
			System.out.println("Error: First Name is required");
		}

	}

	public void LastName_error_Message() {
		if (error_message.isDisplayed()) {
			System.out.println("Error: Last Name is required");

		}
	}

	public void PostalCode_error_Message() {
		if (error_message.isDisplayed()) {
			System.out.println("Error: Postal Code is required");
		}
	}

	public void continue_btn() throws Exception {
		continue_btn.click();
		Thread.sleep(2000);
	}

	public void cancel_btn() {
		cancel_btn.click();
	}

}
