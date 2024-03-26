package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Equals {
	public boolean run(HashMap<String, Object> params) throws Exception {
		try{
				String text1 = Get.param(params,"Text1");
			    String text2 = Get.param(params,"Text2");	


			if(text1.equals(text2)){
				Log.passed("Text1 is "+text1 + " and Text2 is "+text2  +" , Text1 Equals Text2");
				return true;
			}else{
				Log.failed("Text1 is "+text1 + " and Text2 is "+text2  +" , Text1 does not Equals Text2");
				return false;
			}			
		}
		catch (Exception e) {
			Log.error("Exception caught in EqualsIgnoreCase Action, Message is " + e.getMessage());
			throw e;
		}
	
	
}
}
