package ParameterDemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadFile {
	@Test
	public void test() throws IOException, InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("file-upload"))).click().perform();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\rassabbe\\Desktop\\AutoitSample.exe");
		driver.findElement(By.id("file-submit")).click();  
		driver.quit();
	}


}
