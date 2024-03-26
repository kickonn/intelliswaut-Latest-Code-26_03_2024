package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Click {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
		//	Wait.waitForElement(params);
			WebElement element = Elements.find(params, Browser.Driver);
			String elemName =  Get.param(params, "Element Name");			
			if(isElementPresent(element)) {
				try {
					element.click();
					Log.passed("Clicked on the Element "+elemName);				
				} catch (WebDriverException err) {
					JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
					js.executeScript("arguments[0].click();",element);
					Log.passed("Clicked on the Element "+elemName);
				}
			}else {
				Log.failed("Unable to click on the element "+elemName+ ", Element not found");
			}
		}catch(Exception e){
			Log.failed("Exception caught while clicking on element "+e.getMessage());
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
