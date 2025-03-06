package POMStepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Objects.checkOutInfoPage;
import Objects.homePage;
import Objects.loginPage;
import Objects.openCartPage;
import Utilities.hooks;
import io.cucumber.java.en.*;

public class POMBackgroundStepDefinition {

	private WebDriver driver;
	private	loginPage loginpage;
	private	homePage homepage;
	private	openCartPage opencart;
	private	checkOutInfoPage checkout;

	
	public POMBackgroundStepDefinition() {
		this.driver = hooks.getDriver();
	}

	@Given("user is at login page")
	public void user_is_at_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user enter valid credentials")
	public void user_enter_valid_credentials() throws Exception {
		loginpage = new loginPage(driver);
		loginpage.username_txt("standard_user");
		loginpage.password_txt("secret_sauce");
		Thread.sleep(2000);
	}

	@And("user click on login button")
	public void user_click_on_Login_button() {
		loginpage = new loginPage(driver);
		loginpage.login_btn();
	}

	@Then("user should be navigated to menu items")
	public void user_should_be_navigated_to_menu_items() throws Exception {
		homepage = new homePage(driver);
		homepage.isAppLogoPresent();
	}

	@And("click on checkout button")
	public void check_out_button() {
		opencart.checkout_btn();
	}

	@Then("user verify selected item is present")
	public void user_verify_selected_item_present() {
		opencart = new openCartPage(driver);
		opencart.verify_selected_item_present();
	}

	@When("user change the sort from name A-Z to Z-A")
	public void user_change_the_sort_from_name_a_z_to_z_a_and_print() throws Exception {
		homepage.selectFromDropDown("za");
		Thread.sleep(2000);
	}

	@Then("user change the sort from Z-A to high to low")
	public void user_change_the_sort_from_z_a_to_high_to_low_and_print() throws Exception {
		homepage.selectFromDropDown("hilo");
		Thread.sleep(2000);
	}

	@When("user change the sort from name A-Z to low_high")
	public void user_change_the_sort_from_name_A_Z_to_low_to_high() throws Exception {
		homepage.selectFromDropDown("lohi");
		Thread.sleep(2000);
	}

	@Then("user should see low to high prices")
	public void user_should_see_low_to_high_prices() {
		homepage.pricesOfAllItem();
	}

	@Then("user click open menu button")
	public void user_click_open_menu_button() throws Exception {
		homepage.openMenu_btn();
	}

	@Then("click on About button")
	public void click_on_About_button() {
		homepage.about_btn();
	}

	@And("verify url")
	public void verify_url() {
		homepage.verifyUrl();
	}

	@Then("user click logout button")
	public void user_click_logout_button() {
		homepage.logout_btn();
	}

	@When("user click on add to cart button")
	public void user_click_on_add_button() throws Exception {
		homepage.add_To_Cart();
	}

	@When("user click on all add to cart buttons")
	public void user_click_on_all_add_to_cart_buttons() {
		homepage.AddAllItems();
	}

	@When("user click on all add to cart buttons and print")
	public void click_on_all_add_to_cart_buttons() {
		homepage.AddAllItems();
		homepage.AllItemNames();
	}

	@Then("verify all item button is present")
	public void verify_all_item_button_is_present() {
		homepage.allitem_btn();
	}

	@Then("click on all item button")
	public void click_on_all_item_button() {
		homepage.allItem_click();
	}

	@Then("check for the items present in all item and print items")
	public void check_for_the_items_present_in_all_item_and_print_items() {
		homepage.allLinks();
	}

	@And("user click on cart shopping button")
	public void user_click_on_cart_shopping_button() {
		homepage.cart_Btn();
	}

	@When("user click on add an item to cart")
	public void user_click_on_add_item() throws Exception {
		homepage = new homePage(driver);
		homepage.add_To_Cart();
	}

	@Then("user should see all items selected")
	public void user_should_see_all_items_selected() {
		opencart = new openCartPage(driver);
		opencart.CartItemsCheck();

	}

	@Then("quit the browser")
	public void close_the_browser() {
		driver.quit();

	}

//	////////////////////////////////
////	@Then("go back to home page")
////	public void go_back_to_home_page() {
////
////		opencart = new openCartPage(driver);
////		opencart.continue_shopping();
////	}
////
////	@Then("user remove all the items and check the functionality")
////	public void user_remove_all_the_items_and_check_the_functionality() {
////		opencart = new openCartPage(driver);
////		opencart.removeCartItems();
////	}
////
////	@And("click on remove button")
////	public void click_on_remove_button() {
////		opencart = new openCartPage(driver);
////		homepage.remove_from_Cart();
////	}
////
////	@And("click on all remove buttons")
////	public void click_on_all_remove_button() {
////		opencart = new openCartPage(driver);
////		homepage.removeAllItems();
////	}
//
//	////////////////////////////////
//
//	@When("filed Fname, Lname and postal code")
//	public void filed_fname_lname_and_postal_code() throws Exception {
//		checkout = new checkOutInfoPage(driver);
//		checkout.first_name("John");
//		checkout.last_name("Wick");
//		checkout.postal_code(560017);
//	}
//
////	@And("user should get first name is required error message")
////	public void user_should_get_first_name_is_required_error_Message() {
////		checkout.FirstName_error_Message();
////	}
////
////	@And("user should get Last name is required error message")
////	public void user_should_get_Last_name_is_required_error_Message() throws Exception {
////		checkout.first_name("John");
////		checkout.FirstName_error_Message();
////	}
////
////	@And("user should get Postal code is required error message")
////	public void user_should_get_Postal_code_is_required_error_Message() throws Exception {
////		checkout.first_name("John");
////		checkout.last_name("Wick");
////		checkout.FirstName_error_Message();
////	}
////
////	@Then("click on continue button")
////	public void click_on_continue_button() throws Exception {
////		checkout = new checkOutInfoPage(driver);
////		checkout.continue_btn();
////	}
////
////	@And("click on cancel button")
////	public void click_on_cancel_button() {
////		checkout.cancel_btn();
////	}
////
////	///////////////////////////////////////
////	@And("verify checkout item overview")
////	public void verify_checkout_item_overview() throws Exception {
////		checkOverview = new checkOutOverViewPage(driver);
////		checkOverview.verifyOverView();
////	}
////
////	@Then("calculate Items total price")
////	public void calculate_Items_total_price() {
////		checkOverview = new checkOutOverViewPage(driver);
////		checkOverview.calculateTotalPrice();
////	}
////
////	@And("Verify actual and expected prices are same")
////	public void verify_actual_and_expected_prices_are_same() {
////		checkOverview = new checkOutOverViewPage(driver);
////		checkOverview.verifyPrice();
////	}
////
////	@And("Check shipping info message")
////	public void Verify_shipping_info_message() {
////		checkOverview.shipping_info();
////	}
////
////	@And("calculate item total tax equals to total price")
////	public void total_price() {
////		checkOverview = new checkOutOverViewPage(driver);
////		checkOverview.total_Price();
////	}
////
////	@And("click on finish button")
////	public void finish_btn() {
////		checkOverview.finish_button();
////	}
////
////	@Then("user is navigated to the Home page")
////	public void user_is_navigated_to_the_home_page() {
////		homepage.all_Items_displayed();
////	}

}
