package com.nopcommerce.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass
{
  @Test
  public void addNewCustomer() throws IOException
  {
	  logger.info("*********starting TC_addNewCustomer_003 ************");
  	    driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomersMenu();
	    addcust.clickOnCustomersMenuItem();	
	    addcust.clickOnAddNew();
	    
	  logger.info("*********adding customer details*******");
	    String email =randomeString()+"@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("12345678");
		addcust.setFirstName("Harpreet");
		addcust.setLastName("Kaur");
		addcust.setGender("Female");
		addcust.setDOB("September 8 1983");
		addcust.setCoName("blablabla");
		addcust.setTaxExemptStatus();
		addcust.setCustomerRoles("Guests");
		addcust.setManagerOfVendor("Not a vendor");
		addcust.setAdminContent("This is for testing....");
		addcust.clickOnSave();
		if(addcust.verifyConfirmationMsg())
		{
			logger.info("******customer added successfully******");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("******customer NOT added successfully******");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		logger.info("**********TC_AddCustomerTest_003 finished********");
	  
	  
  }
	
 
	
	
	
	
}
