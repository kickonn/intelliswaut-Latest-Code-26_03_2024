package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class IsElementDisplayed {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			WebElement element = Elements.find(params, Browser.Driver);
			 
         Log.passed("Element is displayed " +  element.isDisplayed());
		} catch (Exception e) {

			Log.failed("Unable to find Element ");
			//return (Boolean) null;
			throw e;
		}
	}
}
