package stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginStepDef
	{
		WebDriver driver;
		
		public LoginStepDef()
		{
			driver = new EdgeDriver();
			System.out.println("Selenium Driver got installed");
		}
		@Given("user opens facebook login page")
		public void user_opens_facebook_login_page()
		{
			driver.get("https://www.redbus.in/bus-tickets/chennai-to-coimbatore?fr...");
		 // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  System.out.println("Orangehrm page opened!");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		}
		@When("user enters username and password")
		public void user_enters_username_and_password() {
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		  
		}
		@When("user clicks on login button")
		public void user_clicks_on_login_button() {
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		@Then("user is on home page")
		public void user_is_on_home_page() {
		  Assert.assertTrue(driver.getTitle().contains("Orange"));
		}
	 
	 
	 
	}

