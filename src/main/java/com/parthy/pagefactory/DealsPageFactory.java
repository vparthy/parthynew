package com.parthy.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parthy.base.TestBase;

public class DealsPageFactory extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	@CacheLookup
	public WebElement deals;
	
	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	public WebElement newdeal;
	
	@FindBy(xpath = "//input[@id='title']")
	public WebElement dealtitle;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	public WebElement dealcmp;
	
	@FindBy(xpath = "//input[@name='amount']")
	public WebElement dealamnt;
	
	@FindBy(xpath = "//*[@id='prospectForm']/table/tbody/tr[1]/td/input[1]")
	public WebElement dealsave;
	
	
	
	public DealsPageFactory(){
		PageFactory.initElements(driver, this);
	}


}
