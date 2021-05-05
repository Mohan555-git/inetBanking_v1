package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public Properties prop ;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch(Exception e) {
			
			System.out.println("Exception is" + e.getMessage());
		}
		
		
	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL") ;	
		return url;
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username ;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password ;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath ;
	}
	
	public String getIEPath()
	{
		String iepath = prop.getProperty("iepath");
		return iepath ;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath ;
	}
	
// This code written by me to call browser directly from the config.properties(file) &-- 
// Readconfig.java class (in com.inetBanking.Utilities) to open which browser you --
// want	when you change browser name in config.properties(file) that browser will open--
// to execute test cases.	
	public String getbrowser()
	{
		String browser = prop.getProperty("browser");
		return browser ;
	}
	

}
