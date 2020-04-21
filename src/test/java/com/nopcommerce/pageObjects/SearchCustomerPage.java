package com.nopcommerce.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{
    public WebDriver ldriver;
    
   public SearchCustomerPage(WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(ldriver,this);
    	ldriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
    }
	@FindBy(how=How.XPATH, using="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.XPATH,using="//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID,using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"customers-grid\"]")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"customers-grid\"]/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"customers-grid\"]/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	//Action methods
	
	public void setEmail(String email)
	{
	    txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
     txtEmail.clear();
	 txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtEmail.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void clickSearchBtn()
	{
		btnSearch.click();
	}
	
	public int getNoOfRows()
	{
		return(tableRows.size());
	}
	
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	
	public boolean searchByEmail(String email)
	{
		boolean flag1=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailID=ldriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
			if (emailID.equals(email))
			{
				flag1=true;
				break;
			}
		}
		return flag1;
	}
	
	public boolean searchByName(String Name)
	{
		boolean flag2=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name=ldriver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr['+i+']/td[3]")).getText();
			if (name.equals(Name))
			{
				flag2=true;
				break;
			}
			
		}
		return flag2;
	}
	
	
	
	
	
	
	
	
	
}
