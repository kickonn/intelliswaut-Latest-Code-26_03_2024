package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Intern {

	public String run(HashMap<String, Object> params) throws Exception {
		try{
			String text1 = Get.param(params,"Text");			
			Log.passed("Canonical representation of string "+text1+" is as follows  "+text1.intern());
			return text1.intern();
		}
		catch (Exception e) {
			Log.error("Exception caught in Intern Action, Message is " + e.getMessage());
			throw e;
		}
	}
}
