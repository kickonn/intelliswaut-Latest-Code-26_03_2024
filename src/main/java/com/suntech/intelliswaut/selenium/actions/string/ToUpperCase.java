package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class ToUpperCase{

	public String run(HashMap<String, Object> params) throws Exception {
		try{
			String txt = Get.param(params,"Text");				
			Log.info("String after converting to UpperCase is "+txt.toUpperCase());									
			return txt.toUpperCase();
		}catch (Exception e) {
			Log.error("Exception caught in ToUpperCase Action, Message is " + e.getMessage());
			throw e;

		}
	}

}

