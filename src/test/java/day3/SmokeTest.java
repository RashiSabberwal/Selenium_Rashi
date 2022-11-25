package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.out.println("Running Before Method-Creating Browser Session");
		driver =new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Running After Method-Browser Session Closed");
	}
	@Test
	public void invalidPassword() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText().contains("Password cannot be empty"));
		
	}
	
	@Test
	public void validCredentials() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).getText().contains("Welcome 123456"));
		
	}
	@Test
	public void invalidUsername() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText().contains("Username cannot be empty"));
		
	}
	@Test
	public void invalidCredentials() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText().contains("Invalid credentials"));
		
	}
	
	

}
