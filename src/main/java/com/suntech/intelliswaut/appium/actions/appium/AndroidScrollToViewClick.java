package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.android.AndroidDriver;

public class AndroidScrollToViewClick {
	public void run(HashMap<String, Object> params) throws Exception {
		try {

			String ScrollToElementText = (Get.param(params,"ScrollToElementText"));
			if(ScrollToElementText!=null && (Driver.driver)!=null) {
			((AndroidDriver)Driver.driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ ScrollToElementText + "\").instance(0))")
					.click();
			Thread.sleep(1000);
			}
			Log.passed("Scroll to view element and click");

		} catch (Exception e) {

			Log.failed("Exception caught while Scrolling to view click");
			throw e;
		}
	}
}
