package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class VerifyTextInElement {
	public String run(HashMap<String, Object> params) throws Exception {
		String text = "";
		try{
			String expText = Get.param(params,"Text").toString();
			String verify = Get.param(params,"Verify").toString();
			MobileElement element = Elements.find(params, Driver.driver);
			try {
				if(verify.equalsIgnoreCase("value")) {
					text = element.getAttribute("value");
				}else {
					text = element.getText();
				}
				Log.passed("Retrieved text from Mobile Element , "+text);				
			} catch (Exception err) {
				text =  (String) ((JavascriptExecutor) Driver.driver).executeScript(
				        "return jQuery(arguments[0]).text();", element);
				Log.passed("Retrieved text from Mobile Element , "+text);				
	
			}
			if(text.contains(expText)) {
				Log.passed("Expected text is displayed in Mobile Element , "+text);
			}else {
				Log.failed("Expected text is not displayed in Mobile Element Expected is "+expText+ ", Actual is "+text);
			}
		}catch(Exception e){
			Log.failed("Exception caught in VerifyTextInElement Action, Message is "+e.getMessage());			
			throw e;
		}	
		return text;
	}
}
