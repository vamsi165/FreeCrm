package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bases.base;

public class Homepage extends base {

	public Homepage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[contains(text(),'User: vamsi krishna')]")
	WebElement currentuser;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="	//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	public String homepagetitle() {
		String title=driver.getTitle();
		return title;
	}
	public ContactsPage clickoncontacts() throws IOException {
	 contactslink.click();
	 return new ContactsPage();
	}
	public void createnewcontact() {
		Actions a1 =new Actions(driver);
		a1.moveToElement(contactslink).build().perform();
		newcontact.click();
	}
	public boolean verifyhomepageuser() {
	boolean display=currentuser.isDisplayed();
	return display;
	}
	

	


	

}
