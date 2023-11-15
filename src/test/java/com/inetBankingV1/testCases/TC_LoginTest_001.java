package com.inetBankingV1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjetcs.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest()
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
