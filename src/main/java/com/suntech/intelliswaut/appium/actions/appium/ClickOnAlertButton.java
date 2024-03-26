package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class ClickOnAlertButton {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			element.click();
			Log.passed("Clicked on element "+ element );
		} catch (Exception e) {
			Log.failed("Exception caught in click Action, Exception is "+e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
}
