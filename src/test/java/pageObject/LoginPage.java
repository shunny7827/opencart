package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// webelements
	
	@FindBy(xpath="//input[@id='input-email']") WebElement text_email_address;
	@FindBy(xpath="//input[@id='input-password']") WebElement text_password;
	@FindBy(xpath="//input[@value='login']") WebElement btn_login;
	
	// Actions
	
	public void setEmail(String email)
	{
		text_email_address.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		text_password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btn_login);
	}
	
	
	

}
