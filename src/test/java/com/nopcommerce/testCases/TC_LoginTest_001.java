package com.nopcommerce.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;
public class TC_LoginTest_001 extends BaseClass
{
    
    @Test
	public void loginTest() throws IOException, InterruptedException
	{
    	logger.info("*********starting TC_LoginTest_001 ************");
    	driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("*********providing login details to the application************");
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		
		logger.info("*********clicking on login button************");
		lp.clickLogin();
		String act_Title=driver.getTitle();
		String exp_Title="Dashboard / nopCommerce administration";
		
		logger.info("*********Login validation starting************");
		if(act_Title.equals(exp_Title))
		{
		    logger.info("*********Login Test passed************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("*********Login Test failed************");
			captureScreen(driver,"loginTest");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
	
}
