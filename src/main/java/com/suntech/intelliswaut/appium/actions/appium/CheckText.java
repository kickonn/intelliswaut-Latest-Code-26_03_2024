package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

/**
 * Created by dinkark on 13-Oct-2016
 */
 public class CheckText {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			String strText = (Get.param(params,"Text"));
			String strElemName = (Get.param(params,"Element Name"));
			MobileElement element = Elements.find(params, Driver.driver);
			String strValue = element.getText();
			if(strValue.trim().equalsIgnoreCase((Get.param(params,"Text")))) {
				Log.passed("Element "+strElemName+" has the text as expected "+ strText);
			}else {
				Log.failed("Element "+strElemName+" does not have the text as expected, Actual is "+strValue+", but expected is "+ strText);
			}
		}catch(Exception e) {
			Log.failed("Exception caught in Check Text Action, Exception is "+e.getMessage());
			throw e;
		}
	}
}

//(Get.param(params,"text"))