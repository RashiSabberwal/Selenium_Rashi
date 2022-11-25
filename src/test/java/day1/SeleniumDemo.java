package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumDemo {
	@Test
	
	public static void Demo() {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Your name");
		String title=driver.getTitle();
		System.out.println("Title is"+title);
		String url=driver.getCurrentUrl();
        System.out.println("Url is "+url);
        driver.quit();    

	}

}
