package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConst {

	public WebDriver driver;
	
	@BeforeMethod
	public void preCondition(){
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost");
	}
	
	@AfterMethod
	public void postCondition(){
		driver.quit();
	}
}
