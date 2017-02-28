package pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.WebWindowNotFoundException;

import generic.BasePage;

public class LoginPage extends BasePage{

	@FindBy(id = "username")
	private WebElement unTB;
	
	@FindBy(name = "pwd")
	private WebElement pwTB;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//nobr[contains[.,'actiTime']")
	private WebElement version;
	
	@FindBy(xpath="//span[contains[.,'invalid']")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
	public void setUserName(String un){
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw){
		unTB.sendKeys(pw);
	}
	
	public void clickLogin(){
		loginBtn.click();
	}
	
	public void verifyVersion(String eVersion){
		String aVersion = version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void verifyErrIsPresent(SoftAssert s){
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		try{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Error msg is displayed", true);
		}
		catch(Exception e){
			Reporter.log("Error msg is not displayed "+e.getClass(), true);
			s.fail();
		}
				
	}
	

}
