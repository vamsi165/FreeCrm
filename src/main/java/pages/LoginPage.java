package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bases.base;

public class LoginPage extends base{

	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	 WebElement login;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Login']")
  	WebElement button;
	
	@FindBy(xpath="//div[@id='preloader']/following-sibling::div/div/div/a[1]")
	WebElement logo;

	public Homepage login(String uname, String up) throws InterruptedException, IOException {
		login.sendKeys(uname);
		pwd.sendKeys(up);
		Thread.sleep(3000);
		button.click();
		return new Homepage();
	}
	public  boolean logo() {
		boolean log=logo.isDisplayed();
		return log;
	}
	public String title() {
		String title=driver.getTitle();
		return title;
	}

	

}
