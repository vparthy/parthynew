package com.parthy.pageaction;

import org.openqa.selenium.interactions.Actions;

import com.parthy.pagefactory.HomePageFactory;

public class HomePageAction extends HomePageFactory{
	
	public String verifyHomePageTitle(){
		return driver.getTitle();	
	}
	
	public boolean verifyUserLabel(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usernameLabel.isDisplayed();
	}
	
	public ContactPageAction clickConatctsLink() throws InterruptedException{
		Thread.sleep(10000);
		contacts.click();
		return new ContactPageAction(); 
	}
	
	public DealsPageAction clickDealsLink(){
		deals.click();
		return new DealsPageAction(); 
	}
	
	public ContactPageAction clickNewContact(){
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newcontact.click();
		return new ContactPageAction(); 
	}
}
