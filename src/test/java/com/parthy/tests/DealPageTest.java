package com.parthy.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.parthy.base.TestBase;
import com.parthy.pageaction.ContactPageAction;
import com.parthy.pageaction.DealsPageAction;
import com.parthy.pageaction.HomePageAction;
import com.parthy.pageaction.LoginPageAction;
import com.parthy.util.DataProviderm;
import com.parthy.util.TestUtils;

public class DealPageTest extends TestBase {
	LoginPageAction login;
	HomePageAction home;
	TestUtils testUtil;
	ContactPageAction contactsPage;
	DealsPageAction dealspage;
	String sname = "deals";
	DataProviderm testdata;
		
	public DealPageTest(){
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
		dealspage = home.clickDealsLink();
		testdata = new DataProviderm();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][];
		data = TestUtils.getTestData(sname);
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void verifyCreateNewDeals(String title, String cmp, String amnt) throws InterruptedException{
		Thread.sleep(5000);
		dealspage.clickNewDeal();
		Thread.sleep(5000);
		dealspage.createNewDeal(title, cmp, amnt);
	}
	
	
	/*@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}*/
	
	

}
