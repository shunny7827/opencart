package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void test_login()
	{
		try
		{
		logger.info("*** Starting the test ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" clicked my account");
		hp.clickLogin();
		logger.info("clicked login");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		logger.info("entered the email");
		lp.setPassword(rb.getString("password"));
		logger.info("entered the password");
		lp.clickLogin();
		logger.info("clicked the login button");
		
		MyAccountPage map = new MyAccountPage(driver);
		Assert.assertEquals(map.isMyAccountPageExists(), true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("finish test");
	}
	

}
