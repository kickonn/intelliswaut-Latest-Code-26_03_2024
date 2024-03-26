package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;


public class EnterEncryptedText {

	public void run(HashMap<String, Object> params) throws Exception
	{
		try {
		
			WebElement element = Elements.find(params,Browser.Driver);
			
		//   Base64.Decoder decoder = Base64.getDecoder();
	    //  String str = decoder.decode(params.get("Text").toString()).toString();
			
			Decoder decoder = Base64.getDecoder();
	        byte[] bytes = decoder.decode(params.get("Text").toString());
	 		 String str = (new String(bytes));
			
			if(isElementPresent(element)){
				element.sendKeys(str);
				Log.passed("Entered the encrypted text in element");
			}
		}catch (Exception e) {
			Log.failed("Exception caught in Enter Encrypted Text Action, Message is "+e.getMessage());
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
