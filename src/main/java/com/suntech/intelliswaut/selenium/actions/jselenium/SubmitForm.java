package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class SubmitForm {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			Wait.waitForElement(params);
			WebElement element = Elements.find(params, Browser.Driver);			
			if(isElementPresent(element)){
				element.submit();
				Log.passed("Submitted form successfully");
				
			}else{
				Log.failed("Element is not displayed, Unable to Submit ");
				
			}
			
		}
		catch (Exception e) {
			Log.failed("Exception caught while clicking on submit button, Message is " + e.getMessage());
			throw e;
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


  

