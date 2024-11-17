package week5.day2.HomeAssignments;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


	public class ProjectSpecificMethod {
		
		ChromeDriver driver;
		
		@Parameters({"url","username","password"})
		@BeforeMethod
	  public void preCondition(String url,String user,String pwd) {
		  
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
			
			driver.findElement(By.id("username")).sendKeys(user);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.id("Login")).click();
		  
	  }
	
	  @AfterMethod
	  public void postCondition() {
		  
		  driver.close();
		  
	  }
	

  
}
