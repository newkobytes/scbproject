package stepdefs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebTable2 {
	
	WebDriver driver = new ChromeDriver();
	@Given("I get into the designated url for webtable2")
	public void i_get_into_the_designated_url_for_webtable2() {
		 driver.get("https://www.dezlearn.com/webtable-example/");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("I handle with webtables2")
	public void i_handle_with_webtables2() throws InterruptedException {
	    //rows:
		int rows = driver.findElements(By.xpath("//table[@class='tg']/tbody/tr")).size();
		System.out.println("No.of rows: "+ rows);
		
		//columns:
		int cols= driver.findElements(By.xpath("//table[@class='tg']/tbody/tr/th")).size();
		System.out.println("No.of cols: "+ cols);
		
		//all data:
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		try{
			
			//wait.until(ExpectedConditions.)
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='MailerLite Form']")));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("first Its clicked");
		}
		
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("abc@gmail.com");
		WebElement name = driver.findElement(By.xpath("//input[@aria-label='name']"));
		name.sendKeys("Shamila");
		Actions action = new Actions(driver);
		WebElement close = driver.findElement(By.xpath("//div[@class='ml-popup w-100 row-form']/button[@class='close']/span[@aria-hidden='true']"));
		action.moveToElement(close);
		
		close.click();
		//WebElement join = driver.findElement(By.xpath("//button[text()=' Join Now ']"));
		//join.click();
		
		//Thread.sleep(3000);
		//Actions action = new Actions(driver);
	/*try {
		WebElement close=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ml-popup w-100 row-form']/button[@class='close']/span[@aria-hidden='true']")));
		close.click();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	*/
		//Thread.sleep(5000);
		//WebElement frame1= driver.findElement(By.xpath("//iframe[@id='ml-webforms-popup-3672985']"));
		//driver.switchTo().frame(frame1);
		/*Thread.sleep(3000);
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='mailerlite-popup']"));
		driver.switchTo().frame(frame2);
		
		*/
		/*for(int r=1;r<=rows;r++)
		{
			for(int c=1; c<=cols;c++)
			{
				
				String alldataheaders= driver.findElement(By.xpath("//table[@class='tg']/tbody/tr["+r+"]/th["+c+"]")).getText();
				String alertext=driver.findElement(By.xpath("//div[@class='ml-popup-blocks w-100']")).getText();
				WebElement frame1= driver.findElement(By.xpath("//iframe[@id='ml-webforms-popup-3672985']"));
				driver.switchTo().frame(frame1);
				Thread.sleep(3000);
				WebElement frame2 = driver.findElement(By.xpath("//div[@class='mailerlite-popup']"));
				driver.switchTo().frame(frame2);
				WebElement xbutton= driver.findElement(By.xpath("//span[@aria-hidden='true']"));
				Actions action = new Actions(driver);
				xbutton.click();
				//System.out.println(alldataheaders + " ");
				String alldata= driver.findElement(By.xpath("//table[@class='tg']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.println(alldata + " ");
			}
			System.out.println();
		}
		*/
		//specific data
		
		String specificdata = driver.findElement(By.xpath("//td[text()='john@dezlearn.com']/preceding::td[1]")).getText();
		System.out.println("Specific data email of john is  " + specificdata);
		
		//retrieve all data from 5th row:
		
		for(int c=1; c<=cols;c++)
		{
			String fifthrowdata = driver.findElement(By.xpath("//table[@class='tg']/tbody/tr[5]/td["+c+"]")).getText();
			System.out.println("5th row data is  " + fifthrowdata);
			
		}
		
		for(int r=1;r<=rows;r++)
		{
			String email1= driver.findElement(By.xpath("//table[@class='tg']/tbody/tr["+r+"]/td[2]")).getText();
			
			if(email.equals("alvin@dezlearn.com"))
			{
				String name1= driver.findElement(By.xpath("//table[@class='tg']/tbody/tr["+r+"]/td[1]")).getText();
				System.out.println("Name of the designated email id is  " + name);
			}
		}
	}

	@Then("I logout of the browser for webtable2")
	public void i_logout_of_the_browser_for_webtable2() {
		driver.close();
	   
	}


}
