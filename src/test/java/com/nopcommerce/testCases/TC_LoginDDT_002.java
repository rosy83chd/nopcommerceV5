package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
   public void loginTest(String user,String pwd, String exp) throws InterruptedException
     {
		logger.info("*********starting TC_LoginDDT_002 ************");
    	driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		Thread.sleep(4000);
		String act_Title=driver.getTitle();
		String exp_Title="Dashboard / nopCommerce administration";
		
		if (act_Title.equals(exp_Title))
		  {
			if (exp.equals("pass"))
			  {
				logger.info("**********login test passed**********");
				lp.clickLogout();
				Assert.assertTrue(true);	
			  }
			
			else if(exp.equals("fail"))
			  {
				logger.warn("**********login test failed*********");
				lp.clickLogout();
				Assert.assertTrue(false);
			  }
 
		  }
		else if(!act_Title.equals(exp_Title))
		  {
			if (exp.equals("pass"))
			  {
				logger.warn("**********login test failed**********");
				Assert.assertTrue(false);	
			  }
			
			else if(exp.equals("fail"))
			  {
				logger.info("**********login test passed***********");
				Assert.assertTrue(true);
			  }

		  }
		logger.info("**************finished TC_LoginDDT_002********");
     }
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\TestData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
	    int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	    String logindata[][]=new String [rownum][colcount];
	    
	    for(int i=1;i<=rownum;i++)
	     {
	    	for(int j=0;j<colcount;j++)
	    	  {
	    		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
	    	  }
	     }
	    return logindata;
	}
	
	
}
