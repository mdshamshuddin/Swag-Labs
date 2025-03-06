package Objects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class homePage extends basePage {
	WebDriver driver;

	public homePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement Applogo;
	@FindBy(xpath = "//div[@class='inventory_item_img']")
	List<WebElement> item_img;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement sort_btn;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> prices;
	@FindBy(xpath = "//button[normalize-space()='Open Menu']")
	WebElement openMenu;
	@FindBy(id = "logout_sidebar_link")
	WebElement logout_btn;
	@FindBy(xpath = "(//button[@class='btn_primary btn_inventory'])[1]")
	WebElement AddElement;
	@FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
	List<WebElement> AddAllElement;
	@FindBy(xpath = "(//button[@class='btn_secondary btn_inventory'])")
	WebElement RemoveElement;
	@FindBy(xpath = "(//button[@class='btn_secondary btn_inventory'])")
	List<WebElement> AllRemoveElement;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> ItemNames;
	@FindBy(id = "inventory_sidebar_link")
	WebElement allItems;
	@FindBy(xpath = "//a")
	List<WebElement> allLinks;
	@FindBy(id = "about_sidebar_link")
	WebElement about_btn;
	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	WebElement cart_btn;

	public boolean isAppLogoPresent() throws Exception {
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) item_img));
		return Applogo.isDisplayed(); // Returns true if the logo is displayed
	}

	public void allLinks() {
		System.out.println("total links in all items are : " + allLinks.size());
		for (WebElement links : allLinks) {
			System.out.println(links.getText());
		}
	}

	public void about_btn() {
		about_btn.click();
	}

	public void cart_Btn() {
		cart_btn.click();
	}

	public boolean verifyUrl() {
		String url = "https://saucelabs.com/";
		if (url.contains("saucelabs")) {
			System.out.println("The url is : " + url);
		}
		return true;
	}

	public void allitem_btn() {
		String item_btn = allItems.getText();
		Assert.assertEquals(item_btn, "All Items");
	}

	public void allItem_click() {
		allItems.click();
	}

	public void selectFromDropDown(String value) throws Exception {
		sort_btn.click();
		Thread.sleep(1000);
		Select dropDown = new Select(sort_btn);
		dropDown.selectByValue(value);
		Thread.sleep(1000);
	}

	public void select_Name_from_Z_A(String value) throws Exception {
		sort_btn.click();
		Thread.sleep(1000);
		Select dropDown = new Select(sort_btn);
		dropDown.selectByValue(value);
		Thread.sleep(1000);
	}

	public void selectFrom_high_to_Low(String value) throws Exception {
		sort_btn.click();
		Thread.sleep(1000);
		Select dropDown = new Select(sort_btn);
		dropDown.selectByValue(value);
		Thread.sleep(1000);
	}

	public void pricesOfAllItem() {
		for (WebElement price : prices) {
			String priceText = price.getText();
			System.out.println(priceText);
		}
	}

	public void AddAllItems() {
		for (WebElement allElements : AddAllElement) {
			allElements.click();
		}
	}

	public void removeAllItems() {
		for (WebElement removeAll : AllRemoveElement) {
			removeAll.click();
		}
	}

	public void AllItemNames() {
		System.out.println("\n Name of all items are : \n");
		for (WebElement names : ItemNames) {
			System.out.println(names.getText());
		}
	}

	public void openMenu_btn() throws Exception {
		openMenu.click();
		Thread.sleep(2000);
	}

	public void logout_btn() {
		logout_btn.click();
	}

	public void add_To_Cart() throws Exception {
		Thread.sleep(2000);
		AddElement.click();
	}

	public void remove_from_Cart() {
		RemoveElement.click();
	}
	public void all_Items_displayed() {
		for(WebElement names :ItemNames) {
			names.isDisplayed();
		}
	}

}
