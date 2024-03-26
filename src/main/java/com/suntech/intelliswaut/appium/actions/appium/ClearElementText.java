package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class ClearElementText {
	public void run(HashMap<String, Object> params) {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			element.clear();
			Log.passed("Text is cleared");
		} catch (Exception e) {
			Log.info(e.getMessage());
			//e.printStackTrace();
			throw e;
		}
	}
}
