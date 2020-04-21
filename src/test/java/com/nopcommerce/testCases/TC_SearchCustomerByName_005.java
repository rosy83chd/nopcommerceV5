package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass 
{  
	@Test
   public void searchCustomerByNameTest() throws InterruptedException, IOException
    {
		logger.info("*********starting TC_SearchCustomerByName_005 ************");
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		//Go to search page
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomersMenu();
	    addcust.clickOnCustomersMenuItem();	
	
	    //provide first name
	    
	    SearchCustomerPage searchcust=new SearchCustomerPage(driver);
	    searchcust.setFirstName("James");
	    
	    //provide last name
	    searchcust.setLastName("Pan");
	    
	    //clicking on search button
	    searchcust.clickSearchBtn();
	    
	    Thread.sleep(3000);
	    
	    //perform search
	   boolean status =searchcust.searchByName("James Pan");
	 
	    if (status==true)
	    {
	     logger.info("**********TC_SearchCustomerByNameTest_005 is passed********");
	     Assert.assertTrue(true);
	    }
	    
	    else
	    {
	     logger.error("********TC_SearchCustomerByNameTest_005 is failed**********"); 
	     captureScreen(driver,"searchCustomerByNameTest");
	     Assert.assertTrue(false);
	    }
	    
	    
	    logger.info("**********TC_SearchCustomerByNameTest_005 is finished********");
    }
	
	
	
	
}
