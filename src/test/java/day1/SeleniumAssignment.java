package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumAssignment {
	
	@Test
	
	public static void Assignment() {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
        driver.get("http://137.184.76.209/orangehrm-4.9");
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        
        /*
         * Navigation nav = driver.navigate();
         * nav.back();
         */
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.xpath("//a[contains(@class,'firstLevelMenu')]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'btnAdd')]")).click();
        driver.findElement(By.xpath("//select[contains(@name,'systemUser[userType]')]")).sendKeys("Mukesh Otwani");
        driver.findElement(By.xpath("//input[contains(@name,'systemUser[employeeName][empName]')]")).sendKeys("Rashi");
        driver.findElement(By.xpath("//input[contains(@name,'systemUser[userName]')]")).sendKeys("Rashi@12345678");
        
        
        
        
        

	}

}
