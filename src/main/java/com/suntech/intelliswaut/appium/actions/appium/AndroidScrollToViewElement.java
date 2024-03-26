package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.android.AndroidDriver;

public class AndroidScrollToViewElement {
	public void run(HashMap<String, Object> params) throws Exception {
		try {

			String ScrollToElementText = (Get.param(params,"Element Name"));
			if(ScrollToElementText!=null && (Driver.driver)!=null) {
			((AndroidDriver)Driver.driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ ScrollToElementText + "\").instance(0))");
			Thread.sleep(1000);
			
			
			}
			
          Log.passed("scroll to the view Element " + ScrollToElementText);
		} catch (Exception e) {

			Log.failed("Exception caught in ScrolltoViewElement" +e.getMessage());
			throw e;
		}
	}
}
