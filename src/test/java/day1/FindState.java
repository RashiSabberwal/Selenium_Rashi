package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FindState {
	
	@Test
	
	public static void State() throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@class,'subLink')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys("Rashi");
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("abc@abc.com");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Rashi@123");
		
		
		
		
		WebElement stateDropdown=driver.findElement(By.id("state"));
		Select state=new Select(stateDropdown);
		List<WebElement> allStates=state.getOptions();
		for(WebElement ele:allStates) 
		{
			String st=ele.getText();
			if(st.contains("Rajasthan")) {
				System.out.println("State found");
				break;
			}
		}
		

	}

}
