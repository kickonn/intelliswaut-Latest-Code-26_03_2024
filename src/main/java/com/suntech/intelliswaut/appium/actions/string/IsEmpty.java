package com.suntech.intelliswaut.appium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class IsEmpty {
	public boolean run(HashMap<String, Object> params) throws Exception {
		try {
			String txt = Get.param(params,"Text");			
			boolean flag = txt.isEmpty();
			return flag;
		} catch (Exception e) {
			Log.error("Exception caught in IsEmpty Action, Message is " + e.getMessage());
			return false;
		}

	}
}
