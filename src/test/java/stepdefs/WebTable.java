package stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebTable {
	WebDriver driver = new ChromeDriver();
	@Given("I get into the designated url")
	public void i_get_into_the_designated_url() {
	    
	    driver.get("https://cosmocode.io/automation-practice-webtable/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	   }

	@Given("I handle with webtables")
	public void i_handle_with_webtables() {
		//Inspecting rows in table
		int rows = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr")).size();
		System.out.println("Number of rows: " + rows);
		//inspecting columns
		int cols = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td/h3")).size();
		System.out.println("Number of cols: " + cols);
		//retrieving specific data
		String data1 = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[2]/td[2]")).getText();
		System.out.println("Number of data1: " + data1);
		String data2 = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[9]/td[4]")).getText();
		System.out.println("Number of data2: " + data2);
		/*
		//retrieve all data from table:
		for(int r=1; r<=rows;r++)
		{
			for(int c=1; c<=cols; c++)
			{
				String alldata= driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(alldata + " ");
			}
			System.out.println();
		}
	    */
	
	
	////retrieve all data from table based on a condition:
	
		String specificdata = driver.findElement(By.xpath("//td[contains(text(),'Portuguese')]/preceding::td[3]")).getText();
		System.out.println("The country of the language Portuguese is " + specificdata);
		
	//retrieve all data from 3rd row
	for(int c=1;c<=cols;c++) {
			String thirdrowdata= driver.findElement(By.xpath("//table[@id='countries']/tbody/tr[3]/td["+c+"]")).getText();
			
			System.out.print(thirdrowdata + " ");
		
	}
	
	//retrieve through all rows and get the data if condition matches:
	for(int r=1;r<=rows;r++)
	{
		String lang= driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td[5]")).getText();
		if(lang.equals("Finnish; Swedish"))
		{
			String currency= driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+r+"]/td[4]")).getText();
			System.out.println("Currency is: " +currency);
		}
		
		
	}
	
	
	
	
	}
	@Then("I logout of the browser")
	public void i_logout_of_the_browser() {
		driver.close();
		System.out.println("Driver Closed");
		
	}

	
}
