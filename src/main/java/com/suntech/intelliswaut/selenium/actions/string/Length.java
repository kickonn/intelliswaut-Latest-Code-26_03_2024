package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Length {

	public int run(HashMap<String, Object> params) throws Exception {
		try {
			String text1 = Get.param(params,"Text");						
			Log.info("Length of the string is " + text1.length());
			return text1.length();			
		} catch (Exception e) {
			Log.error("Exception caught in Length Action, Message is " + e.getMessage());
			throw e;
		}

	}
}