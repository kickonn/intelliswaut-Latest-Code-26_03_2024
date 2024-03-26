package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;


public class ClearText{
	public boolean run(HashMap<String, Object> params) throws Exception{
		try {
			Wait.waitForElement(params);
			WebElement element = Elements.find(params,Browser.Driver);
			String elemName =  Get.param(params, "Element Name");			
			if(isElementPresent(element)){
				element.clear();
				Log.passed("Cleared the text from the element " + elemName);
				return true;
			}else{
				Log.failed("Element is not displayed, Unable to Clear text "+elemName);
				return false;
			}
		}catch(Exception e) {
			Log.failed("Exception caught while Clearing text, Message is "+e.getMessage());
			
			return false;
			
		}
	}


	public boolean isElementPresent(WebElement we) {
		try {
			Thread.sleep(1000);
			we.isDisplayed();
			Log.passed("Element is displayed");
			return true;
		}catch(Exception ex){
			return false;
		}	
	}
}