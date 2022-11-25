package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAutoSuggestions {

	public static void Suggestions() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		
		Thread.sleep(3000);
		List<WebElement> allELements=driver.findElements(By.xpath("//a[contains(@class,'state-default')]"));
		Thread.sleep(2000);
		for(WebElement ele:allELements) {
			if(ele.getText().equals("25")) {
				ele.click();
				break;
			}
		}

	}

}
