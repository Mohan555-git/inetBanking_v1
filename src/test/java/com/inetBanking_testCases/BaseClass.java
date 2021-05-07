package com.inetBanking_testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;





public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	
	public String baseURL  = rc.getApplicationURL()  ;
	public String username = rc.getUsername();
	public String password = rc.getPassword() ;
	public static WebDriver driver;
	public static Logger log;
	
	//@Parameters("browser")
	@BeforeClass
	public void setup(/*String br*/)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\thiru\\inetBanking_V1\\Drivers\\chromedriver.exe");
		    //  (or)
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	        //  (or)
		//System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");
	        //  (or)
//System.getproperty("user.dir")-->is representing the project home directory only uses in java Classes
// ./--> is representing the project home directory(dir)--> in java classes & in properties file.
//Properties file accepts only--backward-slashes(\\\).
//Java classes accepts-----forward-slashes(/////).
		
		//System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		
		
	  
		 log = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("log4j.properties");
		 
/*		
 * This code written by me to call browser directly from the config.properties(file) & 
   Readconfig.java class (in com.inetBanking.Utilities).Below this code we are calling 
   browser from testng.xml file by using parameter Annotation.
 
         if(rc.getbrowser().equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", rc.getChromePath());
				
				driver = new ChromeDriver(); 
		 }
		 else if(rc.getbrowser().equals("firefox"))
		 {
			    System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
				
				driver = new FirefoxDriver(); 
		 }
		 else if(rc.getbrowser().equals("ie"))
		 {
			    System.setProperty("webdriver.ie.driver", rc.getIEPath());
				
				driver = new InternetExplorerDriver(); 
		 }
		 
		 */
// This code we are calling browser from testng.xml file by using parameter Annotation.
		 
		 String br = System.getProperty("browser");
		      
         if(br.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", rc.getChromePath());
				
				driver = new ChromeDriver(); 
		 }
		 else if(br.equals("firefox"))
		 {
			    System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
				
				driver = new FirefoxDriver(); 
		 }
		 else if(br.equals("ie"))
		 {
			    System.setProperty("webdriver.ie.driver", rc.getIEPath());
				
				driver = new InternetExplorerDriver(); 
		 }
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(baseURL);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	// Screenshot code written using Listeners class
//	public void captureScreen(String result) throws IOException
//	{
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//Screenshots//"+result+".png"));
//	}
	
	// Screenshot code written using Reporting.java class 
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//Screenshots//"+tname+".png"));
		System.out.println("Screenshot Taken");
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return(generatedString);
	}
	
	public static String  randomNum()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}

}
