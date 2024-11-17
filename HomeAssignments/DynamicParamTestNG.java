package week5.day2.HomeAssignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DynamicParamTestNG extends ProjectSpecificMethod {
	
	@Test (dataProvider = "sendData")
	public void verfiyLegalEntity(String inputName) throws InterruptedException {
		
				
		//Click on the toggle menu button from the left corner
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Click View All and click Legal Entities from App Launcher 
		
		
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));
		System.out.println(element.getText());
		driver.executeScript("arguments[0].click()", element);
		
		//Click on the Dropdown icon in the legal Entities tab 
		
		Thread.sleep(2000);
		WebElement legalEntityWE = driver.findElement(By.xpath("//span[@class='slds-assistive-text' and text()='Legal Entities List']"));
		driver.executeScript("arguments[0].click()", legalEntityWE);
		
		
		//Click on New Legal Entity
		
		Thread.sleep(2000);		
		WebElement entityWE = driver.findElement(By.xpath("//span[contains (text(),'New Legal Entity')]"));
		driver.executeScript("arguments[0].click()", entityWE);
		
		//Enter Name as 'Salesforce Automation by *Your Name*'
		
		//String inputName = "Salesforce Automation by TestUser";
		WebElement nameWE = driver.findElement(By.xpath("//input[@name='Name']"));
		driver.executeScript("arguments[0].value=arguments[1];", nameWE,inputName);
		
		
		//Click save and verify Legal Entity Name 
		
		WebElement saveWE = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click()", saveWE);
		
		String name = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if(inputName.equals(name))
			System.out.println("Legal Entity name Verified");
		else
			System.out.println("Incorrect Legal Entity Name");
	}
	
	@DataProvider
	public String[] sendData()
	{
		String[] inpName = {"Salesforce Automation by TestUser"};
		return inpName;
	}

}
