package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class ToLowerCase {

	public String run(HashMap<String, Object> params) throws Exception {
		try{
			String txt = Get.param(params,"Text");				
			Log.info("String after converting to lowercase is "+txt.toLowerCase());
			return txt.toLowerCase();
		}catch (Exception e) {
			Log.error("Exception caught in ToLowerCase Action, Message is " + e.getMessage());
			throw e;

		}	
	}

}
