package com.inetBanking_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
    WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Page Object contains only Page-elements & Action-Methods
	
	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	@CacheLookup
	WebElement lnkAddCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomername;
	
	@FindBy(how = How.NAME, using = "rad1")   // Page-elements
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpincode;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephone;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailId;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickAddNewCustomer()
	{
		lnkAddCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomername.sendKeys(cname);  // Action-Methods
	}
	
	public void custGender(String cgender)
	{
		rdGender.click();
	}
	
	public void custDOB(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void custStATE(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custPincode(String cpincode)
	{
		txtpincode.sendKeys(String.valueOf(cpincode));
	}
	
	public void custTelephoneNO(String ctelephoneno)
	{
		txttelephone.sendKeys(ctelephoneno);
	}
	
	public void custEmailID(String cemailID)
	{
		txtemailId.sendKeys(cemailID);
	}
	
	public void custPassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	
	public void custSubmit()
	{
		btnsubmit.click();
	}
}
