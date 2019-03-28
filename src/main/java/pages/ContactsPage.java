package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import bases.base;

public class ContactsPage extends base{

	public ContactsPage() throws IOException {
		super();
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//td[contains(text(),'Contacts')]")
WebElement contactslable;
	
public boolean contactslable() {

	boolean contact=contactslable.isDisplayed();
	return contact;
}

public void createnewcontact(String title, String fname,String mname,String lname) {
	Select s1 = new Select(driver.findElement(By.xpath("//select[@name='title']")));
	s1.selectByVisibleText(title);
	driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@id='middle_initial']")).sendKeys(mname);
	driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(lname);
	driver.findElement(By.xpath("//input[@type='submit'][@value='Save']")).click();
	
}
	
}
