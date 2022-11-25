package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorsHubEx {
	@Test
	public void Test3() {
	WebDriver driver=new ChromeDriver();
	driver.get("https://selectorshub.com/xpath-practice-page/");
	driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("Rashi");
	}

}
