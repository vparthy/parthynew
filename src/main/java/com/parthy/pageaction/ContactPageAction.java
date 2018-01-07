package com.parthy.pageaction;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.parthy.pagefactory.ContactPageFactory;

public class ContactPageAction extends ContactPageFactory {
	
	public boolean verifyContactsLabel(){
		return contactsTitle.isDisplayed();
	}
	
	public void createNewContact(String title, String fn, String mn, String ln, String cmp) throws InterruptedException{
		//Thread.sleep(20000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		fname.sendKeys(fn);
		mname.sendKeys(mn);
		lname.sendKeys(ln);
		company.sendKeys(cmp);
		saveBtn.click();
		
		
	}

}
