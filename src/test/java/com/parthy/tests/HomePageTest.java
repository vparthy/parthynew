package com.parthy.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parthy.base.TestBase;
import com.parthy.pageaction.ContactPageAction;
import com.parthy.pageaction.HomePageAction;
import com.parthy.pageaction.LoginPageAction;
import com.parthy.util.TestUtils;

public class HomePageTest extends TestBase	{
	
	LoginPageAction login;
	HomePageAction home;
	TestUtils testUtil;
	ContactPageAction contactsPage;
		
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialize();
		testUtil = new TestUtils();
		contactsPage = new ContactPageAction();
		login = new LoginPageAction();
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitletest(){
		String title = home.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verfiyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(home.verifyUserLabel());
	}
	
	@Test(priority=3)
	public void verfiyContactsLink() throws InterruptedException{
		testUtil.switchToFrame();
		contactsPage = home.clickConatctsLink();
	}
	
	
	/*@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}*/
	
	
	

}
