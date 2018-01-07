package com.parthy.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parthy.base.TestBase;

public class HomePageFactory extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'User: Parthiban V')]")
	public WebElement usernameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	public WebElement contacts;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	public WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	public WebElement tasks;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	public WebElement newcontact;
	
	
	public HomePageFactory(){
		PageFactory.initElements(driver, this);
	}
}
