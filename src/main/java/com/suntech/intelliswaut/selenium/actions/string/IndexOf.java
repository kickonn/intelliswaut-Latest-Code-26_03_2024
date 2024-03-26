package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class IndexOf {

	public int run(HashMap<String, Object> params) throws Exception {
		try {
			String text1 = Get.param(params,"Text");
			String Character = Get.param(params,"Character");
			Log.info("Text1 is "+text1 + " and Character is "+Character +" , Character found at index "+text1.indexOf(Character));
			return text1.indexOf(Character);			
		} catch (Exception e) {
			Log.error("Exception caught in EqualsIgnoreCase Action, Message is " + e.getMessage());
			throw e;
		}

	}

}
