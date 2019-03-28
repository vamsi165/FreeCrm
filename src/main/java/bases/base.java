package bases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import utils.WebEventListener;

public class base {
	public static WebDriver driver;
	public static Properties pro;
	public static String propertiespath="C:\\Users\\kris\\Downloads\\workspace\\crmpro\\src\\main\\java\\config\\test.properties";
    public static EventFiringWebDriver ef;
    public static WebEventListener we;
	public base() throws IOException {
		pro=new Properties();
		FileInputStream fs = new FileInputStream(propertiespath);
		pro.load(fs);	
	}
	public WebDriver assign() {
	String browser=pro.getProperty("browser");
	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kris\\Downloads\\New folder (2)\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\kris\\Downloads\\New folder (2)\\gecko\\geckodriver.exe");
	driver=new FirefoxDriver();
	}
	ef =new EventFiringWebDriver(driver);
	we=new WebEventListener();
	ef.register(we);
	driver=ef;
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(pro.getProperty("url"));
	return driver;
	}

}
