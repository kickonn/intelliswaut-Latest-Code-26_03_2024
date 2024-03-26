package com.suntech.intelliswaut.appium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class ReplaceChar {

	public String run(HashMap<String, Object> params) throws Exception {
		try {
			String text1 = Get.param(params,"Text");
			String oldChar = Get.param(params,"OldChar");
			String newChar = Get.param(params,"NewChar");
			if(text1.equals("")){
				Log.error("Replace Action , Parameter Text cant be null");
				return null;
			}
			String str = text1.replace(oldChar, newChar);
            Log.info("String after replacing the Character sequence is "+str);

			return str;

		} catch (Exception e) {
			Log.error("Exception caught in Replace Character Action, Message is " + e.getMessage());
			return null;
		}

	}

}
