package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class SetCurrentContext {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			String contextName =(Get.param(params,"Context Name"));
			(Driver.driver).context(contextName);
			Log.passed("Context Name set successfully " + contextName);
		} 
		catch (Exception e) {
			Log.failed("Exception caught " + e.getMessage());
			//e.printStackTrace();
			throw e;
		}
	}
}
