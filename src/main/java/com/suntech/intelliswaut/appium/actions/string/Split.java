package com.suntech.intelliswaut.appium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Split {

	public String run(HashMap<String, Object> params) throws Exception {
		try {

			String text1 = Get.param(params,"Text");
			String regex = Get.param(params,"Regex");
			String Index = Get.param(params,"Index");
			if(text1.equals("")||regex.equals("")||Index.equals("")){
				Log.error("Split Action , Parameter Text, Regex,Index cant be null");
				return null;
			}
			String[] arrRes = text1.split(regex);
			Integer index = Integer.parseInt(Index);
			String returnValue = arrRes[index];
			Log.info("Split Action , String returned after spliting is " + returnValue);
			return returnValue;
		} catch (Exception e) {
			Log.error("Exception caught in Split Action, Message is " + e.getMessage());
			return null;
		}

	}

}
