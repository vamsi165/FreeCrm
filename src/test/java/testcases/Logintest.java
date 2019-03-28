package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bases.base;
import pages.LoginPage;

public class Logintest extends base {
public static LoginPage l1;
	public Logintest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		assign();
		l1=new LoginPage();
	}
	
	@Test(priority=1)
	public void logotest() {
		Assert.assertTrue(l1.logo());
	}
	@Test(priority=2)
	public void titletest() {
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",l1.title());
	}

	@Test(priority=3)
public void logintest() throws InterruptedException, IOException {
	l1.login(pro.getProperty("username"),pro.getProperty("pwd"));
	}
	
	@AfterMethod
	public void shutdown() {
		driver.quit();
	}
}
