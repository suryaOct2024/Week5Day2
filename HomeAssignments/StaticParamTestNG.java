package week5.day2.HomeAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class StaticParamTestNG extends ProjectSpecificMethod {
	
	@Test
	public void verifyErrorMsg() throws InterruptedException
	{
		
		
		//Click on the toggle menu button from the left corner
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Click View All and click Legal Entities from App Launcher 
		
		
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));
		driver.executeScript("arguments[0].click()", element);
		
		//Click on the Dropdown icon in the legal Entities tab 
		
		Thread.sleep(2000);
		WebElement legalEntityWE = driver.findElement(By.xpath("//span[@class='slds-assistive-text' and text()='Legal Entities List']"));
		driver.executeScript("arguments[0].click()", legalEntityWE);
		
		
		//Click on New Legal Entity
		
		Thread.sleep(2000);		
		WebElement entityWE = driver.findElement(By.xpath("//span[contains (text(),'New Legal Entity')]"));
		driver.executeScript("arguments[0].click()", entityWE);
		
		//Enter the Company name as 'TestLeaf'. 
				
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		
		//Enter Description as 'Salesforces'. 
		
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		
		//Select Status as 'Active' 
		
		WebElement statusWE = driver.findElement(By.xpath("//button[@aria-label='Status']"));
		driver.executeScript("arguments[0].click()", statusWE);
		WebElement activeStatusWE = driver.findElement(By.xpath("//span[text()='Active']"));
		driver.executeScript("arguments[0].click()", activeStatusWE);
		
		//Click on Save
		
		WebElement saveWE = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click()", saveWE);
		
		//Verify the Alert message (Complete this field) displayed for Name 
		
		WebElement alertmsgWE = driver.findElement(By.xpath("//a[text()='Legal Entity Name']"));
		driver.executeScript("arguments[0].click()", alertmsgWE);
				
		String errMsg = driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[2]")).getText();
		System.out.println(errMsg);	
		if(errMsg.equals("Complete this field."))
			System.out.println("Name Alert Verification successful");
		else
			System.out.println("Check the Name Alert msg");
		
				
	}

}
