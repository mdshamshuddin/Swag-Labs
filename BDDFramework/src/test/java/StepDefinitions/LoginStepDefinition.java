//package StepDefinitions;
//
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginStepDefinition {
//	WebDriver driver;
//
//	@Given("user is on login page")
//	public void user_is_on_login_page() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.saucedemo.com/v1/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
//
//	@When("user enters valid username and password")
//	public void user_enters_valid_username_and_password() throws Exception {
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.xpath(" //input[@id='password']")).sendKeys("secret_sauce");
//		Thread.sleep(2000);
//	}
//
//	@When("user enters invalid username and password")
//	public void user_enters_invalid_username_and_password() throws Exception {
//		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
//		driver.findElement(By.xpath(" //input[@id='password']")).sendKeys("secret_sauce");
//		Thread.sleep(2000);
//	}
//	
//	@Then("user found error message")
//	public void user_found_error_message() {
//		String errormsg=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
//		Assert.assertEquals(errormsg, "Epic sadface: Sorry, this user has been locked out.","Error Message doesnot match!");
//		System.out.println("Test Passed : Error Message is as expected ");
//	}
//
//	@When("user enters valid {string} and {string}")
//	public void user_enters_valid_and(String username, String password) throws Exception {
//		driver.findElement(By.id("user-name")).sendKeys(username);
//		driver.findElement(By.xpath(" //input[@id='password']")).sendKeys(password);
//		Thread.sleep(2000);
//	}
//
//	@And("click on login button")
//	public void click_login_button() {
//		driver.findElement(By.id("login-button")).click();
//	}
//
//	@Then("user is navigated to Home page")
//	public void user_navigated_to_home_page() {
//		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size() > 0,
//				"user is navigated to home page");
//	}
//
//	@And("close the browser")
//	public void close_the_browser() {
//		driver.close();
//		driver.quit();
//	}
//
//}
