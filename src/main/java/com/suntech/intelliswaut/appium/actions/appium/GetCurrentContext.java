package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class GetCurrentContext {
	public void run(HashMap<String, Object> params) {
		try {

			String contextName = (Driver.driver).getContext();

			Log.passed("context name is " +  contextName);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		//return "";
	}
}
