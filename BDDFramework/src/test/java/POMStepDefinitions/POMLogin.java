package POMStepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import Objects.homePage;
import Objects.loginPage;
import Utilities.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class POMLogin {
	private WebDriver driver;
	private loginPage loginpage;
	private homePage homepage;

	public POMLogin() {
		this.driver = hooks.getDriver(); // Get WebDriver from the hooks
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws Exception {
		loginpage = new loginPage(driver);
		loginpage.username_txt("standard_user");
		loginpage.password_txt("secret_sauce");
		Thread.sleep(2000);
	}

	@When("user enters invalid username and password")
	public void user_enters_Invalid_username_and_password() throws Exception {
		loginpage.username_txt("locked_out_user");
		loginpage.password_txt("secret_sauce");
		Thread.sleep(2000);
	}

	@When("user enters valid {string} and {string}")
	public void user_enters_valid_username_and_Password(String username, String password) throws Exception {
		loginpage = new loginPage(driver);
		loginpage.username_txt(username);
		loginpage.password_txt(password);
		Thread.sleep(2000);
	}

	@When("click on open Menu button")
	public void click_on_open_menu_button() throws Exception {
		homepage = new homePage(driver);
		homepage.openMenu_btn();
	}

	@Then("click on logout button")
	public void click_on_logout_button() {
		homepage.logout_btn();
	}

	@Then("click on login button")
	public void click_on_login_button() {
		homepage = new homePage(driver);
		loginpage.login_btn();
	}

	@Then("user is navigated to Home page")
	public void user_navigated_to_home_page() throws Exception {
		homepage.isAppLogoPresent();
	}

	@Then("user found error message")
	public void user_found_error_message() {
		loginpage.error_Msg();
	}

	@And("close the browser")
	public void close_browser() {
		driver.quit();
	}

}
