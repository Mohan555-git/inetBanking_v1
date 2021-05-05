package com.inetBanking_testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.XLUtils;
import com.inetBanking_pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd)
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		log.info("Username is provided");
		lp.setPassword(pwd);
		log.info("Password is Provided");
		lp.clickSubmit();
		log.info("Clicked Submit Button");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //when enter invalid credentials close the alert.
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true); //when enter valid credentials go & login.
			log.info("Login Passed");
			lp.clicklogout();
			driver.switchTo().alert().accept();  //Close logout Alert.
			driver.switchTo().defaultContent();
		}

	}
	
	public boolean isAlertPresent()
	         
	{     // User defined method created to check whether alert is present or not.
		try
		{
			driver.switchTo().alert(); //when enter invalid credentials alert will come(failure case)
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;      //when enter valid credentials alert will not come
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = "C:\\Users\\thiru\\inetBanking_V1\\src\\test\\java\\com\\inetBanking\\testData\\Exceldata.xlsx" ;
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new  String[rownum][colcount];
		
		//row for loop
		for(int i=1; i<=rownum; i++) //i=1 -->1st index in that row
		{
			//Column for loop
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); 
				//row-1 col-0(row-0 we don't need bcz username password no need)
				// i-1 bcz we don't need row 0th index bcz it has username password we want 1st index of row
			}
		}
		return logindata;
	}
	
}
