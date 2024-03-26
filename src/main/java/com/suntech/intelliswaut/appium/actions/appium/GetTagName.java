package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class GetTagName {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			Log.passed("Tag name is " + element.getTagName());
		} catch (Exception e) {

			Log.failed("Exception caugth in Tag name");
			//return null;
			throw e;
		}
	}
}
