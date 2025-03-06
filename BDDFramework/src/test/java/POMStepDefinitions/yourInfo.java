package POMStepDefinitions;

import org.openqa.selenium.WebDriver;
import Objects.checkOutInfoPage;
import Utilities.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;

public class yourInfo {
	private WebDriver driver;
	private checkOutInfoPage checkout;

	public yourInfo() {
		this.driver = hooks.getDriver(); // Get WebDriver from the hooks
	}

	@When("filed Fname, Lname and postal code")
	public void filed_fname_lname_and_postal_code() throws Exception {
		checkout = new checkOutInfoPage(driver);
		checkout.first_name("John");
		checkout.last_name("Wick");
		checkout.postal_code(560017);
	}

	@And("user should get first name is required error message")
	public void user_should_get_first_name_is_required_error_Message() {
		checkout = new checkOutInfoPage(driver);
		checkout.FirstName_error_Message();
	}

	@And("user should get Last name is required error message")
	public void user_should_get_Last_name_is_required_error_Message() throws Exception {
		checkout.first_name("John");
		checkout.FirstName_error_Message();
	}

	@And("user should get Postal code is required error message")
	public void user_should_get_Postal_code_is_required_error_Message() throws Exception {
		checkout.first_name("John");
		checkout.last_name("Wick");
		checkout.FirstName_error_Message();
	}

	@Then("click on continue button")
	public void click_on_continue_button() throws Exception {
		checkout = new checkOutInfoPage(driver);
		checkout.continue_btn();
	}

	@And("click on cancel button")
	public void click_on_cancel_button() {
		checkout.cancel_btn();
	}

}
