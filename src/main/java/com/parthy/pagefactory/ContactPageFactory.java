package com.parthy.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parthy.base.TestBase;

public class ContactPageFactory extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	public WebElement contactsTitle;
	
	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement fname;
	
	@FindBy(xpath = "//input[@name='middle_initial']")
	public WebElement mname;
	
	@FindBy(xpath = "//input[@name='surname']")
	public WebElement lname;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	public WebElement company;
	
	@FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	public WebElement saveBtn;
	
	public ContactPageFactory(){
		PageFactory.initElements(driver, this);
	}
	
}
