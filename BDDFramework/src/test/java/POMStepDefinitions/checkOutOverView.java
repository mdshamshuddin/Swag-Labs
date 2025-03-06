package POMStepDefinitions;

import org.openqa.selenium.WebDriver;

import Objects.checkOutOverViewPage;
import Objects.homePage;
import Utilities.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class checkOutOverView {
	private WebDriver driver;
	private homePage homepage;
	private checkOutOverViewPage checkOverview;

	public checkOutOverView() {
		this.driver = hooks.getDriver(); // Get WebDriver from the WebDriverManager
	}

	@And("verify checkout item overview")
	public void verify_checkout_item_overview() throws Exception {
		checkOverview = new checkOutOverViewPage(driver);
		checkOverview.verifyOverView();
	}

	@Then("calculate Items total price")
	public void calculate_Items_total_price() {
		checkOverview = new checkOutOverViewPage(driver);
		checkOverview.calculateTotalPrice();
	}

	@And("Verify actual and expected prices are same")
	public void verify_actual_and_expected_prices_are_same() {
		checkOverview = new checkOutOverViewPage(driver);
		checkOverview.verifyPrice();
	}

	@And("Check shipping info message")
	public void Verify_shipping_info_message() {
		checkOverview.shipping_info();
	}

	@And("calculate item total tax equals to total price")
	public void total_price() {
		checkOverview = new checkOutOverViewPage(driver);
		checkOverview.total_Price();
	}

	@And("click on finish button")
	public void finish_btn() {
		checkOverview.finish_button();
	}

	@Then("user is navigated to the Home page")
	public void user_is_navigated_to_the_home_page() {
		homepage.all_Items_displayed();
	}

}
