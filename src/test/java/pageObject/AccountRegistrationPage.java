package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	// elements
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement text_firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement text_lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement text_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement text_password;
	@FindBy(xpath="//input[@name='agree']") WebElement checkbox_agree;
	@FindBy(xpath="//button[@type='submit']") WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msg_confirmation;
	
	
	//Action methods
	
	public void setFirstName(String fname)
	{
		text_firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		text_lastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		text_email.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		text_password.sendKeys(password);
	}
	
	public void setPrivacyPolicy()
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", checkbox_agree);
	}
	
	public void clickContinue()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btn_continue);
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return (msg_confirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
}
