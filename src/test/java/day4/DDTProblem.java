package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTProblem {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// System.out.println("Running Before Method-Creating Browser Session");
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "testdata")
	public void myTest(String username, String password) {
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		//Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Practise']")).isDisplayed(), true);
		Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='name']")).getText().contains("JAVA SELENIUM"));


	}

	@DataProvider(name = "testdata")
	public Object[][] testDataGeneration() {
		Object[][] arr = new Object[4][2];

		arr[0][0] = "sample9@gmail.com";
		arr[0][1] = "Mukesh1234";
		arr[1][0] = "samplemukesh@gmail.com";
		arr[1][1] = "Mukesh1234";
		arr[2][0]= "samplemukesh1@gmail.com";
		arr[2][1]=   "Mukesh1234";
		arr[3][0]= "samplemukesh2@gmail.com";
		arr[3][1]= "Mukesh1234";
		return arr;

	}

}
