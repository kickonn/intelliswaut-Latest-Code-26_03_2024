package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Concat {
	
	
	public String run(HashMap<String, Object> params) throws Exception {
		try{
			String text1 = Get.param(params,"Text1");
			String text2 = Get.param(params,"Text2");
			
			if(text1.equals("")){
				Log.error("Concat Action , Paramter Text1 cant be null");
				return null;
			}

			if(text2.equals("")){
				Log.error("Concat Action , Paramter Text2 cant be null");
				return null;
			}	
			Log.info("Concatenated the 2 Strings successfully");
			return text1.concat(text2);				
		}
		catch (Exception e) {
			Log.error("Exception caught in Concat Action, Message is " + e.getMessage());
			throw e;
		}
	
	
}
	

}
