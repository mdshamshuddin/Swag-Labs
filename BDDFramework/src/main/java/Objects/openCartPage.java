package Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openCartPage extends basePage {
	WebDriver driver;
	homePage homepage;
	loginPage loginpage;

	public openCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> CartItemNames;
	@FindBy(xpath = "(//button[@class='btn_secondary cart_button'])")
	List<WebElement> removeAllcartItems;
	@FindBy(xpath = "//a[@class='btn_secondary']")
	WebElement continue_shopping;
	@FindBy(xpath = "//button[@class='btn_secondary cart_button']")
	WebElement removeitem;
	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	WebElement checkout_btn;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> elementsAdded;
	
	public void CartItemsCheck() {
		if (CartItemNames.equals(removeAllcartItems)) {
			System.out.println("Selected items are same :  ");
		}
	}

	public void removeCartItems() {
		for (WebElement remove : removeAllcartItems) {
			remove.click();
		}
	}

	public void continue_shopping() {
		continue_shopping.click();
	}

	public boolean verify_selected_item_present() {
		if (elementsAdded.size() >= 0) {
			System.out.println("size of element is : " + elementsAdded.size());
		}
		return true;
	}

	public void checkout_btn() {
		checkout_btn.click();
	}

	
}
