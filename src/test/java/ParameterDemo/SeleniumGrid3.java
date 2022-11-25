package ParameterDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class SeleniumGrid3 {
	WebDriver driver;
	@Parameters({"os","osVersion","browserName","browserVersion"})
	@BeforeMethod
	public void setup(String os,String osVersion,String browser,String browserVersion) {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", browserVersion);
		capabilities.setCapability("os", os);
		capabilities.setCapability("osVersion", osVersion);
		URL url=null;
		try {
			url = new URL("https://rashisabberwal_bD857L:ugHz2KSXNYBN9iFFdn3z@hub-cloud.browserstack.com/wd/hub");

		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver=new RemoteWebDriver(url,capabilities);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void Test1() {
		driver.get("https://ineuron-courses.vercel.app/login");
        Assert.assertEquals(driver.getCurrentUrl().contains("app"),true);
	}
	

}
