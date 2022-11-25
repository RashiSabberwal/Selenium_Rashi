package day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlert {

	public static void Alert() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alt=wb.until(ExpectedConditions.alertIsPresent());
        alt.accept();

		
		
		

	}

}
