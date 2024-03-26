package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GetText {
	public String run(HashMap<String, Object> params) throws Exception {
		String text = null;
		try{
			Wait.waitForElement(params);
			WebElement element = Elements.find(params, Browser.Driver);
			int iTimeout = 20;
			text = element.getText();
			Log.passed("Retrieved the text from the element : "+text);
			return text;
		}catch (Exception e) {	
			Log.failed("Exception caught in GetText Action " + e.getMessage());
			return "";
		}
	}
}
