package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByEmail_004 extends BaseClass 
{  
	@Test
   public void searchCustomerByEmailTest() throws InterruptedException, IOException
    {
		logger.info("*********starting TC_SearchCustomerByEmailTest_004 ************");
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		//Go to search page
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomersMenu();
	    addcust.clickOnCustomersMenuItem();	
	
	    //provide email ID
	    
	    SearchCustomerPage searchcust=new SearchCustomerPage(driver);
	    searchcust.setEmail("james_pan@nopCommerce.com");
	    
	    //clicking on search button
	    searchcust.clickSearchBtn();
	    
	    Thread.sleep(3000);
	    
	    //perform search
	   boolean status =searchcust.searchByEmail("james_pan@nopCommerce.com");
	 
	    if (status==true)
	    {
	     logger.info("**********TC_SearchCustomerByEmailTest_004 is passed********");
	     Assert.assertTrue(true);
	    }
	    
	    else
	    {
	     logger.error("********TC_SearchCustomerByEmailTest_004 is failed**********"); 
	     captureScreen(driver,"searchCustomerByEmailTest");
	     Assert.assertTrue(false);
	    }
	    
	    
	    logger.info("**********TC_SearchCustomerByEmailTest_004 is finished********");
    }
	
	
	
	
}
