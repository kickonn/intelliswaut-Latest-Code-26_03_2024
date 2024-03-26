package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Click {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
			WebElement element = Elements.find(params, (WindowsDriver<WebElement>) WindowApp.driver);
			String elemName =  Get.param(params, "Element Name");	
			if(isElementPresent(element)){
				element.click();
				Log.passed("Clicked on "+elemName);
	
				Thread.sleep(1000);
			}else {
				Log.failed("Unable to click on the element "+elemName+ ", Element not found");
			}
		} catch (Exception err) {
			String elemName =  Get.param(params, "Element Name");	
			Log.error("Unable to click on element "+elemName + ", Exception is "+err.getMessage());
			throw err;
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
