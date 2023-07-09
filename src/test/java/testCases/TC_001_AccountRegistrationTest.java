package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass  {
	
	@Test(groups= {"Regression","Master"})
	void test_account_registration()
	{
		logger.info("***  Starting the test  ***");
		try 
		{
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on the myAccount");
		hp.clickRegister();
		logger.info("clicked on register");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver); 
		logger.info("providing the customer data");
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toLowerCase());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setPassword("jkl");
		arp.setPrivacyPolicy();
		arp.clickContinue();
		logger.info("clicked on continue");
		System.out.println("continue is clicked");
//		String confirmationMsg=arp.getConfirmationMsg();
//		Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			System.out.println("fail assertion");
		}
	}

}
