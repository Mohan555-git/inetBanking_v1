package com.inetBanking_testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking_pageObjects.LoginPage;

public class TC_LoginTest_001  extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL);
		log.info("URl is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("UserName text box found & Entered");
		lp.setPassword(password);
		log.info("Password text box found & Entered");
		lp.clickSubmit();
		log.info("Submit button found & Clicked ");
		//System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				Assert.assertTrue(true);
				System.out.println(driver.getTitle());
				log.info("Login Test Passed ");
				
			}else 
			 {
				captureScreen(driver, "loginTest");
				Assert.assertTrue(false);
				log.info("Login Test Failed");
				
			 }
		
	}
	
	

}
