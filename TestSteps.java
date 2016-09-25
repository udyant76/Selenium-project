package CucumberTest;

import java.util.concurrent.TimeUnit;
import java.util.Collections;
import org.junit.Assert;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
//import junit.framework.Assert;;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElements;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	public static WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		// In case new version of Firefox and windows, it is necessary to include geckodriver.exe in system property
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Udyant/eclipse/java-neon/eclipse/geckodriver/geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Udyant\\eclipse\\java-neon\\eclipse\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://www.store.demoqa.com");
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().maximize();
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.linkText("Form Authentication")).click();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		//driver.findElement(By.id("log")).sendKeys("testuser_1"); 	 
		//driver.findElement(By.id("pwd")).sendKeys("Test@1234");
		//driver.findElement(By.id("login")).click();
		driver.findElement(By.id("username")).sendKeys("tomsmith"); 	 
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		//driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below.");
		driver.getPageSource().contains("You logged into a secure area!");
		System.out.println("Login Successfully");
		driver.findElement(By.cssSelector("a[href*='/logout']")).click();
		driver.getPageSource().contains("You logged out of the secure area!");
	}


	@When("^User enters Wrong UserName$")
	public void user_enters_Wrong_UserName() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("jacksmith"); 	 
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
	}
	
	@Then("^Message displayed Wrong Username$")
	public void message_displayed_Wrong_Username() throws Throwable {
		//driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below.");
		driver.getPageSource().contains("Your username is invalid!");
	}
	
	@When("^User enters Wrong Password$")
	public void user_enters_Wrong_Password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("tomsmith"); 	 
		driver.findElement(By.id("password")).sendKeys("SuperSecret");
		driver.findElement(By.className("radius")).click();
	}
	
	@Then("^Message displayed Wrong Password$")
	public void message_displayed_Wrong_Password() throws Throwable {
		//driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below.");
		driver.getPageSource().contains("Your password is invalid!");
	}

	@Then("^Browser is Getting Closed$")
	public void browser_is_Getting_Closed() throws Throwable {
		driver.close();
	}
	
	@When("^User Navigate to Hover Page$")
	public void user_Navigate_to_Hover_Page() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.linkText("Hovers")).click();
	}
	

	@When("^User hovers Image 1$")
	public void user_hovers_Image_1() throws Throwable {
		Actions action = new Actions(driver); 	
		WebElement ele = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
		action.moveToElement(ele);
		action.perform();
	}
	
	@Then("^Message displayed User 1$")
	public void message_displayed_User_1() throws Throwable {
		//driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below.");
		driver.getPageSource().contains("name: user1");
	}
	
	
	@When("^User hovers Image 2$")
	public void user_hovers_Image_2() throws Throwable {
		Actions action = new Actions(driver); 	
		WebElement ele = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
		action.moveToElement(ele);
		action.perform();
	}
	
	@Then("^Message displayed User 2$")
	public void message_displayed_User_2() throws Throwable {
		//driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below.");
		driver.getPageSource().contains("name: user2");
	}
	
	
	@When("^User Navigate to Table Page$")
	public void user_Navigate_to_Table_Page() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.linkText("Sortable Data Tables")).click();
	}
		
	
	@When("^User Click Table First Time$")
	public void user_Click_Table_First_Time() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.cssSelector("#table2 thead .last-name")).click();
	}	
	
	@Then("^User Gets Table in Ascending Order$")
	public void user_gets_Table_in_Ascending_Order() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	    List<WebElement> lastname = driver.findElements(By.cssSelector("#table2 thead .last-name"));
	    List<String> stringslist = new ArrayList<String>();
	    List<String> strlist1 = new ArrayList<String>();
	    List<String> strlist2 = new ArrayList<String>();
	    for(WebElement e : lastname){
	        stringslist.add(e.getText());
	    }
	    strlist1 = stringslist;
	    Collections.sort(stringslist);
	    strlist2 = stringslist; 
	    Assert.assertEquals(strlist1, strlist2);
	}		
	
	@When("^User Click Table Second Time$")
	public void user_Click_Table_Second_Time() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.cssSelector("#table2 thead .last-name")).click();
	}	
	
	@Then("^User Gets Table in Descending Order$")
	public void user_gets_Table_in_Descending_Order() throws Throwable {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	    List<WebElement> lastname = driver.findElements(By.cssSelector("#table2 thead .last-name"));
	    List<String> stringslist = new ArrayList<String>();
	    List<String> strlist1 = new ArrayList<String>();
	    List<String> strlist2 = new ArrayList<String>();
	    for(WebElement e : lastname){
	        stringslist.add(e.getText());
	    }
	    strlist1 = stringslist;
	    Collections.reverse(stringslist);
	    strlist2 = stringslist; 
	    Assert.assertEquals(strlist1, strlist2);
	}			
	

}