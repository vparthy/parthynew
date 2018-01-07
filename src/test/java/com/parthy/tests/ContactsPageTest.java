package com.parthy.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.parthy.base.TestBase;
import com.parthy.pageaction.ContactPageAction;
import com.parthy.pageaction.HomePageAction;
import com.parthy.pageaction.LoginPageAction;
import com.parthy.util.TestUtils;

public class ContactsPageTest extends TestBase {
	
	LoginPageAction login;
	HomePageAction home;
	TestUtils testUtil;
	ContactPageAction contactsPage;
	String sname = "contacts";
		
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialize();
		testUtil = new TestUtils();
		contactsPage = new ContactPageAction();
		login = new LoginPageAction();
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = home.clickConatctsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabel() throws InterruptedException{
		Thread.sleep(3000);
		boolean flag = contactsPage.verifyContactsLabel();
		Assert.assertTrue(flag, "Contacts label missing");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][];
		data = TestUtils.getTestData(sname);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void verifyCreateNewContact(String title, String firstname, String middlename, String lastname, String company) throws InterruptedException{
		home.clickNewContact();
		Thread.sleep(10000);
		//contactsPage.createNewContact("Mr.", "Magil", "MP","Oviya", "Microsoft");
		contactsPage.createNewContact(title, firstname, middlename, lastname, company);
		
		
	}
	
	
	/*@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}*/
	
	

}
