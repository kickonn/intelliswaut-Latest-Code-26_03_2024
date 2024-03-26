package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class DragAndDrop {
	public void run(HashMap<String, Object> params) throws Exception {
		WebElement element1 = Elements2.find1(params, Browser.Driver);
		WebElement element2 = Elements2.find2(params, Browser.Driver);
		try{
			if(!isElementPresent(element1)){
				Log.failed("Unable to perform DragAndDrop ,Source element is not displayed");
				return;
			}
			if(!isElementPresent(element2)){
				Log.failed("Unable to perform DragAndDrop, Destination element is not displayed");
				return;
			}
			
			new Actions(Browser.Driver).dragAndDrop(element1, element2).perform();			
			Log.passed("Draged Source element and droped on Destination Element Successfully");
		}catch(Exception ex){
			Log.failed("Exception caught in Drag and Drop action "+ex.getMessage());
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
