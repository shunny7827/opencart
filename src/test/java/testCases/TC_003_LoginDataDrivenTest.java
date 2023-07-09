package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest  extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String password , String exp)
	{
		logger.info("*** Starting the test here ***");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
				
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();// this method is created MyAccountPage

		if (exp.equals("Valid")) {
			if (targetpage == true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equals("Invalid")) {
			if (targetpage == true) {
				MyAccountPage myaccpage = new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	} catch (Exception e) {
		Assert.fail();
	}
		logger.info("*** Ending of the test ***");
}
}

