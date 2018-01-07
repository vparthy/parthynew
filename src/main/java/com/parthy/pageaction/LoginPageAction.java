package com.parthy.pageaction;

import com.parthy.pagefactory.LoginPageFactory;

public class LoginPageAction extends LoginPageFactory {
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo(){
		return crmlogo.isDisplayed();
	}
	
	public HomePageAction login(String un, String pw) throws InterruptedException{
		uname.sendKeys(un);
		pword.sendKeys(pw);
		Thread.sleep(5000);
		loginbtn.click();
		return new HomePageAction();
		
		
	}
}
