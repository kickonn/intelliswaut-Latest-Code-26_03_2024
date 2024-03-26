package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
	
public class EnterText {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
			
		    MobileElement element = Elements.find(params, Driver.driver);	
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