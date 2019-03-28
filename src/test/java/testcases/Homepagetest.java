package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bases.base;
import junit.framework.Assert;
import pages.ContactsPage;
import pages.Homepage;
import pages.LoginPage;
import utils.util;

public class Homepagetest extends base {
	public static LoginPage l1;
	public static Homepage h1;
	public static util u1;
    public static ContactsPage c1;
	public Homepagetest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		assign();
		l1=new LoginPage();
		h1=new Homepage();
	    h1=	l1.login(pro.getProperty("username"),pro.getProperty("pwd"));
	    u1=new util();
	   }
	
	@Test(priority=1)
	public void homepagetitletest() {
		Assert.assertEquals("CRMPRO",h1.homepagetitle());
	}
	
	@Test(priority=2)
	public void homepageuser() {
		u1.switchtoframe();
		assertTrue(h1.verifyhomepageuser());
	}
	
	@Test(priority=3)
	public void contactlinktest() throws IOException {
		u1.switchtoframe();
		c1=h1.clickoncontacts();
	}
	
	
    @AfterMethod
    public void shutdown() {
    	driver.quit();
    }

}
