package com.nopcommerce.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
   
	public WebDriver driver;
	public Properties configPropObj;
	public Logger logger=LogManager.getLogger(this.getClass());
    
    @BeforeClass
    @Parameters("browser")
	public void setUp(String br) throws IOException
	{
    	//load config (reading mode)properties file 
    	configPropObj=new Properties();
		FileInputStream configFile=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
        configPropObj.load(configFile);
    	
    	//Opens browser
        if(br.equals("chrome"))
         {
    	   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
         }
        else if(br.equals("firefox"))
         {
           WebDriverManager.firefoxdriver().setup();
 		   driver=new FirefoxDriver();
         }
        else if(br.equals("ie"))
        {
          WebDriverManager.iedriver().setup();//not working
         System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+("//Drivers//IEDriverServer.exe"));
		   driver=new InternetExplorerDriver();
        }
        
        //Global implicit wait
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        
        //to maximize browser window
        driver.manage().window().maximize();
		
	}
	
    @AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  File target=new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
	  FileUtils.copyFile(source,target);
	  System.out.println("screenshot taken");
	}
	
	 public String randomeString()
	  {
		  String generatedString1=RandomStringUtils.randomAlphabetic(5);
		  return (generatedString1);
	  }
	  
	  
	  public String randomeNum()
	  {
		  String generatedString2=RandomStringUtils.randomNumeric(5);
		  return (generatedString2);
	  }
	  
}
