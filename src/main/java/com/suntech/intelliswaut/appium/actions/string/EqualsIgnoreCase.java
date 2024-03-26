package com.suntech.intelliswaut.appium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class EqualsIgnoreCase {
	
	public boolean run(HashMap<String, Object> params) throws Exception {
		try{
			String text1 = Get.param(params,"Text1");
			String text2 = Get.param(params,"Text2");		
			if(text1.equalsIgnoreCase(text2)){
				Log.info("Both the values are equal as expected - "+text1);
				return true;
			}else{
				 Log.error("Both the values are not equal, Actual is "+text1 + " , But expected is "+text2);
				return false;
			}			
		}
		catch (Exception e) {
			Log.error("Exception caught in EqualsIgnoreCase Action, Message is " + e.getMessage());
			return false;
		}
	
	
}
}
