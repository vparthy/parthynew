package com.parthy.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parthy.base.TestBase;
import com.parthy.pageaction.LoginPageAction;

public class LoginPageTest extends TestBase{
	
	LoginPageAction login;
	
	//String bowserName = "firefox";
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		login = new LoginPageAction();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLogotest(){
		boolean flag = login.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}*/
	
	
}
