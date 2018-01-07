package com.parthy.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parthy.base.TestBase;

public class LoginPageFactory extends TestBase {

	@FindBy(name = "username")    
    public WebElement uname;
	
	@FindBy(name = "password")    
	public WebElement pword;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement loginbtn;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	public WebElement signupbtn;
	
	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
	public WebElement crmlogo;
	


	public LoginPageFactory(){
		PageFactory.initElements(driver, this);
	}
	
}


