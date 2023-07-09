package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement link_myAccount;
	@FindBy(linkText = "Register") WebElement link_register;
	@FindBy(linkText = "Login")WebElement link_login;
	
	//Action method
	
	public void clickMyAccount()
	{
		link_myAccount.click();
	}
	
	public void clickRegister()
	{
		link_register.click();
	}
	
	public void clickLogin()
	{
		link_login.click();
	}
}
