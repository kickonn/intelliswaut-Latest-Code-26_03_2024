package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SendKeys {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
		WebElement element = Elements.find(params, Browser.Driver);
			if(params.get("Text") != null) {
				element.clear();//newly inserted
				element.sendKeys(params.get("Text").toString());
				Log.passed("Entered the text in the input box successfully "+params.get("Text").toString());
			}
		} catch (Exception e) {
			Log.failed("Exception caught in SendKeys method" + e.getMessage());
			throw e;
		}
	}
}

 