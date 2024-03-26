package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SetCheckbox {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			Wait.waitForElement(params);
			WebElement element = Elements.find(params, Browser.Driver);
			String elemName = Get.param(params, "Element Name").toString();

			if(isElementPresent(element)){
				element.click();
				Log.passed("Selected the Checkbox Successfully : "+elemName);

			}else
				Log.failed("Element is not displayed, Unable to set checkbox "+elemName);
		}
		catch (Exception e) {
			Log.failed("Exception caught in Checkbox Action, Message is " + e.getMessage());
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