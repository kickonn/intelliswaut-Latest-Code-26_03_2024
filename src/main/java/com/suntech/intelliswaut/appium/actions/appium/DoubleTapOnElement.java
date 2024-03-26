package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class DoubleTapOnElement {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			String strElemName = (Get.param(params,"Element Name"));
			MobileElement element = Elements.find(params, Driver.driver);
			TouchAction touch = new TouchAction(Driver.driver);
			touch.tap(ElementOption.element(element)).tap(ElementOption.element(element)).perform();
			Log.passed("Double Tapped on element "+ strElemName);
		} catch (Exception e) {
			Log.failed("Exception caught in Tap Action, Exception is "+e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
}
