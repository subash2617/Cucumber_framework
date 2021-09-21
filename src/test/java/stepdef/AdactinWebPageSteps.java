package stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.*;

public class AdactinWebPageSteps {

	WebElement SingleSelect;
	WebDriver driver;

	@Given("User launch the browser and navigate to adactin login page")
	public void user_launch_the_browser_and_navigate_to_adactin_login_page() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\SUBASH\\eclipse-workspace\\Cucumber\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
	}

	@When("User enters the username and password in adacting page")
	public void user_enters_the_username_and_password_in_adacting_page() {
		driver.findElement(By.id("username")).sendKeys("subash26"); //Dummy UserId
		driver.findElement(By.id("password")).sendKeys("Subash@123"); //Dummy password
	}

	@When("User clicks the login button in adacting page")
	public void user_clicks_the_login_button_in_adacting_page() {
		driver.findElement(By.id("login")).click();
	}

	@Then("User navigated to the adacting home page")
	public void user_navigated_to_the_adacting_home_page() {
		if (driver.getCurrentUrl().contains("SearchHotel")) {
			System.out.println("User successfully navigated to the adacting home page");
		} else {
			System.out.println("User not navigated to the adacting home page");
		}
	}

	@When("User selected the Location, Hotel, Room Type and Number of Rooms")
	public void user_selected_the_Location_Hotel_Room_Type_and_Number_of_Rooms() {
		Select l = new Select(driver.findElement(By.id("location")));
		Select h = new Select(driver.findElement(By.id("hotels")));
		Select rt = new Select(driver.findElement(By.id("room_type")));
		Select nr = new Select(driver.findElement(By.id("room_nos")));
		
		l.selectByValue("Sydney");
		h.selectByValue("Hotel Sunshine");
		rt.selectByValue("Super Deluxe");
		nr.selectByValue("1");
	}

	@When("User selected the Check In and Check Out Dates")
	public void user_selected_the_Check_In_and_Check_Out_Dates() throws AWTException {
		WebElement CheckIn = driver.findElement(By.id("datepick_in"));
		WebElement CheckOut = driver.findElement(By.id("datepick_out"));
		Actions a = new Actions(driver);
		Robot r = new Robot();
		a.doubleClick(CheckIn).perform();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		CheckIn.sendKeys("22/09/2021");
		
		a.doubleClick(CheckOut).perform();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		CheckOut.sendKeys("22/10/2021");
	}

	@When("User selected the Adults and Children per Room")
	public void user_selected_the_Adults_and_Children_per_Room() {
		Select a = new Select(driver.findElement(By.id("adult_room")));
		Select c = new Select(driver.findElement(By.id("child_room")));
		
		a.selectByValue("1");
		c.selectByValue("0");
	}

	@When("User Clicks the Search Button")
	public void user_Clicks_the_Search_Button() {
		driver.findElement(By.id("Submit")).click();
	}
}
