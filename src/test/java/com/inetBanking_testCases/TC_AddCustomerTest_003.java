package com.inetBanking_testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking_pageObjects.AddCustomerPage;
import com.inetBanking_pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);    
		log.info("UserName is provided");
		lp.setPassword(password);
		log.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust =new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		log.info("Providing Customer Deatils............");
		addcust.custName("Pavan");
		addcust.custGender("male");
		addcust.custDOB("12", "25", "1997");
		addcust.custAddress("INDIA");
		addcust.custCity("ANTPUR");
		addcust.custStATE("AP");
		addcust.custPincode("500074");
		addcust.custTelephoneNO(randomNum());
		System.out.println(randomNum());
		
		String email = randomString()+"@gamil.com";
		addcust.custEmailID(email);
		System.out.println(email);
		
		addcust.custPassword("asd123");
		addcust.custSubmit();
		log.info(" Clicked Submit Buttton.....");
		
		Thread.sleep(5000);
		log.info("Validation Started.....");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
			log.info("TestCase is Passed......");
		}else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			log.info("TestCase is Failed......");
		}
	}
	
	

}
