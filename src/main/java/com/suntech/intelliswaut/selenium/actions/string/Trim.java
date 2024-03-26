package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Trim {

	public String run(HashMap<String, Object> params) throws Exception {
		try{
			String txt = Get.param(params,"Text");			
			return txt.trim();
		}catch (Exception e) {
			Log.error("Exception caught in Trim Action, Message is " + e.getMessage());
			throw e;
		}
	}
}
