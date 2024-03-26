package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class VerifyElementAttribute
{
	  
	  public void run(HashMap<String, Object> params) throws Exception{
        try{
	    MobileElement element= Elements.find(params, Driver.driver);
	    if((params.get("Value").toString()).equalsIgnoreCase(element.getAttribute((String) params.get("Attribute Name"))))
		    	Log.passed("Value "+ element.getAttribute((String) params.get("Attribute Name"))+" of the attribute "+ params.get("Value") + " is matched with the expected value");
		    	
		    else
		    	Log.failed("Value "+ element.getAttribute((String) params.get("Attribute Name"))+" of the attribute " +params.get("Value") + " is not  matched with the expected value");
	    
	  }catch(Exception e) {
			Log.failed("Exception caught while Verifying the Attribute, Message is "+e.getMessage());
			throw e;
		}
	}
}