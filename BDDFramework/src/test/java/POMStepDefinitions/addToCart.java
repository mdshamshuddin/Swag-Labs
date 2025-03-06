package POMStepDefinitions;


import org.openqa.selenium.WebDriver;

import Objects.homePage;
import Objects.openCartPage;
import Utilities.hooks;
import io.cucumber.java.en.*;

public class addToCart {
	private WebDriver driver;
	private homePage homepage;
	private openCartPage opencart;
	
	 public addToCart() {
	        this.driver = hooks.getDriver();  // Get WebDriver from the WebDriverManager
	    }

	@Then("go back to home page")
	public void go_back_to_home_page() {
	opencart = new openCartPage(driver);
		opencart.continue_shopping();
	}

	@Then("user remove all the items and check the functionality")
	public void user_remove_all_the_items_and_check_the_functionality() {
//		opencart = new openCartPage(driver);
		opencart.removeCartItems();
	}

	@And("click on remove button")
	public void click_on_remove_button() {
		homepage.remove_from_Cart();
	}

	@And("click on all remove buttons")
	public void click_on_all_remove_button() {
//		opencart = new openCartPage(driver);
		homepage.removeAllItems();
	}

}
