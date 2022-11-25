

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment {

	public static void main(String[] args) throws InterruptedException {
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
        driver.findElement(By.xpath("//select[contains(@name,'systemUser[userType]')]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[contains(@name,'systemUser[employeeName][empName]')]")).sendKeys("Mukesh Otwani");
        driver.findElement(By.xpath("//input[contains(@name,'systemUser[userName]')]")).sendKeys("Rashee");
        driver.findElement(By.xpath("//input[contains(@name,'systemUser[password]')]")).sendKeys("VAM@hk0526");
        driver.findElement(By.xpath("//input[contains(@name,'systemUser[confirmPassword]')]")).sendKeys("VAM@hk0526");
 Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Rashee");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("VAM@hk0526");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(10000);
        
        driver.quit();
        
        
        
        
        
        
        
        

	}

}
