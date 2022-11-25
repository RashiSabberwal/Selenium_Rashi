package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingExcel {
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
	
	public Object[][] testData() {
		File src=new File("./testdata/SapientTestData.xlsx");
		Object[][] arr=null;
		try
		{
			FileInputStream fis=new FileInputStream(src);
            XSSFWorkbook wb=new XSSFWorkbook(fis);
            XSSFSheet sh1=wb.getSheet("LoginData");
           // XSSFRow r1=sh1.getRow(0);
            //XSSFCell c1=r1.getCell(0);
          int row=sh1.getPhysicalNumberOfRows();
          int col=sh1.getRow(0).getPhysicalNumberOfCells();
          arr=new Object [row][col];
          for(int i=0;i<row;i++) {
              for(int j=0;j<col;j++) {
                  arr[i][j]=sh1.getRow(i).getCell(j).getStringCellValue();
                
              }
          }
          
		}catch(FileNotFoundException e) {
			System.out.println("Please check data file path"+e.getMessage());
		}catch(IOException e) {
			System.out.println("Something Went Wrong IO"+e.getMessage());
		}
		return arr;
		
	}

}
