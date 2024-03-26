package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class ClickOnSubMenu {
	public void run(HashMap<String, Object> params) throws Exception {		
		WebElement element1 = Elements2.find1(params, Browser.Driver);
		try{
			String strMain = element1.toString();			
			if(isElementPresent(element1)){
				Actions action = new Actions(Browser.Driver);
				action.moveToElement(element1).click().perform();			
				Log.passed("Hover over the Main menu item successfully");
			}else{
				Log.failed("Unable to hover Main menu(Element is not displayed), Expected Property of element is->"+strMain);
			}
		}catch(Exception Ex){
			Log.failed("Exception Caught while hoverOver the main menu Item,Message is->"+Ex.getMessage());
			throw Ex;
		}
		WebElement element2 = Elements2.find2(params, Browser.Driver);
		try{
			String strSub = element2.toString();
			
			if(isElementPresent(element2)){				
				element2.click();
				Log.passed("Clicked on the Sub menu item successfully");
			}else{
				Log.failed("Sub Menu Element is not displayed, Expected Property of element is->"+strSub);
			}
		}catch(Exception ex){
			Log.failed("Unable to Click on Sub menu Item,Exception is->"+ex.getMessage());
			throw ex;
		}	
	}
	
	public boolean isElementPresent(WebElement we) {
		try {
			Thread.sleep(1000);
			we.isDisplayed();
			return true;
		}catch(Exception ex){
			return false;
		}	
	}
}
