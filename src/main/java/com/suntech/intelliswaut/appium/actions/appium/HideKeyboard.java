package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
public class HideKeyboard {

	public void run(HashMap<String, Object> params) throws Exception {
		MobileElement element = Elements.find(params, Driver.driver);
		try {
			(Driver.driver).hideKeyboard();
		Log.passed("Keyboard Hidden successfully");

		} catch (Exception e) {			
			Log.failed("Mobile Keyboard is not hide " + e.getMessage());
			throw e;
		}

}
	
}
