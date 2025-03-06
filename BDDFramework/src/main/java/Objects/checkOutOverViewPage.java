package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkOutOverViewPage extends basePage {
	WebDriver driver;
	homePage homepage;
	loginPage loginpage;
	openCartPage opencart;
	checkOutInfoPage checkout;

	public checkOutOverViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> addeditemOverview;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> itemPrices;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	WebElement actualPrice;
	@FindBy(xpath = "//div[contains(text(),'Payment Information:')]")
	WebElement shipping_info;
	@FindBy(xpath = "//div[@class='summary_tax_label']")
	WebElement taxPrice;
	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement TotalPrice;
	@FindBy(xpath = "//a[@class='btn_action cart_button']")
	WebElement finish_btn;

	public void verifyOverView() throws InterruptedException {
		opencart = new openCartPage(driver);
		checkout = new checkOutInfoPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(addeditemOverview));
		if (opencart.elementsAdded.size() == addeditemOverview.size()) {
			System.out.println("Elements are same as added to cart ");
		} else {
			System.out.println("Elements are not same as added to cart");
		}
	}

	public double calculateTotalPrice() {
		double totalPrice = 0.0;

		for (WebElement priceElement : itemPrices) {
			// Extract the price text and remove the '$' sign, then convert to double
			String priceText = priceElement.getText().replace("$", "").trim();
			double price = Double.parseDouble(priceText); // Convert string to double
			totalPrice += price; // Add the price to the total
		}
		return totalPrice;

	}

	public double tax_price() {
		String taxprice = taxPrice.getText().replace("Tax: $", "").trim();
		double price = Double.parseDouble(taxprice);
		return price;
	}

	public void total_Price() {
		String priceText = TotalPrice.getText().replace("Total: $", "").trim();
		double totalPrice = Double.parseDouble(priceText);
		System.out.println(totalPrice);

		if (calculateTotalPrice() + tax_price() == totalPrice) {
			System.out.println("item total + Tax price = Total price " + calculateTotalPrice() + "$" + " + "
					+ tax_price() + "$" + " = " + totalPrice + "$");
		}

	}

	public void verifyPrice() {
		double calculatedPrice = calculateTotalPrice();
		String price = actualPrice.getText().replace("Item total: $", "").trim();
		double expectedPrice = Double.parseDouble(price);
		if (Math.abs(calculatedPrice - expectedPrice) < 0.01) {
			System.out.println("Price verification successful! Calculated price: " + "$ " + calculatedPrice);
		} else {
			System.out
					.println("Price verification failed! Expected: " + expectedPrice + " but got: " + calculatedPrice);
		}
	}

	public void shipping_info() {
		if (shipping_info.isDisplayed()) {
			System.out.println(shipping_info);
		}
	}

	public void finish_button() {
		finish_btn.click();
	}

}
