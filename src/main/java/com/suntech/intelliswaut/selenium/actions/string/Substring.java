package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Substring {

	public String run(HashMap<String, Object> params) throws Exception {
		try {
			String text = Get.param(params,"Text");			
			String Index = Get.param(params,"StartIndex");
			if (text != "" && Index != "") {				
				Integer Startindex = Integer.parseInt(Index);
				String returnValue = text.substring(Startindex);
				Log.info("Substring Action , SubString os the string with start index is " + returnValue);
				return text.substring(Startindex);
			}
			return null;

		} catch (Exception e) {
			Log.error("Exception caught in Substring Action, Message is " + e.getMessage());
			throw e;
		}

	}

}
