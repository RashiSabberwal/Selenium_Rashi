package day3;

import org.testng.Assert;
import org.testng.annotations.Test;



public class MyFirstTestNG {
	@Test(priority=1)
	public void login() {
		Assert.assertTrue(true);
		System.out.println("Logged in");
	}
	@Test
	public void AccountCreated() {
		System.out.println("Created");
	}
	@Test
	public void logout() {
		System.out.println("logout");
	}
	@Test
	public void test1() {
		Assert.assertEquals(12, 12);
	}
	

}
