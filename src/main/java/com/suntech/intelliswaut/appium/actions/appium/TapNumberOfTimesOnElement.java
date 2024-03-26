package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class TapNumberOfTimesOnElement {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			TouchAction touch = new TouchAction(Driver.driver);
			int noOfTimes = Integer.parseInt(Get.param(params,"NumOftimes"));
			Log.info("Number Of Times = "+noOfTimes);
			for (int i = 0; i < noOfTimes; i++) {
				touch.tap(ElementOption.element(element)).perform();
			}
			Log.passed("Tapped on the element " +noOfTimes + " Times");
			
		} catch (NumberFormatException e) {

			Log.failed("Element not found");
		}
	}

}