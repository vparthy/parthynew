package com.parthy.pageaction;

import org.openqa.selenium.interactions.Actions;

import com.parthy.pagefactory.DealsPageFactory;

public class DealsPageAction extends DealsPageFactory{
	
	public void clickNewDeal(){
		Actions action = new Actions(driver);
		action.moveToElement(deals).build().perform();
		newdeal.click();		
	}

	public void createNewDeal(String title, String company, String amount){
		dealtitle.clear();
		dealtitle.sendKeys(title);
		dealcmp.clear();
		dealcmp.sendKeys(company);
		dealamnt.clear();
		dealamnt.sendKeys(amount);
		dealsave.click();
				
	}
}
