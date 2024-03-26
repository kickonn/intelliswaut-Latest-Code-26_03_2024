package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyTextInElement {
	public String run(HashMap<String, Object> params) throws Exception {
		String text = "";
		try{
			String expText = Get.param(params,"Text").toString();
			String verify = Get.param(params,"Verify").toString();
			WebElement element = Elements.find(params, Browser.Driver);
			try {
				if(verify.equalsIgnoreCase("value")) {
					text = element.getAttribute("value");
				}else {
					text = element.getText();
				}
				Log.passed("Retrieved text from WebElement , "+text);				
			} catch (Exception err) {
				text =  (String) ((JavascriptExecutor) Browser.Driver).executeScript(
				        "return jQuery(arguments[0]).text();", element);
				Log.passed("Retrieved text from WebElement , "+text);				
				throw err;
			}
			if(text.contains(expText)) {
				Log.passed("Expected text is displayed in WebElement , "+text);
			}else {
				Log.failed("Expected text is not displayed in WebElement Expected is "+expText+ ", Actual is "+text);
			}
		}catch(Exception e){
			Log.failed("Exception caught in VerifyTextInElement Action, Message is "+e.getMessage());			
			throw e;
		}	
		return text;
	}
}
