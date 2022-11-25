package day3;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Categories {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.out.println("Running Before Method-Creating Browser Session");
		driver =new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	@Test
	public void ManageCategories() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[contains(@name,'email1')]")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.xpath("//input[contains(@name,'password1')]")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		System.out.println("Text is "+driver.findElement(By.xpath("//h2[@class='name']")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='name']")).getText().contains("JAVA SELENIUM"));
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Practise']")).isDisplayed(), true);
		String parent=driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//span[text()='Manage']"));
		act.moveToElement(ele).perform();
		
		
		driver.findElement(By.xpath("//span[text()='Manage Categories']")).click();
		Set<String> allWindowHandle=driver.getWindowHandles();
		for(String child:allWindowHandle)
		{
			
			if(!child.equals(parent))
			{
				
				driver.switchTo().window(child);
				driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
				
			}
			
			
		}
		Alert alt=driver.switchTo().alert();
		alt.sendKeys("PythonJava");
		alt.accept();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//td[text()='PythonJava']//following::button[1]")));
		
		//driver.findElement(By.xpath("//td[text()='PythonJava']//following::button[1]")).click();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//td[text()='PythonJava']//following::button[1]")));
		
		//Alert alt1=driver.switchTo().alert();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		
		
		
		
		

	}

}
