package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bases.base;
import junit.framework.Assert;
import pages.ContactsPage;
import pages.Homepage;
import pages.LoginPage;
import utils.util;

public class ContactPageTest extends base {
	public static Homepage h1;
	public static LoginPage l1;
	public static ContactsPage c1;
	public static util u1;

	public ContactPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		assign();
		l1=new LoginPage();
		h1=  l1.login(pro.getProperty("username"),pro.getProperty("pwd"));
		c1=new ContactsPage();
		u1=new util();
		}
	@Test(priority=1)
	public void testcontactlable() throws IOException {
		u1.switchtoframe();
     c1= h1.clickoncontacts();
     Assert.assertTrue(c1.contactslable());
}
	@Test(priority=2,dataProvider="contactdata")
	public void createncontact(String title,String fname,String mname,String lname) {
		u1.switchtoframe();
		h1.createnewcontact();
		c1.createnewcontact(title, fname, mname, lname);
		
	}
	
	@DataProvider
	public Object[][] contactdata() {
	Object[][] data=u1.getTestData("contacts");
	return data;
	}
	@AfterMethod
	public void shutdown() {
		driver.quit();
	}
}