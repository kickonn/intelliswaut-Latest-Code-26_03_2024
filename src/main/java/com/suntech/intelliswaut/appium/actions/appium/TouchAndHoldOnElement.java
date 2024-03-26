package com.suntech.intelliswaut.appium.actions.appium;


import java.time.Duration;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class TouchAndHoldOnElement {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			String durationString = (Get.param(params,"Duration"));
			Integer duration = Integer.parseInt(durationString);
			TouchAction touch = new TouchAction(Driver.driver);
			touch.press(ElementOption.element(element))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration))).perform();
			Log.passed("Touch and Hold Action is done on Element");
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			Log.failed("Element not found");
			throw e;
		}
	}
}
