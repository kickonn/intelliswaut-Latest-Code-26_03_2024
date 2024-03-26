package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyAttribute{

	public void run(HashMap<String, Object> params) throws Exception{
		try{
			WebElement element = Elements.find(params,Browser.Driver);
			String value =Get.param(params,"Value");
			String attrName =Get.param(params,"Attribute Name");
			String actAttrVal = element.getAttribute(attrName); 
			if(value.equalsIgnoreCase(actAttrVal))
				Log.passed("Value "+ actAttrVal +" of the attribute "+ value + " is matched with the expected value");

			else
				Log.failed("Value "+ actAttrVal +" of the attribute " + value  + " is not  matched with the expected value");

		}catch(Exception e) {
			Log.failed("Exception caught while Verifying the Attribute, Message is "+e.getMessage());
			throw e;
		}
	}
}